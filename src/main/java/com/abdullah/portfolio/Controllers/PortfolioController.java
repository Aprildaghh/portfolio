package com.abdullah.portfolio.Controllers;

import com.abdullah.portfolio.Model.EmailEntity;
import com.abdullah.portfolio.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.regex.Pattern;

@Controller
@RequestMapping("/")
public class PortfolioController {


    @Autowired
    EmailService emailService;


    @RequestMapping("/")
    public String landingPage(Model model) {

        EmailEntity email = new EmailEntity();

        model.addAttribute("email", email);

        return "portfolio-landing-page";
    }

    @PostMapping("/email/send")
    public String sendEmail(@ModelAttribute EmailEntity email)
    {
        // validate
        if(!isValid(email))
            return "redirect:/?wrong-credentials";

        String message = email.getUsername() + "\n --- \n" + email.getEmail() + "\n --- \n" + email.getMessage();
        emailService.sendEmail("agomikoroz@gmail.com", "PORTFOLIO PROJECT", message);
        return "redirect:/#contact?emailsent";
    }

    private boolean isValid(EmailEntity email)
    {
        return !email.getUsername().isEmpty() && !email.getMessage().isEmpty() && emailValidation(email.getEmail());
    }

    private boolean emailValidation(String email)
    {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

}
