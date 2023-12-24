package devops.proj.studentservice.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Picture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pictureId;
    private Date addingDate;
    @Column(length = 1000000)
    @Lob
    private byte[] pictureContent;
}
