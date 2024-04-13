package com.example.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.model.Menu;
import com.example.springdemo.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/insert")
    public String insert(@RequestBody Menu menu) {
        Menu m = menuService.insert(menu);
        if (m != null) {
            return "Item inserted successfully";
        }
        return "Item not inserted for some reason";
    }

    @GetMapping("/{foodname}")
    public Menu find(@PathVariable("foodname") String fname) {
        return menuService.find(fname);

    }

    @GetMapping("/foods")
    public List<Menu> findAll() {
        return menuService.display();
    }

    @PutMapping("/update")
    public String update(@RequestBody Menu menu) {
        Menu m = menuService.find(menu.getFoodName());
        if (m != null) {
            m.setQuantityAvailable(menu.getQuantityAvailable());
            m.setPrice(menu.getPrice());
            menuService.insert(m);
            return "Food Updated successfully";
        }
        return "No food available";
    }

    @DeleteMapping("/delete/{foodId}")
    public String delete(@PathVariable("foodId") int foodId) {
        menuService.delete(foodId);
        return "food deleted successfully";
    }
}