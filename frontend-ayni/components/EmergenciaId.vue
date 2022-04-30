<template>
  <div class="wrapper fadeInDown scrollDiv" style="background-color: #4f3185">
    <div id="formTareasID" style="background-color: #169691">
      <h1>Emergencia 1</h1>

      <!-- Mapa -->
      <iframe
        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d26652.897618664756!2d-70.71583567072133!3d-33.3811889850277!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9662c5d793bb7325%3A0xe5a14691ce225e43!2sEstadio%20Santa%20Laura!5e0!3m2!1ses-419!2scl!4v1650682393094!5m2!1ses-419!2scl"
        width="400"
        height="300"
        style="border: 0"
        allowfullscreen=""
        loading="lazy"
        referrerpolicy="no-referrer-when-downgrade"
      ></iframe>

      <!-- Descripcion -->
      <p>
        Aca va una descripcion de la tarea que se realizara
        blablablablablablalba
      </p>

      <!-- Botones -->

      <div class="contenedorDos">
        <div>
          <a href="#">
            <button type="button" class="btn btn-primary btn-lg">
              Aceptar
            </button>
          </a>
        </div>

        <div>
          <a href="#">
            <button type="button" class="btn btn-primary btn-lg">
              Rechazar
            </button>
          </a>
        </div>
      </div>
    </div>

    <!-- Botones Tareas -->
    <div class ="contenedorTres">

      <div>
        <h1> </h1>
        <a href="#">
        <button class="botonDos" style="position: absolute; top: 10px; left: 200%; width : 200px ; padding: 10px"><span>Tarea 1</span></button>
        </a>
      </div>

      <div>
        <h1> </h1>
        <a href="#">
        <button class="botonDos" style="position: absolute; top: 100px; left: 200%; width : 200px ; padding: 10px"><span>Tarea 2</span></button>
        </a>
      </div>

      <div>
        <h1> </h1>
        <a href="#">
        <button class="botonDos" style="position: absolute; top: 200px; left: 200%; width : 200px ; padding: 10px"><span>Mas Tareas</span></button>
        </a>
      </div>

      <div>
        <h1> </h1>
        <a href="#">
        <button class="botonDos" style="position: absolute; top: 400px; left: 200%; width : 200px ; padding: 10px"><span>Voluntarios</span></button>
        </a>
      </div>

      <div>
          <a href="./NuevaTarea">
            <button type="button" style="position: absolute; top: 10px; left: 310%; width : 150px" class="btn btn-success">Nueva tarea</button>
          </a>
      </div>

    </div>
  </div>
</template>
