<template>
    <div class="container" style="background-color: #4f3185">
        <div id="formContent" style="background-color: #169691">
            <h1>Tarea 1</h1>

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
            
        </div>
        <div id="formContent" style="background-color: #169691">
            <h1>Voluntarios</h1>
                <table id="example" class="table table-striped table-bordered" style="background-color: #169691">
                    <thead>
                        <tr>
                            <th style="width: 100x;"></th>                
                            <th style="width: 800px;">Nombre Voluntario</th>
                            <th style="width: 100x;">Ranking</th>
                            <th style="width: 100px;"><input type="checkbox" id="all" onclick="checkAll(this)"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- {% for para la lista de voluntarios ordenados por Ranking %} -->
                        <tr>                
                            <td name="Ver Perfil">
                                <a href="#">
                                    <button type="button" class="btn btn-primary btn-lg">
                                    Ver Perfil
                                    </button>
                                </a>
                            </td>
                            <td name="NombreVoluntario"> NombreVoluntario </td>
                            <td name="Ranking">Ranking va aqui</td>
                            <td>
                                <input type="checkbox" id="one_checkbox" name="one_checkbox">
                            </td>
                        </tr>
                        <!-- {% for para la lista de voluntarios ordenados por Ranking %} -->
                    </tbody>
                </table>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Seleccionar</button>
        </div>
    </div>

</template>
