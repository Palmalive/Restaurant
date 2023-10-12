package com.restaurant.restaurant_menu.dish;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findAllByTitle(String title);

    void deleteById(Long id);

}
