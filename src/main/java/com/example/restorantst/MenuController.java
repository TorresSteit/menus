package com.example.restorantst;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/menus")
    public String getAllMenus(Model model) {
        List<Menu> menus = menuService.getAllMenus();
        model.addAttribute("menus", menus);
        return "menus"; // Возвращает HTML-шаблон menus.html
    }

    @PostMapping("/create")
    public String createMenu(@RequestParam("title") String title,
                             @RequestParam("price") Long price,
                             @RequestParam("weight") Long weight,
                             @RequestParam("discount") boolean discount) {
        Menu newMenu = new Menu();
        newMenu.setTitle(title);
        newMenu.setPrice(price);
        newMenu.setWeight(weight);
        newMenu.setDiscount(discount);

        menuService.save(newMenu);

        return "redirect:/menus"; // Перенаправление на список после добавления
    }
}

