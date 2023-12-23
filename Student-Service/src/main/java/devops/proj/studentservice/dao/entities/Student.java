package devops.proj.studentservice.dao.entities;

import devops.proj.studentservice.model.CourseStudy;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String firstName ;
    private String lastName ;
    private String cne ;
    private String email ;
    @OneToOne
    private Picture StudentProfilePicture ;
    @Transient
    private CourseStudy courseStudy ;
}
