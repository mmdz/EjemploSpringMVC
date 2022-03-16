package com.example.EjemploSpring.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Author Mellmdz*/
@Controller
@RequestMapping("Ejercicio_3")//http://localhost:8080/Ejercicio_3.html
public class PapasFritasController {
  @GetMapping()
    public String ejercicio_3(){
        return "Ejercicio_3.html";
    }
}
