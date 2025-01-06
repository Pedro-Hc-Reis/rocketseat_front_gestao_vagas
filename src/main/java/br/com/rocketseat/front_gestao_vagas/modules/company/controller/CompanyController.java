package br.com.rocketseat.front_gestao_vagas.modules.company.controller;

import br.com.rocketseat.front_gestao_vagas.company.dto.CreateCompanyDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ( "/company" )
public class CompanyController {

    @GetMapping ( "/create" )
    public String create ( Model model ) {
        model.addAttribute ( "company" , new CreateCompanyDTO ( ) );
        return "company/create";
    }
}