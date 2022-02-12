
package com.gm.dao;

import com.gm.domain.Persona;
import org.springframework.data.repository.CrudRepository;

//heredamos de CrudRepo para traer los metodos mas usados, 
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
}
