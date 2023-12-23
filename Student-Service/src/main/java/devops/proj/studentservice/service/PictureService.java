package devops.proj.studentservice.service;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dtos.PictureDTO;

public interface PictureService {
    PictureDTO create(PictureDTO pictureDTO) ;
    Picture createPictureFromBase64StringPic(String imageBase64);
    Picture updatePicture(String imageBase64 , String pictureId);
    void delete(String pictureId);
}
