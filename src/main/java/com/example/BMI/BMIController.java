package com.example.BMI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BMIController {

    @PostMapping("/test")
    public String hello(Model model,
                      @RequestParam(name= "imie") String imie,
                      @RequestParam(name = "nazwisko") String nazwisko) {
        List lista = new ArrayList<String>();
        lista.add(imie + nazwisko);
        String zm = (String) lista.get(0);
        model.addAttribute("zm", zm);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String data = formatter.format(date);
        model.addAttribute("data", data);
        return "test";
    }

    @PostMapping("/bmi")
//    public String bmi(Model model,
//                      @RequestParam(name= "wzrost") String wzrost,
//                      @RequestParam(name = "waga") String waga) {
//        model.addAttribute("wzrost", wzrost);
//        model.addAttribute("waga", waga);
//
//
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        String data = formatter.format(date);
//        model.addAttribute("data", data);
//
//        return "bmi";
    public void bmi(Model model,
                    @RequestParam(name= "weight") float weight,
                    @RequestParam(name = "height") float height) {
        model.addAttribute("weight", weight);
        model.addAttribute("height", height);
        float bmi = Calc.bmi(weight, height);
        String nadwaga = "Nadwaga!";
        if(bmi<18.5){
            nadwaga = "Niedowaga!";
        }else if(bmi>18.5 && bmi < 24.9){
            nadwaga = "Twoje BMI jest w normie";
        }else if(bmi>25 && bmi<29.9){
            nadwaga = "Nadwaga!";
        }else if(bmi>30){
            nadwaga = "DUŻA OTYLOŚĆ!!!";
        }
        model.addAttribute("bmi", bmi);
        model.addAttribute("nadwaga", nadwaga);

    }



    @GetMapping("/about")
    public String about(){
        return "About";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
