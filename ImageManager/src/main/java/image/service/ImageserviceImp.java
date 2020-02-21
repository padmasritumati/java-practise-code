package image.service;

import image.dao.ImageDAO;
import image.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public abstract class ImageserviceImp implements ImageService {

    @Autowired
    ImageDAO imageDAO;

    @Transactional
    public void addImage(MultipartFile file) {
        imageDAO.addImage(file);
    }

    @Transactional
    public Image getImage(Integer id) {
        return imageDAO.getImage(id);
    }

    @Transactional
    public void removeImage(Integer id) {
         imageDAO.removeImage(id);
    }

    @Transactional
    public void updateImage(Image account) {
         imageDAO.updateImage(account);
    }

    @Transactional
    public List<Image> listImage() {
        return imageDAO.listImage();
    }
}

