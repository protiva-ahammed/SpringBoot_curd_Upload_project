package com.PhotoApp.crashCourse.service;
import com.PhotoApp.crashCourse.model.PhotoModel;
import com.PhotoApp.crashCourse.repository.PhotoRepository;
import org.springframework.stereotype.Service;


//@Component
@Service
public class PhotoService {

    private final PhotoRepository photoRepository;


    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }
    public Iterable<PhotoModel>get(){
        return photoRepository.findAll();
    }

    public PhotoModel get (Integer ID){
        return photoRepository.findById(ID).orElse(null);
    }

    public void remove(Integer ID) {
         photoRepository.deleteById(ID);
    }
    public PhotoModel save(String FILENAME, String CONTENTTYPE, byte[] DATA) {
        PhotoModel photo = new PhotoModel();
        photo.setFileName(FILENAME);
        photo.setContentType(CONTENTTYPE);
        photo.setData(DATA);
        photoRepository.save(photo);
        return photo;
    }
}
