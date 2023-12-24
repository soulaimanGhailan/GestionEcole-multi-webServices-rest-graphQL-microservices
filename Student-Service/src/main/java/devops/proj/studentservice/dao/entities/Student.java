package devops.proj.studentservice.dao.entities;

import devops.proj.studentservice.model.CourseStudy;
import lombok.*;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
@ToString
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String cne ;
    private String email ;
    @OneToOne
    private Picture profilePicture;
    @Transient
    private CourseStudy courseStudy ;
    private Long courseId ;
}
