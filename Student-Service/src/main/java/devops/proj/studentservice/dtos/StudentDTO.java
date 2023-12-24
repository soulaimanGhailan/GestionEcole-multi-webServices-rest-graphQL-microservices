package devops.proj.studentservice.dtos;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String cne ;
    private String email ;
//    private String imageContentBase64 ;

}
