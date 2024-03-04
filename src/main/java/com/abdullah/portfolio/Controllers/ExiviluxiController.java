package com.abdullah.portfolio.Controllers;

import com.abdullah.portfolio.Model.PresentationEntity;
import com.abdullah.portfolio.Service.PresentationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

@Controller
@RequestMapping("/exiviluxi")
public class ExiviluxiController {

    @Autowired
    private PresentationService presentationService;

    @RequestMapping("")
    public String mainPageRedirecterer() { return "redirect:/exiviluxi/";}

    @RequestMapping("/")
    public String mainPage()
    {
        return "exiviluxi/main";
    }

    @RequestMapping("/timer/{id}")
    public String timerPage(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("presentation", presentationService.getSinglePresentation(id));

        return "exiviluxi/timer";
    }


    @RequestMapping("/presentation/{id}")
    public String presentationPage(@PathVariable("id") String id, Model model)
    {
        PresentationEntity presentation = presentationService.getSinglePresentation(Integer.parseInt(id));

        LocalDate date = presentation.getDate().toLocalDate();

        if(date.isAfter(LocalDate.now()))
        {
            return "redirect:/exiviluxi/timer/"+id;
        }

        presentation.setPassword("");
        model.addAttribute("presentation", presentation);

        return "exiviluxi/presentation";
    }

    @RequestMapping("/presentation-password-confirmation/{id}")
    public String presentationPasswordConfirmationPage(@PathVariable("id") String id, @ModelAttribute PresentationEntity pres)
    {
        String password = presentationService.getSinglePresentation(Integer.parseInt(id)).getPassword();

        if(Objects.equals(password, pres.getPassword()))
        {
            return "redirect:/exiviluxi/presentation-view/"+id;
        }
        return "redirect:/exiviluxi/presentation/"+id;
    }

    @RequestMapping("/presentation-view/{id}")
    public String presentationViewPage(@PathVariable("id") String id, Model model)
    {
        PresentationEntity pres = presentationService.getSinglePresentation(Integer.parseInt(id));
        model.addAttribute("presentation", pres);
        return "exiviluxi/presentation-view";
    }

    @RequestMapping("presentation-creation")
    public String presentationCreationPage(Model model)
    {
        PresentationEntity presentation = new PresentationEntity();

        model.addAttribute("presentation", presentation);

        return "exiviluxi/presentation-creation";
    }

    @RequestMapping("creation")
    public String creation(@ModelAttribute PresentationEntity presentation, Model model)
    {
        if(presentation.getDate() == null)
        {
            return "redirect:/exiviluxi/presentation-creation?no-date";
        }
        else if (presentation.getVideoUrl() == null && presentation.getBackgroundUrl() == null && presentation.getBackgroundColor() == null)
        {
            return "redirect:/exiviluxi/presentation-creation?blank-presentation";
        }

        String password = createRandomPassword();

        presentation.setPassword(password);
        presentation.setVideoUrl(presentation.getVideoUrl().substring(presentation.getVideoUrl().indexOf('=')+1));


        presentationService.addPresentation(presentation);

        model.addAttribute("password", password);
        model.addAttribute("id", presentation.getId());

        return "exiviluxi/creation";
    }

    static private String createRandomPassword() {

        int passwordLength = 16;
        Random rd = new Random();
        String result = "";
        boolean flag = false;
        ArrayList<Character> chars_1 = new ArrayList<>();

        chars_1.add('a');
        chars_1.add('e');
        chars_1.add('i');
        chars_1.add('o');
        chars_1.add('u');

        ArrayList<Character> chars_2 = new ArrayList<>();

        for(int i = 97; i <= 122; ++i) {
            if (!chars_1.contains((char)i)) {
                chars_2.add((char)i);
            }
        }

        while(passwordLength-- > 0) {
            if (flag) {
                result += chars_2.get(rd.nextInt(21));
            } else {
                result += chars_1.get(rd.nextInt(5));
            }

            flag = !flag;
        }

        return result;
    }

}
