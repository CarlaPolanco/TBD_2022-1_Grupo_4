package cl.tbd.backendayni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendAyniApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAyniApplication.class, args);

		Sql2o base = DatabaseContext.sql2o();
		try{
			Connection conn = base.open();
			System.out.println("si funciona");

        }
		catch(Sql2oException e){
			System.out.println("no funciona");
		}
	}

}
