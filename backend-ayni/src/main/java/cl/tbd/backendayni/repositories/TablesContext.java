package cl.tbd.backendayni.repositories;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import cl.tbd.backendayni.models.Emergencia;
import cl.tbd.backendayni.models.EmergenciaHabilidad;
import cl.tbd.backendayni.models.Estado;
import cl.tbd.backendayni.models.EstadoTarea;
import cl.tbd.backendayni.models.Habilidad;
import cl.tbd.backendayni.models.Institucion;
import cl.tbd.backendayni.models.Ranking;
import cl.tbd.backendayni.models.Tarea;
import cl.tbd.backendayni.models.TareaHabilidad;
import cl.tbd.backendayni.models.Voluntario;
import cl.tbd.backendayni.models.VoluntarioHabilidad;


public class TablesContext {
    private Connection con;
    private Sql2o sql2o;

    public TablesContext(Connection con){
        this.con = con;
    }
    public void crearTablas(){
        try{
            System.out.println("Se crearon las tablas");
            con.createQuery("create table emergencia" + "(id serial primary key, nombre text, descripcion text, fecha date, longitud NUMERIC(10,8), latitud NUMERIC(10,8), requisitosgrupales text[], requisitosindividuales text[]) ").executeUpdate();
            con.createQuery("create table estado" + "(id serial primary key, nombre text) ").executeUpdate();
            con.createQuery("create table emergenciaHabilidad" + "(id serial primary key, idEmergencia serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table estadotarea" + "(id serial primary key, idEstado serial, idTarea serial) ").executeUpdate();
            con.createQuery("create table habilidad" + "(id serial primary key, habilidad text) ").executeUpdate();
            con.createQuery("create table institucion" + "(id serial primary key, nombre text, correo text, numero text) ").executeUpdate();
            con.createQuery("create table ranking" + "(id serial primary key, porcentajeRanking real, idTarea serial, idVoluntario serial) ").executeUpdate();
            con.createQuery("create table tarea" + "(id serial primary key, nombre text, descripcion text, fecha date, longitud NUMERIC(10,8), latitud NUMERIC(10,8)) ").executeUpdate();
            con.createQuery("create table tareaHabilidad" + "(id serial primary key, idTarea serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table voluntario" + "(id serial primary key, correo text, nombreUsuario text, contrasena text, atributos text) ").executeUpdate();
            con.createQuery("create table voluntarioHabilidad" + "(id serial primary key, idVoluntario serial, idHabilidad serial) ").executeUpdate();
        } catch (Exception e) {
            System.out.println("No se crearon las tablas");
            System.out.println(e.getMessage());
        }
    }
    public void insertValores(){
        try{

        String fechastr="2022-04-21";  
        Date fecha1 = Date.valueOf(fechastr);
        fechastr="2022-03-21";
        Date fecha2 = Date.valueOf(fechastr);
        fechastr="2021-12-25";
        Date fecha3 = Date.valueOf(fechastr);
        long latitud1 = 9012_3456L;
        long latitud2 = 8012_3458L;
        long latitud3 = 5010_3450L;
        long longitud1 = 3456_3456L;
        long longitud2 = 8012_8012L;
        long longitud3 = 510_5010L;
        ArrayList<String> requisitos1 = new ArrayList<>(Arrays.asList("No tener problemas respiratorios", "Extintor"));
        ArrayList<String> requisitos2 = new ArrayList<>(Arrays.asList("Hablar ingles", "Pala"));
        ArrayList<String> requisitos3 = new ArrayList<>(Arrays.asList("Especialistas medicos", "Material medico"));
        Emergencia emergencia1 = new Emergencia(1, "Incendio", "Incendio forestal cerca de Valparaiso", fecha1, longitud1, latitud1, requisitos3, requisitos1);
        Emergencia emergencia2 = new Emergencia(2, "Derrumbe", "Derrumbe de una montaña en una carretera", fecha2, longitud2, latitud2, requisitos3, requisitos2);
        Emergencia emergencia3 = new Emergencia(3, "Terremoto", "Terremoto destruyo muchas casas", fecha3, longitud3, latitud3, requisitos3, requisitos2);

        EmergenciaRepositoryImp emergenciaimp = new EmergenciaRepositoryImp();
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        emergenciaimp.createEmergencia(emergencia1);
        emergenciaimp.createEmergencia(emergencia2);
        emergenciaimp.createEmergencia(emergencia3);

        Estado estado1 = new Estado(1, "Sin empezar");
        Estado estado2 = new Estado(2, "En curso");
        Estado estado3 = new Estado(3 , "Terminada");

        EstadoRepositoryImp estadoimp = new EstadoRepositoryImp();
        estadoimp.createEstado(estado1);
        estadoimp.createEstado(estado2);
        estadoimp.createEstado(estado3);

        EmergenciaHabilidad emergenciaHabilidad1 = new EmergenciaHabilidad(1, 1, 1);
        EmergenciaHabilidad emergenciaHabilidad2 = new EmergenciaHabilidad(2, 2, 2);
        EmergenciaHabilidadRepositoryImp emeHabimp = new EmergenciaHabilidadRepositoryImp();
        emeHabimp.createEmergenciaHabilidad(emergenciaHabilidad1);
        emeHabimp.createEmergenciaHabilidad(emergenciaHabilidad2);

        EstadoTarea estadoTarea1 = new EstadoTarea(1, 1, 1);
        EstadoTarea estadoTarea2 = new EstadoTarea(2, 2, 2);

        EstadoTareaRepositoryImp estadoTareaimp1 = new EstadoTareaRepositoryImp();
        EstadoTareaRepositoryImp estadoTareaimp2 = new EstadoTareaRepositoryImp();
        estadoTareaimp1.createEstadoTarea(estadoTarea1);
        estadoTareaimp2.createEstadoTarea(estadoTarea2);
        
        Habilidad habilidad1 = new Habilidad(1,"Correr rapido");
        Habilidad habilidad2 = new Habilidad(2,"Muy fuerte");

        HabilidadRepositoryImp habilidadimp1 = new HabilidadRepositoryImp();
        HabilidadRepositoryImp habilidadimp2 = new HabilidadRepositoryImp();
        habilidadimp1.createHabilidad(habilidad1);
        habilidadimp2.createHabilidad(habilidad2);

        Institucion institucion1 = new Institucion(1, "Fundacion caridad", "caridad@gmail.com", "942332112");
        Institucion institucion2 = new Institucion(2, "Fundacion amigable", "amigable@gmail.com", "942332222");
        
        InstitucionRepositoryImp institucionimp1 = new InstitucionRepositoryImp();
        InstitucionRepositoryImp institucionimp2 = new InstitucionRepositoryImp();

        institucionimp1.createInstitucion(institucion1);
        institucionimp2.createInstitucion(institucion2);

        Ranking ranking1 = new Ranking(1,1,1);
        Ranking ranking2 = new Ranking(2,2,2);

        RankingRepositoryImp rankingRepositoryImp1 = new RankingRepositoryImp();
        RankingRepositoryImp rankingRepositoryImp2 = new RankingRepositoryImp();

        rankingRepositoryImp1.createRanking(ranking1);
        rankingRepositoryImp2.createRanking(ranking2);

        Tarea tarea1 = new Tarea(1, "Recoger escombros", "Recoger escombros y botarlos en un sitio seguro", fecha1, longitud1, latitud1);
        Tarea tarea2 = new Tarea(2, "Recoger escombros", "Recoger escombros y botarlos en un sitio seguro", fecha2, longitud2, latitud2);

        TareaRepositoryImp tareaRepositoryImp = new TareaRepositoryImp();
        TareaRepositoryImp tareaRepositoryImp2 = new TareaRepositoryImp();
        tareaRepositoryImp.createTarea(tarea1);
        tareaRepositoryImp2.createTarea(tarea2);

        TareaHabilidad tareaHabilidad = new TareaHabilidad(1, 1, 1);
        TareaHabilidad tareaHabilidad2 = new TareaHabilidad(2, 2, 2);

        TareaHabilidadRepositoryImp tareaHabilidadRepositoryImp = new TareaHabilidadRepositoryImp();
        TareaHabilidadRepositoryImp tareaHabilidadRepositoryImp2 = new TareaHabilidadRepositoryImp();
        tareaHabilidadRepositoryImp.createTareaHabilidad(tareaHabilidad);
        tareaHabilidadRepositoryImp2.createTareaHabilidad(tareaHabilidad2);

        Voluntario voluntario = new Voluntario(1, "juan@gmail.com", "Juan", "juancontrasena", "Responsable y esforzado"); 
        Voluntario voluntario2 = new Voluntario(2, "mario@gmail.com", "Mario", "mariocontrasena", "Eficiente y acertivo"); 

        VoluntarioRepositoryImp voluntarioRepositoryImp = new VoluntarioRepositoryImp();
        VoluntarioRepositoryImp voluntarioRepositoryImp2 = new VoluntarioRepositoryImp();
        voluntarioRepositoryImp.createVoluntario(voluntario);
        voluntarioRepositoryImp2.createVoluntario(voluntario2);

        VoluntarioHabilidad voluntariohabilidad1 = new VoluntarioHabilidad(1, 1, 1);
        VoluntarioHabilidad voluntariohabilidad2 = new VoluntarioHabilidad(2, 2, 2);

        VoluntarioHabilidadRepositoryImp voluntarioHabilidadRepositoryImp = new VoluntarioHabilidadRepositoryImp();
        VoluntarioHabilidadRepositoryImp voluntarioHabilidadRepositoryImp2 = new VoluntarioHabilidadRepositoryImp();
        voluntarioHabilidadRepositoryImp.createVoluntarioHabilidad(voluntariohabilidad1);
        voluntarioHabilidadRepositoryImp2.createVoluntarioHabilidad(voluntariohabilidad2);


        }catch (Exception e) {
            System.out.println("No se pudieron insertar los valores");
            System.out.println(e.getMessage());
            System.out.println("AAAAAAAAA");
        }

    }
}
