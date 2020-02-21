package image.service;

import org.springframework.web.multipart.MultipartFile;
import image.model.Image;
import java.util.List;

public interface ImageService {

    public void addImage(MultipartFile file);
    public List<Image> listImage();
    public void removeImage(Integer id);
    public Image getImage(Integer id);
    public void updateImage(Image account);
}
