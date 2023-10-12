package com.restaurant.restaurant_menu.segment;

import com.restaurant.restaurant_menu.dish.Dish;
import com.restaurant.restaurant_menu.dish.DishRepository;
import com.restaurant.restaurant_menu.image.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SegmentService {
    private final SegmentRepository segmentRepository;
    private final DishRepository dishRepository;

    public void saveSegment(Segment segment) {
        if (segment != null) {
            segmentRepository.save(segment);
        }
    }

    public List<Segment> listSegments() {
        return segmentRepository.findAll();
    }

    public void saveDishInSegment(Dish dish, Long segmentId
            , MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            dish.addImageToDish(image1);
        }
        if(file2.getSize() != 0) {
            image2 = toImageEntity(file2);
            dish.addImageToDish(image2);
        }
        if(file3.getSize() != 0) {
            image3 = toImageEntity(file3);
            dish.addImageToDish(image3);
        }



        Segment segment = getSegmentById(segmentId);
        dish.setSegment(segment);
        segment.addDish(dish);
        saveSegment(segment);
        setPreviewImageId(dish);


    }

    private void setPreviewImageId(Dish dish) {
        dish.setPreviewImageId();
        dishRepository.save(dish);
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public Segment getSegmentById(Long id){
        return segmentRepository.findById(id).orElse(null);
    }

    public void deleteSegment(Long id) {
        segmentRepository.deleteById(id);
        log.info("Segment with id {} was deleted", id);
    }
}
