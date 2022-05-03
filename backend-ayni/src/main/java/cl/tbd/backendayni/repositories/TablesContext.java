package cl.tbd.backendayni.repositories;


import org.sql2o.Connection;
import org.sql2o.Sql2o;



public class TablesContext {
    public Connection con;
    private Sql2o sql2o;

    public TablesContext(Connection con){
        this.con = con;
    }
    public void crearTablas(){
        try{
            //CREACION DE TABLAS 
            System.out.println("Se crearon las tablas");
            con.createQuery("create table emergencia" + "(id serial primary key, nombre text, descripcion text, fecha date, longitud NUMERIC(10,8), latitud NUMERIC(10,8), requisitosgrupales text, requisitosindividuales text) ").executeUpdate();
            con.createQuery("create table estado" + "(id serial primary key, nombre text) ").executeUpdate();
            con.createQuery("create table emergenciaHabilidad" + "(id serial primary key, idEmergencia serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table estadotarea" + "(id serial primary key, idEstado serial, idTarea serial) ").executeUpdate();
            con.createQuery("create table habilidad" + "(id serial primary key, habilidad text) ").executeUpdate();
            con.createQuery("create table institucion" + "(id serial primary key, nombre text, correo text, numero text) ").executeUpdate();
            con.createQuery("create table ranking" + "(id serial primary key, porcentajeRanking real, idTarea serial, idVoluntario serial, UNIQUE(idVoluntario)) ").executeUpdate();
            con.createQuery("create table tarea" + "(id serial primary key, nombre text, descripcion text, fecha date,requerimientos text) ").executeUpdate();
            con.createQuery("create table tareaHabilidad" + "(id serial primary key, idTarea serial, idHabilidad serial) ").executeUpdate();
            con.createQuery("create table voluntario" + "(id serial primary key, correo text, nombreUsuario text, contrasena text, atributos text, UNIQUE(nombreUsuario)) ").executeUpdate();
            con.createQuery("create table voluntarioHabilidad" + "(id serial primary key, idVoluntario serial, idHabilidad serial) ").executeUpdate();
            
            //DUMP 

            //con.createQuery("").executeUpdate();

            //VOLUNTARIO

            con.createQuery("insert into voluntario(correo,nombreUsuario,contrasena,atributos) values('juan@gmail.com', 'Juan', 'juancontrasena', 'Responsable, esforzado');").executeUpdate();
            con.createQuery("insert into voluntario(correo,nombreUsuario,contrasena,atributos) values('mario@gmail.com','Mario', 'mariocontrasena', 'Eficiente, acertivo');").executeUpdate();
            con.createQuery("insert into voluntario(correo,nombreUsuario,contrasena,atributos) values('admin@gmail.com','admin', 'admin', 'Omnisciente, Poderoso');").executeUpdate();
            con.createQuery("insert into voluntario(correo,nombreUsuario,contrasena,atributos) values('felipe@gmail.com','Felipe', 'felipe', 'Hermoso, Poderoso');").executeUpdate();
            con.createQuery("insert into voluntario(correo,nombreUsuario,contrasena,atributos) values('pablo@gmail.com','pablo', 'pablo', 'Fisgon, Silencioso');").executeUpdate();
        
            //EMERGENCIA

            con.createQuery("insert into emergencia(nombre,descripcion,fecha,longitud,latitud,requisitosgrupales,requisitosindividuales) values('Incendio','Incendio forestal cerca de Valparaiso','2022-04-21',90.12345654,34.56345689,'Especialistas medicos, Material medico','No tener problemas respiratorios, Extintor');").executeUpdate();
            con.createQuery("insert into emergencia(nombre,descripcion,fecha,longitud,latitud,requisitosgrupales,requisitosindividuales) values('Derrumbe','Derrumbe de una montaña en una carretera','2022-04-21',90.12345654,34.56345689,'Especialistas medicos, Material medico','Hablar ingles, Pala');").executeUpdate();
            con.createQuery("insert into emergencia(nombre,descripcion,fecha,longitud,latitud,requisitosgrupales,requisitosindividuales) values('Terremoto','Terremoto destruyo muchas casas','2022-04-21',90.12345654,34.56345689,'Especialistas medicos, Material medico','Hablar ingles, Pala');").executeUpdate();
            
            
            //HABILIDAD

            con.createQuery("insert into habilidad(habilidad) values('Correr rapido');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Muy fuerte');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Hablar frances');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Liderazgo nato');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Nada bien');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Buena vista');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Inteligencia emocional');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Nativo de la zona');").executeUpdate();
            con.createQuery("insert into habilidad(habilidad) values('Hablar ingles');").executeUpdate();


            //ESTADO

            con.createQuery("insert into estado(nombre) values('Asignada');").executeUpdate();
            con.createQuery("insert into estado(nombre) values('Rechazada');").executeUpdate();
            con.createQuery("insert into estado(nombre) values('Aceptada');").executeUpdate();
            con.createQuery("insert into estado(nombre) values('Finalazada');").executeUpdate();
            

            //ESTADO-TAREA

            con.createQuery("insert into estadotarea(idEstado, idTarea) values(1,2);").executeUpdate();
            con.createQuery("insert into estadotarea(idEstado, idTarea) values(2,2);").executeUpdate();
            
            //INSTITUCION

            con.createQuery("insert into institucion(nombre,correo,numero) values('Fundacion caridad','caridad@gmail.com','942332112');").executeUpdate();
            con.createQuery("insert into institucion(nombre,correo,numero) values('Fundacion amigable','amigable@gmail.com','942332222');").executeUpdate();
            con.createQuery("insert into institucion(nombre,correo,numero) values('Fundacion compensasion','compensasion@gmail.com','942332552');").executeUpdate();

            //TAREA
            
            con.createQuery("insert into tarea(nombre,descripcion,fecha,requerimientos) values('Recoger escombros', 'Recoger escombros, botarlos en un sitio seguro','2022-04-21', 'Rastrillo');").executeUpdate();
            con.createQuery("insert into tarea(nombre,descripcion,fecha,requerimientos) values('Recoger basura', 'Limpiar, regocer basura','2022-05-18', 'Escoba, pala');").executeUpdate();
            con.createQuery("insert into tarea(nombre,descripcion,fecha,requerimientos) values('Recoger ropa', 'Recoger ropa para los necesitados','2022-05-18', 'lentes, pala');").executeUpdate();
            con.createQuery("insert into tarea(nombre,descripcion,fecha,requerimientos) values('Limpiar zona', 'Limpiar cada desecho','2022-05-18', 'casco, pala');").executeUpdate();
            con.createQuery("insert into tarea(nombre,descripcion,fecha,requerimientos) values('Ayudar distrubicion', 'ayudar bomberos, ayudar carabineros','2022-05-18', 'Escoba, pala');").executeUpdate();

            //____aca estoy
            //TAREA-HABILIDAD

            con.createQuery("insert into tareahabilidad(idTarea,idHabilidad) values(1,1);").executeUpdate();
            con.createQuery("insert into tareahabilidad(idTarea,idHabilidad) values(1,2);").executeUpdate();
            con.createQuery("insert into tareahabilidad(idTarea,idHabilidad) values(2,2);").executeUpdate();
            con.createQuery("insert into tareahabilidad(idTarea,idHabilidad) values(2,3);").executeUpdate();


            //VOLUNTARIO-HABILIDAD

            con.createQuery("insert into voluntariohabilidad(idVoluntario,idHabilidad) values(1,1);").executeUpdate();
            con.createQuery("insert into voluntariohabilidad(idVoluntario,idHabilidad) values(1,3);").executeUpdate();
            con.createQuery("insert into voluntariohabilidad(idVoluntario,idHabilidad) values(2,2);").executeUpdate();
            
            //EMERGENCIA-HABILIDAD
            con.createQuery("insert into emergenciaHabilidad(idEmergencia, idHabilidad) values(1,1);").executeUpdate();
            con.createQuery("insert into emergenciaHabilidad(idEmergencia, idHabilidad) values(1,3);").executeUpdate();
            con.createQuery("insert into emergenciaHabilidad(idEmergencia, idHabilidad) values(2,3);").executeUpdate();
            con.createQuery("insert into emergenciaHabilidad(idEmergencia, idHabilidad) values(2,2);").executeUpdate();

            //RANKING
            con.createQuery("insert into ranking(porcentajeRanking, idTarea, idVoluntario) values(67,1,1);").executeUpdate();
            con.createQuery("insert into ranking(porcentajeRanking, idTarea, idVoluntario) values(85,2,2);").executeUpdate();
            
        } catch (Exception e) {
            System.out.println("No se crearon las tablas");
            System.out.println(e.getMessage());
        }
    }

}