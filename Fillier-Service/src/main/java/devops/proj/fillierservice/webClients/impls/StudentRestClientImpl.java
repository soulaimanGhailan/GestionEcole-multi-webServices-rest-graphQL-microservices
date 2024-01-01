package devops.proj.fillierservice.webClients.impls;

import devops.proj.fillierservice.model.PageInfo;
import devops.proj.fillierservice.model.Student;
import devops.proj.fillierservice.webClients.StudentRestClient;
import org.springframework.beans.factory.annotation.Value;
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
    @Value("#{studentServiceURL}")
    private String URL;
//    private String URL = "http://localhost:8085/students";

    public StudentRestClientImpl(RestTemplate restTemplate , String url) {
        this.restTemplate = restTemplate;
        this.URL=url ;
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
    public List<Student> getStudents(int page, int size) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(URL)
                .queryParam("page", page)
                .queryParam("size", size);
        Student[] students = restTemplate.getForObject(builder.toUriString(), Student[].class);
        return List.of(students) ;
    }


    @Override
    public void deleteStudent(Long studentId) {
        this.restTemplate.delete(String.format("%s/%d" , URL , studentId));
    }



    @Override
    public void deleteAllStudentsOfCourse(Long courseId) {
        this.restTemplate.delete(String.format("%s/filiere/%d" , URL , courseId));
    }

    @Override
    public void deleteAllStudent() {

    }

    @Override
    public Long getNumberOfStudent() {
        return this.restTemplate.getForObject(String.format("%s/size", URL), Long.class);

    }

    @Override
    public PageInfo getStudentsPageInfo(int size) {
        return this.restTemplate.getForObject(String.format("%s/pageInfo?size=%d" , URL , size) , PageInfo.class);
    }

    private <T> HttpEntity<Object> getHttpEntity(T obj){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(obj, headers);
        return requestEntity ;
    }
}
