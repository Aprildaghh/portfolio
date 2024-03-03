package com.abdullah.portfolio.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortfolioController {

    @RequestMapping("/")
    public String landingPage() {
        return "portfolio-landing-page";
    }

}
