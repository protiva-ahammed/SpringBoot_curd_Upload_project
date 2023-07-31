package com.PhotoApp.crashCourse.controller;
import com.PhotoApp.crashCourse.model.PhotoModel;
import com.PhotoApp.crashCourse.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import java.io.IOException;


@RestController
public class PhotoController {
  //it is a private map therefore not accessed by the download controller

    //need to create a public one
    //@Autowired have to use if we do not use the photoService Controller
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World from Protiva";
    }

    @GetMapping("/photo")
    public Iterable<PhotoModel> get() {
        return photoService.get();
    }

    @GetMapping("/photo/{ID}")
    public PhotoModel get(@PathVariable Integer ID) {
        PhotoModel photo = photoService.get(ID);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photo/{ID}")
    public void delete(@PathVariable Integer ID) {
        photoService.remove(ID);
    }

    @PostMapping("/photo")
    public PhotoModel create(@RequestPart("DATA") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
