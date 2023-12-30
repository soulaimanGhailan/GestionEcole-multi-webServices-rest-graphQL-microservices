package devops.proj.fillierservice.webClients.impls;

import devops.proj.fillierservice.model.Picture;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
@Component
public class StudentRestClientImpl implements StudentRestClient {
    private RestTemplate restTemplate ;
    private String URL = "http://localhost:8085/students";

    public StudentRestClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Student findStudentById(Long studentId) {
        return this.restTemplate.getForObject(String.format("%s/id/%d", URL, studentId), Student.class);
    }

    @Override
    public Student findStudentByCne(String cne) {
        return this.restTemplate.getForObject(String.format("%s/cne/%s", URL, cne), Student.class);
    }

    @Override
    public Student saveStudent(Student student) {
        ResponseEntity<Student> studentResponseEntity = this.restTemplate.postForEntity(URL, getHttpEntity(student), Student.class);
        return studentResponseEntity.getBody() ;
    }

    @Override
    public void updateStudent(Student student) {
         this.restTemplate.put(URL , getHttpEntity(student));
    }

    @Override
    public Picture addPictureToStudent(Picture picture, Long studentId) {
        ResponseEntity<Picture> studentResponseEntity = this.restTemplate.postForEntity(String.format("%s/picture/%d" , URL , studentId), getHttpEntity(picture), Picture.class);
        return studentResponseEntity.getBody() ;
    }

    @Override
    public void updatePictureOfStudent(Picture Picture, Long studentId) {
        this.restTemplate.put(String.format("%s/picture/%d" , URL , studentId) , getHttpEntity(Picture));
    }

    @Override
    public List<Student> getStudents(int page, int size) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("page", page)
                .queryParam("size", size);
        Student[] students = restTemplate.getForObject(builder.toUriString(), Student[].class);
        return List.of(students) ;
    }

    @Override
    public Picture getPictureOfStudent(Long studentId) {
       return this.restTemplate.getForObject(String.format("%s/picture/%d" , URL , studentId) , Picture.class) ;
    }

    @Override
    public void deleteStudent(Long studentId) {
        this.restTemplate.delete(String.format("%s/%d" , URL , studentId));
    }

    @Override
    public void deletePictureOfStudent(Long studentId) {
        this.restTemplate.delete(String.format("%s/picture/%d" , URL , studentId));
    }

    @Override
    public void deleteAllStudentsOfCourse(Long courseId) {

    }

    @Override
    public void deleteAllStudent() {

    }

    private <T> HttpEntity<Object> getHttpEntity(T obj){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(obj, headers);
        return requestEntity ;
    }
}
