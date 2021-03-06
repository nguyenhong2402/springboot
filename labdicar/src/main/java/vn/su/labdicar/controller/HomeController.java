package vn.su.labdicar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.su.labdicar.bean.Car;

@Controller
public class HomeController {
    @Autowired
    Car car;
    
    @ResponseBody
    @GetMapping(value = "/",produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return car.toString();
    }
}
