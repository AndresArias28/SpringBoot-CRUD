package com.gm.web;

import com.gm.domain.Persona;
import com.gm.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller//CONTROLADOR SPRING TIPO MVC
@Slf4j //permite usar varaible log
public class ControladorInicio {

    @Autowired //inyectar la interface PersonaDao con todos los metodos de CrudRepository
    private PersonaService personaService;//esta variable tiene la interfaz: Spring se encarga de buscar dentro del contenedor una implementacion de esta interfaz y la inserta 
    //private PersonaDao personaDao;//esta varaible es para comunicacion directo vista - modelo

    @GetMapping("/") //RUTA DE INICIO PARA MOSTRAR DATOS , INDICAMOS QUE ES UNA PETICION http DE TIPO GET
    public String mensaje(Model model) {//recibo el ob jeto model para qgregar informacion a enviar a la vista
        Iterable personas = personaService.listarPersonas();
        log.info("ejecutando el controlador Spring MVC, debido a la a notacion controller");
        model.addAttribute("personas", personas);
        return "index";//spring retorna la vsita con la informacion agregada (llavesaludar)
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {//No es necesario instanciar este objeto, Spring se encarga de eso en casi que no encuentre uno, lo crea
        return "modificar";
    }

    @PostMapping("/guardar")//mapeo el objeto persona enviado del formulario, mediuante POST
    public String guardar(Persona persona) {
        personaService.guardar(persona);//almaceno lso datos de persona(vista)- mediante la interfaz personaService(negocio), la cual tiene los metodos implementados(negocio) y con ayuda de la clase DAO (DATOS) finalmente se accede a la BD
        return "redirect:/";//redireccionar hacai el inicio                 }
    }
    
    //se define el objeto el objeto persona y Spring lo busca y lo injecta, ademas el parametro idPersona lo asocia con el objeto persona
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) {//automaticamente inicializa  el objeto persona con el valor de idPersona
        persona = personaService.encontrarPersona(persona);//se guarda en la misma varaible para no crear otra
        model.addAttribute("persona", persona);
        return "modificar";
    }
    
    @GetMapping("/eliminar/{idPersona}")
    public String elimnar(Persona persona){
       personaService.eliminar(persona);
       return "redirect:/";
    }
    

}
