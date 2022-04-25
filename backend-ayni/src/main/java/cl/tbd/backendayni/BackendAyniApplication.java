package cl.tbd.backendayni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import cl.tbd.backendayni.repositories.DatabaseContext;

@SpringBootApplication
public class BackendAyniApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAyniApplication.class, args);

		Sql2o sql2o = DatabaseContext.sql2o();
		try{
			sql2o.open();
			System.out.println("si funciona");

        }
		catch(Sql2oException e){
			System.out.println("no funciona");
		}
	}

}
