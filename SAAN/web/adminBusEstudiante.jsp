<%-- 
    Document   : adminBusEstudiante
    Created on : 24/03/2019, 04:49:15 PM
    Author     : Juan Pablo
--%>

<%@ include file="headerAdm.jsp" %>

<!-- Main Content -->
<div id="content" style="font-size: auto;">

    <!-- Begin Page Content -->
    <div class="container-fluid">


        <!-- Content Row -->
        <div class="row">

            <!-- Area Chart -->
            <div class="col-xl-8 col-lg-7">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">Estudiante</h6>
                    </div>
                    <!-- Card Body -->
                    <div style="font-size: 100%" class="card-body">
                        <c:if test="${not empty usu}">
                            <h5>Nombre:</h5>
                            ${usu.getNombre()}
                            <br/><br/>
                            <h5>Documento:</h5>
                            ${usu.getIdentificacion()}
                            <br/><br/>
                            <h5>Correo:</h5>
                            ${usu.getCorreo()}
                            <br/><br/>
                            <h5>Contraseña:</h5>
                            ${usu.getClave()}
                        </c:if>
                        <c:if test="${empty usu}">
                            No encontrado
                        </c:if>
                    </div>
                </div>
            </div>

            <!-- Pie Chart -->
            <div class="col-xl-4 col-lg-5">
                <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                        <h6 class="m-0 font-weight-bold text-primary">Busqueda</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                        <form method="POST" action="./administrador_buscarEstudiante">
                            <div class="form-group">
                                <label for="ide">Identificación o correo</label>
                                <input type="text" class="form-control" id="id" name="id" placeholder="Ingrese el documento de identidad o correco electronico" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Buscar</button>
                        </form>                    
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->
<%@ include file="footer.jsp" %>

