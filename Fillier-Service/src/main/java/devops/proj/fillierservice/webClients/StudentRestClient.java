package devops.proj.fillierservice.webClients;

import devops.proj.fillierservice.model.Picture;
import devops.proj.fillierservice.model.Student;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;


public interface StudentRestClient {
    /** Get **/
    @RequestLine("GET students/?page={page}&size={size}")
    List<Student> getAllStudents(@Param("page") int page , @Param("size") int size);

    @RequestLine("GET students/id/{id}")
    Student getStudentById(@Param("id") Long id);

    @RequestLine("GET students/id/{cne}")
    Student getStudentByCne(@Param("cne") String cne);

    @RequestLine("GET students/picture/{id}")
    Picture getStudentPicture(@Param("id") Long id);

    /** Post **/
    @Headers("Content-Type: application/json")
    @RequestLine("POST students")
    Student createStudent(@Param("student") Student student);

    @Headers("Content-Type: application/json")
    @RequestLine("POST students/picture/{studentId}")
    Student createStudent(@Param("studentId") String studentId , @Param("picture") Picture picture);

    /** PUT */
    @Headers("Content-Type: application/json")
    @RequestLine("PUT students")
    Student updateStudent(@Param("student") Student student);

    @Headers("Content-Type: application/json")
    @RequestLine("PUT students/picture/{studentId}")
    Student updateStudentPicture(@Param("studentId") String studentId , @Param("picture") Picture picture);

    /** DELETE */
    @Headers("Content-Type: application/json")
    @RequestLine("DELETE students/{studentId}")
    Student deleteStudent(@Param("studentId") String studentId);

    @RequestLine("DELETE students/picture/{studentId}")
    void deleteStudentPicture(@Param("studentId") String studentId);

}
