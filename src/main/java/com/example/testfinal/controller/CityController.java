package com.example.testfinal.controller;

import com.example.testfinal.model.City;
import com.example.testfinal.model.Nation;
import com.example.testfinal.service.city.CityService;
import com.example.testfinal.service.nation.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private NationService nationService;

    @ModelAttribute("nations")
    public List<Nation> findAll(){
        return nationService.findAll();
    }

    @GetMapping("/city")
    public ModelAndView listCity(){
        List<City> list= cityService.findAll();
        ModelAndView modelAndView= new ModelAndView("city/list");
        modelAndView.addObject("list", list);
        return modelAndView;
    }

    @GetMapping("/create-city")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView= new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @PostMapping("/create-city")
    public ModelAndView saveCity(@ModelAttribute City city){
        cityService.save(city);
        ModelAndView modelAndView=new ModelAndView("city/create");
        modelAndView.addObject("message", "Tạo mới thành công");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }
    @GetMapping("/view-city/{id}")
    public ModelAndView viewCity(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        ModelAndView modelAndView= new ModelAndView("city/view");
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }
    @GetMapping("/edit-city/{id}")
    public ModelAndView showFormEdit(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
        ModelAndView modelAndView= new ModelAndView("city/edit");
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }
    @PostMapping("/edit-city")
    public ModelAndView updateCity(@ModelAttribute City city){
        if (city== null){
            ModelAndView modelAndView =new ModelAndView("city/edit");
            modelAndView.addObject("message", "Khong the sua !!!");
            return modelAndView;
        }

        cityService.save(city);
        ModelAndView modelAndView =new ModelAndView("city/edit");
        modelAndView.addObject("message", "Sua thanh cong!!!");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<City> city= cityService.findById(id);
            ModelAndView modelAndView = new ModelAndView("city/delete");
            modelAndView.addObject("city", city);
            return modelAndView;
       
    }

    @PostMapping("/delete-city")
    public ModelAndView deleteCity(@ModelAttribute("city") City city){
        cityService.delete(city.getId());
        ModelAndView modelAndView = new ModelAndView("city/delete");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "Xóa thành công!!!");
        return modelAndView;
    }



}
