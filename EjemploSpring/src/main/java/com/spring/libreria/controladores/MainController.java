package com.spring.libreria.controladores;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*@Author Mellmdz*/

@Controller //para decir q esta clase sera un controlador
@RequestMapping("/")//http://localhost:8080
//sino le aclaro cual toma el index por defecto
/* @RequestMapping("/main")//localhost:8080/main */
public class MainController {
    
    //http: //localhost:8080/jardineria/index puede ser una ruta de acceso
    @GetMapping()
    public String index(){
        return "index.html";
    }
    
//        @GetMapping("Ejercicio_3")
//    public String Ejercicio_3(){
//        return "Ejercicio_3.html";
//    }
}
