package com.PhotoApp.crashCourse.repository;
import com.PhotoApp.crashCourse.model.PhotoModel;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<PhotoModel,Integer> {
}
