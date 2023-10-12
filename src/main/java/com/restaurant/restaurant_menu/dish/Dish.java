package com.restaurant.restaurant_menu.dish;

import com.restaurant.restaurant_menu.image.Image;
import com.restaurant.restaurant_menu.segment.Segment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private double price;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private Segment segment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "dish")
    private List<Image> images = new ArrayList<>();

    private Long previewImageId;

    public void addImageToDish(Image image){
        image.setDish(this);
        images.add(image);
    }

    public void setPreviewImageId(){
        previewImageId = images.get(0).getId();
    }

}
