package com.example.restorantst;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MenuService {
    private  final MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }
    public Menu getAllMenuById(Long id) {
        return  menuRepository.getReferenceById(id);

    }
    public void save(Menu menu) {
        menuRepository.save(menu);
    }
}
