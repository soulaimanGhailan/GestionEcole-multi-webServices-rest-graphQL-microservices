package devops.proj.fillierservice.webClient;

import devops.proj.fillierservice.model.Student;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface StudentRestClient {
    @RequestLine("GET /api/rest/students/id/{id}")
    Student getStudentById(@Param("id") Long id);

    @Headers("Content-Type: application/json")
    @RequestLine("POST /api/rest/students")
    Student createStudent(@Param("student") Student student);
}
