package devops.proj.studentservice.dao.entities;
import javax.persistence.*;
import lombok.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName ;
    @Column(unique = true)
    private String cne ;
    private String email ;
    private Long courseId ;
}
