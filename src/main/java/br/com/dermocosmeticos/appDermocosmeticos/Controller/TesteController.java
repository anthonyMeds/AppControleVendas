package br.com.dermocosmeticos.appDermocosmeticos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @RequestMapping
    public ModelAndView carregaTeste() {
        return new ModelAndView("Teste/Formulario");
    }

}
