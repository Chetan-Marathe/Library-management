package com.application.libraryapp.controller;

import com.application.libraryapp.entity.Publisher;
import com.application.libraryapp.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String findallpublisher(Model model){
        model.addAttribute("publishers",publisherService.FindallPublisher());
        return "publishers";
    }

    @GetMapping("/remove-publisher/{id}")
    public String deletepublisher(@PathVariable Long id,Model model){
        publisherService.DeletePublisher(id);
        model.addAttribute("publishers",publisherService.FindallPublisher());
        return "publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id, Model model){
        model.addAttribute("publisher",publisherService.FindaPublisher(id));
        return "update-publisher";
    }

    @PostMapping("/update-publisher/{id}")
    public String saveupdatePublisher(@PathVariable Long id, Publisher publisher, BindingResult result,Model model){
        if(result.hasErrors()){
            return "update-publisher";
        }
        publisherService.UpdatePublisher(publisher);
        model.addAttribute("publisher",publisherService.FindallPublisher());
        return "redirect:/publishers";
    }

    @GetMapping("/add-publisher")
    public String ShowcreatePage(Publisher publisher){
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String Savepublisher(Publisher publisher,BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-publisher";
        }
        publisherService.CreatePublisher(publisher);
        model.addAttribute("publishers",publisherService.FindallPublisher());
        return "redirect:/publishers";
    }
}
