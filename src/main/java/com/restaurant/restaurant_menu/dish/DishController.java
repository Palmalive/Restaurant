package com.restaurant.restaurant_menu.dish;

import com.restaurant.restaurant_menu.segment.SegmentService;
import com.restaurant.restaurant_menu.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;
    private final SegmentService segmentService;
    private final UserService userService;

    @GetMapping("/")
    public String menu(@RequestParam(name = "title", required = false) String title
            , Principal principal, Model model){
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        model.addAttribute("dishes", dishService.listDishes(title));
        model.addAttribute("segments", segmentService.listSegments());
        return "menu";
    }

    @GetMapping("/dish/{id}")
    public String dishInfo(@PathVariable Long id, Model model){
        Dish dish = dishService.getDishById(id);
        model.addAttribute("images", dish.getImages());
        model.addAttribute("dish", dish);
        return "dish-info";
    }
}
