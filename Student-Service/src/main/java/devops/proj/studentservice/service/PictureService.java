package devops.proj.studentservice.service;

import devops.proj.studentservice.dao.entities.Picture;
import devops.proj.studentservice.dtos.PictureDTO;

public interface PictureService {
    Picture create(PictureDTO pictureDTO) ;
    PictureDTO getPicById(Long id);
    Picture updateImage(Long pictureId, PictureDTO pictureDTO);
    void delete(Long pictureId);
}
