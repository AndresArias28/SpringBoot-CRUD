package com.gm.service;

import com.gm.dao.PersonaDao;
import com.gm.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//permite inyectar esta clase como implementacion de la interfaz en el controlador
public class PersonaServiceIMP implements PersonaService {

    @Autowired//inyectar este dato en el controlador
    private PersonaDao personaDao;//
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        //es necesario hacer un casteo de objeto a lista
        return (List<Persona>) personaDao.findAll();//personaDao hereda los metodos de la interfaz CRUDrepository
                
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
