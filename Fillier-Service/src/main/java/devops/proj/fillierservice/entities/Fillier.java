package devops.proj.fillierservice.entities;

import devops.proj.fillierservice.model.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Fillier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id  ;
    private String code  ;
    private String libelle ;
    @Transient
    List<Student> studentList ;
}
