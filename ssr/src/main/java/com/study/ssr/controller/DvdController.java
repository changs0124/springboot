package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class DvdController {

    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("test")
                .producer("testProducer")
                .publisher("testPublisher")
                .build();
        Dvd dvd1 = Dvd.builder()
                .title("test1")
                .producer("testProducer1")
                .publisher("testPublisher1")
                .build();
        Dvd dvd2 = Dvd.builder()
                .title("test2")
                .producer("testProducer2")
                .publisher("testPublisher2")
                .build();
        model.addAttribute(dvd);
        model.addAttribute("names", List.of("1", "2", "3"));
        model.addAttribute("dvds", List.of(dvd, dvd1, dvd2));
        model.addAttribute("title", "test-title");
        return "views/dvd_list";
    }

    @ResponseBody
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    @ResponseBody
    @GetMapping("/dvd")
    public Object getDvd() {
        Dvd dvd = Dvd.builder().title("test").producer("testProducer").publisher("testPublisher").build();
        Dvd dvd1 = Dvd.builder().title("test1").producer("testProducer1").publisher("testPublisher1").build();
        Dvd dvd2 = Dvd.builder().title("test2").producer("testProducer2").publisher("testPublisher2").build();


        return List.of(dvd, dvd1, dvd2);
    }


//    @GetMapping("/dvds")
//    public ModelAndView dvdListPage() {
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("/views/dvd_list");
//        return mav;
//    }

}
