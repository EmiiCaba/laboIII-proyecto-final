package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.model.Alumno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Hello world!
 *
 */
@SpringBootApplication

public class App
{

    public static void main( String[] args )
    {
        Alumno alumno = new Alumno();
        System.out.println(alumno);
        SpringApplication.run(App.class);
    }
}
