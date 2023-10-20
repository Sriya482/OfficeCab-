package demo.project.pd.workshop.demostatement.controller;

import demo.project.pd.workshop.demostatement.model.OfficeCab;
import demo.project.pd.workshop.demostatement.repository.OfficeCabRepository;
import demo.project.pd.workshop.demostatement.service.OfficeCabService;
import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.ClientInfoStatus;
import java.util.List;
@Controller

public class OfficeCabController {

    @Autowired
    private OfficeCabRepository officeCabRepository;

    @Autowired
    private JavaMailSender javaMailSender;

@GetMapping("/")
public String getData(Model model){
    List<OfficeCab> officeCabList=officeCabRepository.findAll();
    model.addAttribute("officeCabList",officeCabList);
    return "list";
}

    @GetMapping("/personal-list")
    public String personalList(Model model){
        List<OfficeCab> userCabs = officeCabRepository.findAll();
        model.addAttribute("userCabs", userCabs);
        return "personal-list";
    }


@GetMapping("/register")

    public String registrationForm(){
    return "registration";

}

    @PostMapping("/register")
    public String submitRegistrationForm(OfficeCab officeCab) {
    officeCabRepository.save(officeCab);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("mishrasriyarani21@gmil.com");
        message.setTo(officeCab.getEmailId());
        message.setCc("sriyaranimishra2001@gmail.com");
        message.setSubject("Confirmation For Booking Cab for  "+ officeCab.getName());
        String text = "Dear " + officeCab.getName() + ",\n\n";
        text += "Thank you for booking a cab. Your booking has been confirmed.\n";
        text += "Details of your booking:\n";
        text += "Name: " + officeCab.getName() + "\n";
        text += " Cab Number" + officeCab.getCabNumber() + "\n";


        message.setText(text);

        javaMailSender.send(message);
        return "success";
    }



        @GetMapping("/success")
    public String registrationSuccess() {
        return "success";
    }



@RequestMapping("/delete/{id}")

    public String deleteDetails(@PathVariable("id") Long id){

    officeCabRepository.deleteById(id);
    return "redirect:/personal-list";


    }

    @GetMapping("/get/{id}")

    public String getById(@PathVariable("id") Long id, OfficeCab officeCab,Model model){
    OfficeCab officeCab1=officeCabRepository.findById(id).get();
    model.addAttribute("userCabs",officeCab1);

    return "personal-list";
    }


    @GetMapping("/update/{id}")
    public  String  editDetails(@PathVariable("id") Long id, Model model){

            OfficeCab officeCab = officeCabRepository.findById(id).get();
            model.addAttribute("officeCab", officeCab);
            return "update-register" ;
         }

         @PostMapping("/update/{id}")
    public  String updateDetails(@ModelAttribute("officeCab") OfficeCab officeCab){
       officeCabRepository.save(officeCab);
       return  "redirect:/personal-list";
         }

}







