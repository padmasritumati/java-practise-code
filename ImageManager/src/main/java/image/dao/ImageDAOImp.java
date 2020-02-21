package image.dao;

import image.model.Image;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.LobCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import java.sql.Blob;
import java.util.List;
import java.io.IOException;

@Repository
public class ImageDAOImp implements ImageDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addImage(MultipartFile file) {
        Image image=new Image();
        Blob blob=null;

        image.setName(file.getOriginalFilename());
        image.setContenttype(file.getContentType());
        image.setLength((int)file.getSize());

        try
           {
            LobCreator lobCreator= Hibernate.getLobCreator(sessionFactory.getCurrentSession());
            blob=lobCreator.createBlob(file.getInputStream(),file.getSize());
           }
        catch (IOException e)
            {
            e.printStackTrace();
            }
        image.setImage(blob);
        sessionFactory.getCurrentSession().save(image);
    }

    @Override
    public List<Image> listImage() {
        return sessionFactory.getCurrentSession().createQuery("from images").list();
    }

    @Override
    public void removeImage(Integer id) {
        Image image=getImage(id);
        if(null!=image){
            sessionFactory.getCurrentSession().delete(image);
        }
    }

    @Override
    public Image getImage(Integer id) {
        return (Image) sessionFactory.getCurrentSession().get(Image.class,id);
    }

    @Override
    public void updateImage(Image image) {
        sessionFactory.getCurrentSession().saveOrUpdate(image);
    }
}
