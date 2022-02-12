package com.gm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HolaSpringBootApplication {

	public static void main(String[] args) {
            //MEDIANTE LA CLASE SpringApp SE LLAMA EL METODO run  Y LE PASAMAOS LA CLASE QUE SE QUIERE EJECUTAR Y LE PASAN ARGUMENTOS
		SpringApplication.run(HolaSpringBootApplication.class, args); 
	}

}
