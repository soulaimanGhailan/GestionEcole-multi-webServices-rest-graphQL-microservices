package devops.proj.studentservice.service.impls;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.reposotories.PictureRepo;
import devops.proj.studentservice.dtos.PictureDTO;
import devops.proj.studentservice.mappers.Mapper;
import devops.proj.studentservice.service.PictureService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
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
    public PictureDTO updateImage(PictureDTO pictureDTO) {
        return null;
    }


    @Override
    public Picture createPictureFromBase64StringPic(String imageBase64) {
        Picture picture=new Picture();
        picture.setAddingDate(new Date());
        String base64Data = imageBase64;
        if(imageBase64.startsWith("data:image/jpeg;base64,")) {
            base64Data = imageBase64.substring(imageBase64.indexOf(",") + 1);
        }
        byte[] picContent = Base64.decodeBase64(base64Data);
        picture.setPictureContent(picContent);
        Picture savedPic = pictureRepo.save(picture);
        return savedPic;
    }


    @Override
    public void delete(Long pictureId) {

    }


}
