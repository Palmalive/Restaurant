package com.restaurant.restaurant_menu.user.admin;

import com.restaurant.restaurant_menu.dish.Dish;
import com.restaurant.restaurant_menu.dish.DishService;
import com.restaurant.restaurant_menu.segment.Segment;
import com.restaurant.restaurant_menu.segment.SegmentService;
import com.restaurant.restaurant_menu.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final DishService dishService;
    private final SegmentService segmentService;
    private final UserService userService;

    @PostMapping("/admin/dish/create")
    private String addDish(@RequestParam("segmentId") Long segmentId
            , @RequestParam("file1")MultipartFile file1
            , @RequestParam("file2")MultipartFile file2
            , @RequestParam("file3")MultipartFile file3
            , Dish dish) throws IOException {

        segmentService.saveDishInSegment(dish, segmentId, file1, file2, file3);
        return "redirect:/";
    }

    @GetMapping("/admin/dish/create/{segmentId}")
    private String addDish(@PathVariable Long segmentId, Model model){
        model.addAttribute("segmentId", segmentId);
        return "dish-create";
    }

    @PostMapping("/admin/segment/create")
    private String createSegment(Segment segment){
        segmentService.saveSegment(segment);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/admin/segment/delete/{id}")
    public String deleteSegment(@PathVariable Long id){
        segmentService.deleteSegment(id);
        return "redirect:/";
    }
    @PostMapping("/admin/dish/delete/{id}")
    public String deleteDish(@PathVariable Long id){
        dishService.deleteDish(id);
        return "redirect:/";
    }

}
