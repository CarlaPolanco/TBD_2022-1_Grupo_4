package cl.tbd.backendayni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import org.sql2o.Connection;

import cl.tbd.backendayni.repositories.DatabaseContext;
import cl.tbd.backendayni.repositories.TablesContext;

@SpringBootApplication
@RestController
public class BackendAyniApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendAyniApplication.class, args);
		Sql2o sql2o = DatabaseContext.sql2o();
		try{
			Connection con = sql2o.open();
			TablesContext tablas = new TablesContext(con);
			try{
				tablas.crearTablas();
				System.out.println("| Se creo las Tablas de la Base de datos de Ayni |");
				tablas.dump();
				System.out.println("| Se ingresaron los datos de la Base de datos de Ayni |");
			}catch(Sql2oException e)
			{
				System.out.println("| Ya se crearon las Tablas de la Base de datos de Ayni |");
			}
			System.out.println("| Si funciona |");

        }
		catch(Sql2oException e){
			System.out.println("| No funciona |");
		}
	}

}