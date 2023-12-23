package devops.proj.studentservice.service.impls;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dao.reposotories.PictureRepo;
import devops.proj.studentservice.dtos.PictureDTO;
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
    @Override
    public PictureDTO create(PictureDTO pictureDTO) {
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
    public Picture updatePicture(String imageBase64, String pictureId) {
       return null ;
    }

    @Override
    public void delete(String pictureId) {

    }
}
