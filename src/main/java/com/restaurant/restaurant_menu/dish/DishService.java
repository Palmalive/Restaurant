package com.restaurant.restaurant_menu.dish;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;

    public List<Dish> listDishes(String title){

        if (title != null){
            return dishRepository.findAllByTitle(title);
        }
        else {
            return dishRepository.findAll();
        }

    }

    public void saveDish(Dish dish) {
        if(dish != null) {
            dishRepository.save(dish);
        }
    }

    public Dish getDishById(Long id){
       return dishRepository.findById(id).orElse(null);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
        log.info("Dish with id {} was deleted", id);
    }


}
