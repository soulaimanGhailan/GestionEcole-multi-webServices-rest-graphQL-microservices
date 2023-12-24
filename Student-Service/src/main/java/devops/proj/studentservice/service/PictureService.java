package devops.proj.studentservice.service;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dtos.PictureDTO;

public interface PictureService {
    Picture create(PictureDTO pictureDTO) ;
    PictureDTO getPicById(Long id);
    PictureDTO updateImage(PictureDTO pictureDTO);
    Picture createPictureFromBase64StringPic(String imageBase64);
    void delete(Long pictureId);
}
