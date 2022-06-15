package cl.tbd.backendayni.repositories;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class TablesContext {
    public Connection con;

    public TablesContext(Connection con) {
        this.con = con;
    }

    public void crearTablas() {

        // CREACION DE TABLAS
        System.out.println("Se crearon las tablas");

        con.createQuery("create table IF NOT EXISTS emergencia"
                + "(id serial primary key, nombre text, descripcion text unique, fecha date, reqs_grupales text, reqs_individuales text,longitude NUMERIC(5,3), latitude NUMERIC(5,3)) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS voluntario"
                + "(id serial primary key, correo text unique, usuario text, password text, atributos text) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS tarea"
                + "(id serial primary key, id_emergencia serial, nombre text, descripcion text, fecha date, requerimientos text, longitude NUMERIC(5,3), latitude numeric(5,3)) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS estado" + "(id serial primary key, nombre text) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS habilidad" + "(id serial primary key, nombre text) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS institucion"
                + "(id serial primary key, nombre text unique, usuario text, password text, correo text unique, numero text) ")
                .executeUpdate();
        con.createQuery("create table IF NOT EXISTS ranking"
                + "(id serial primary key, porcentaje real, id_tarea serial, id_voluntario serial) ")
                .executeUpdate();
        /*
         * Tablas intermedias
         */
        // Tabla de relaciones entre emergencia y habilidad
        con.createQuery("create table IF NOT EXISTS emergencia_habilidad"
                + "(id serial primary key, id_emergencia serial, id_habilidad serial) ")
                .executeUpdate();
        // Tabla de relaciones entre estado y tarea
        con.createQuery("create table IF NOT EXISTS estado_tarea"
                + "(id serial primary key, id_estado serial, id_tarea serial) ")
                .executeUpdate();
        // Tabla de relaciones entre tarea y habilidad
        con.createQuery("create table IF NOT EXISTS tarea_habilidad"
                + "(id serial primary key, id_tarea serial, id_habilidad serial) ")
                .executeUpdate();
        // Tabla de relaciones entre voluntario y habilidad
        con.createQuery("create table IF NOT EXISTS voluntario_habilidad"
                + "(id serial primary key, id_voluntario serial, id_habilidad serial) ")
                .executeUpdate();

    }

    public void dump() {
        /* Ahora el dump */
        // con.createQuery("").executeUpdate();
        // Añadir valores a la tabla emergencia
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        + " values ('Incendio', 'Incendio en Cafetería Baker Cat, Arica', '2022-04-21', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-18.474162', '-70.293878')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        + " values ('Derrumbe', 'Derrumbe cerca de Centor Médico Arauco, Los Vilos', '2022-04-25', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-31.916272', '-71.512124')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        + " values ('Inundación', 'Inundación en Av. Juan Larrondo con Luis Infante, Canela Baja', '2022-05-02', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-31.397671', '-71.457410')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        + " values ('Terremoto', 'Terremoto en Punta Arenas', '2022-05-14', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-53.141895', '-70.890551')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        + " values ('Accidente', 'Accidente en Av. Los Carrera, Concepción', '2022-05-23', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-36.827106', '-73.060376')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        +
                        " values ('Socavon', 'Socavon en Av. Heroes de la Concepción, Iquique', '2022-05-29', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-20.235734', '-70.143236')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        +
                        " values ('Incendio', 'Incendio en ELECNET.SPA, Talca', '2022-06-07', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-35.431311', '-71.666043')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        +
                        " values ('Accidente', 'Accidente en Av. Crucero con Los Maquis, Puerto Montt', '2022-06-08', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-41.473424', '-72.958259')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        +
                        " values ('Persona extraviada', 'Persona extraviada en Villarrica, vista por última vez cerca del Salón de Belleza Estilos y Sonrisas', '2022-06-10', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-39.283742', '-72.227936')")
                .executeUpdate();
        con.createQuery(
                "insert into emergencia (nombre, descripcion, fecha, reqs_grupales, reqs_individuales, longitude, latitude)"
                        +
                        " values ('Incendio', 'Incendio en Cerro Colorado, Valparaíso', '2022-06-11', 'Especialistas medicos, Material medico', 'No tener problemas respiratorios, Extintor', '-33.073912', '-71.627030')")
                .executeUpdate();

        // Insertar valores en tabla voluntario
        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('michaelRThomas@gmail.com', 'Hatter','baebe2jei1Oh','Responsable, Esforzado')")
                .executeUpdate();

        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('kyleFDulac@gmail.com', 'Hinceeng49','jeeFi7ae','Eficiente, Acertivo')")
                .executeUpdate();
        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('susanBTaylor@gmail.com', 'Beeked','oahee9AeNg5','Flojo, Certero')")
                .executeUpdate();
        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('maryDWisniewski@gmail.com', 'Dialt1937','Aeveip5xu2','Honesto, Insoportable')")
                .executeUpdate();
        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('kennethRSegura@gmail.com', 'Prearknot91','aZaeTh9oh','Inquieto, Hiperactivo')")
                .executeUpdate();
        con.createQuery(
                "insert into voluntario (correo, usuario, password, atributos) values ('Dumbdlore@gmail.com', 'Lentand','OoZ4baek2ch','Magia, Dominio de Miradas')")
                .executeUpdate();

        // Insertar valores en tabla tarea
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (1, 'Recoger basura', 'Recoger escombros, botarlos en un sitio seguro', '2022-04-21', 'Pala, Rastrillo', '-33.389804', '-70.655240')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (2, 'Recoger Ropa', 'Recoger ropa para los necesitados', '2022-04-25', 'Auto, Bolsas tamaño jumbo', '-33.450758', '-70.679715')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (2, 'Limpiar zona', 'Limpiar zona afectada por la emergencia', '2022-05-14', 'Pala, Chuzo', '-32.878800', '-71.455213')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (3, 'Alertar a personas', 'Anunciar a las personas sobre la emergencia', '2022-05-14', 'Megafono, Parlante', '-33.444194', '-70.653674')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (3, 'Poner centros de acopio', 'Colocar centros de acopio para las personas necesitadas', '2022-05-02', 'Mesas, Toldos', '-33.458078', '-70.640655')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Recolectar agua', 'Traer agua de las zonas aledañadas a la zona de emergencia', '2022-06-07', 'Auto, Bidones', '-34.985543', '-71.237379')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Registrar zona', 'Buscar los alrededores por señales de vida', '2022-06-08', 'Binoculares, Walkie Talkies', '-33.404486', '-70.568487')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (4, 'Ayudar autoridades', 'Guiar autoridades a zonas más criticas de la emergencia', '2022-07-14', 'Chaqueta reflectante, Auto', '-36.827106', '-73.060376')")
                .executeUpdate();
        con.createQuery(
                "insert into tarea (id_emergencia, nombre, descripcion, fecha, requerimientos, longitude, latitude) values (5, 'Señalizar emergencia', 'Colocar los señalimientos disponibles para advertir en las carreteras', '2022-06-25', 'Chaqueta reflectante, Linterna', '-32.878800', '-71.455213')")
                .executeUpdate();

        // Insertar valores en tabla estado
        con.createQuery("insert into estado (nombre) values ('Asignada')")
                .executeUpdate();
        con.createQuery("insert into estado (nombre) values ('Rechazada')")
                .executeUpdate();
        con.createQuery("insert into estado (nombre) values ('Aceptada')")
                .executeUpdate();
        con.createQuery("insert into estado (nombre) values ('Finalizada')")
                .executeUpdate();

        // Insertar valores en tabla habilidad
        con.createQuery("insert into habilidad (nombre) values ('Correr rapido')")
                .executeUpdate();

        con.createQuery("insert into habilidad (nombre) values ('Saber primeros auxilios')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Liderazgo nato')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Nadar excelente')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Saber tecnicas de supervivencia')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Saber lenguaje de señas')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Manejo de varias de varios lenguajes')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Muy fuerte')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Habilidades inquisitivas')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Trato con niños en situaciones de estrés')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Hablar con animales')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Usuario Stand')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Telepatía')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Omnipotencia')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Agua control')")
                .executeUpdate();
        con.createQuery("insert into habilidad (nombre) values ('Mira a ambos lados antes de cruzar')")
                .executeUpdate();

        // Insertar valores en tabla institucion
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('Ayni', 'Ayni', 'pabloelpato', 'correoOficial@ayni.cl','+569968435251')")
                .executeUpdate();
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('Bomberos', 'Bomberos', '123456', 'soporte@bomberos.cl','132')")
                .executeUpdate();
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('Carabineros', 'Carabineros', '123456', 'soporte@carabineros.cl','133')")
                .executeUpdate();
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('VeriSure', 'VeriSure', '654321', 'soporte@verisure.com','6005000111')")
                .executeUpdate();
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('007', '007', '456123', 'soporte@007.com','007')")
                .executeUpdate();
        con.createQuery(
                "insert into institucion (nombre, usuario, password, correo, numero) values ('Admin', 'Admin', 'admin1234', 'Admin@gmail.com','0')")
                .executeUpdate();

    }

}