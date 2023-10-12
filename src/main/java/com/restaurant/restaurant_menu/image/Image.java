package com.restaurant.restaurant_menu.image;

import com.restaurant.restaurant_menu.dish.Dish;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String originalFileName;
    @Column
    private Long size;
    @Column
    private String contentType;
    @Column
    private boolean isPreviewImage;
    @Lob
    @Column(columnDefinition = "longblob")
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private Dish dish;
}
