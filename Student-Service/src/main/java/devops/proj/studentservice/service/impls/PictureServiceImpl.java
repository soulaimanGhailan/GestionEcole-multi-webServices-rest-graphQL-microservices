package devops.proj.studentservice.service.impls;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.reposotories.PictureRepo;
import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.mappers.Mapper;
import devops.proj.studentservice.service.PictureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
@AllArgsConstructor
public class PictureServiceImpl implements PictureService {
    private PictureRepo pictureRepo ;
    private Mapper mapper ;
    @Override
    public Picture create(PictureDTO pictureDTO) {
        Picture picture = mapper.fromPictureDTO(pictureDTO);
        picture.setAddingDate(new Date());
        return this.pictureRepo.save(picture) ;
    }

    @Override
    public PictureDTO getPicById(Long id) {
        Picture picture = this.pictureRepo.findById(id).orElseThrow(() -> new RuntimeException("picture not found exception"));
        return mapper.fromPicture(picture) ;
    }

    @Override
    public Picture updateImage(Long pictureId, PictureDTO pictureDTO) {
        Picture picture = this.pictureRepo.findById(pictureId).orElseThrow(()
                -> new RuntimeException("picture not found exception"));
        Picture picture1 = mapper.fromPictureDTO(pictureDTO);
        picture.setAddingDate(new Date());
        picture.setPictureContent(picture1.getPictureContent());
        return this.pictureRepo.save(picture);
    }



    @Override
    public void delete(Long pictureId) {
        this.pictureRepo.deleteById(pictureId);
    }


}
