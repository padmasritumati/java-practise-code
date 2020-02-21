package image.controller;


import image.model.Image;
import image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

@Controller
public class ImageController {

	private final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.
	
    @Autowired
    private ImageService imageService;
	
	@RequestMapping("/admin/manageAllImages")
	public String listImages(Model model){
		model.addAttribute("image", new Image());
		model.addAttribute("imageList", imageService.listImage());
		return "admin/manageallimages";
	}
	
    @RequestMapping(value="/admin/addImage", method=RequestMethod.POST)
    public String addImage(@RequestParam("file") MultipartFile file){
    	if(!file.isEmpty())imageService.addImage(file);
    	return "redirect:/admin/manageAllImages";
    }
    
    @RequestMapping(value="/admin/deleteImage/{imageId}")
    public String deleteImage(@PathVariable("imageId") Integer id){
    	
    	imageService.removeImage(id);
    	return "redirect:/admin/manageAllImages";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/image/{id}")
    public void getImage(Model model, @PathVariable("id") Integer imageId, HttpServletResponse response) throws ServletException, IOException
 {
        if (imageId == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        Image image = imageService.getImage(imageId);
        if (image == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        response.reset();
        response.setBufferSize(DEFAULT_BUFFER_SIZE);
        response.setContentType(image.getContenttype());
        response.setHeader("Content-Length", String.valueOf(image.getLength()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + image.getName() + "\"");

        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            try {
				input = new BufferedInputStream(image.getContent().getBinaryStream(), DEFAULT_BUFFER_SIZE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {

            close(output);
            close(input);
        }
    }

    private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
    
}
