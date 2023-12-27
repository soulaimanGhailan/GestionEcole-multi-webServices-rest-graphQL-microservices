package devops.proj.fillierservice.webClients;

import devops.proj.fillierservice.model.Student;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface StudentRestClient {
    @RequestLine("GET students/id/{id}")
    Student getStudentById(@Param("id") Long id);

    @Headers("Content-Type: application/json")
    @RequestLine("POST students")
    Student createStudent(@Param("student") Student student);
}
