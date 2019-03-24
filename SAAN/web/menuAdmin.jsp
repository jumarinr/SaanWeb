<%--
    Document   : index
    Created on : 17/03/2019, 09:27:33 PM
    Author     : pipel
--%>
<%@ include file="header2.jsp" %>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/SAAN">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">SAAN <sup>WEB</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">


            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                ${mensaje.get("menu")}
            </div>
            
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                    <img class="img-profile rounded-circle" src="https://cdn3.iconfinder.com/data/icons/education-flat-5/614/245_-_Reading-256.png">
                    <span style="font-size: 90%;">Estudiante</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Opciones</h6>
                        <a class="collapse-item" href="#">Registrar</a>
                        <a class="collapse-item" href="#">Consultar</a>
                        <a class="collapse-item" href="#">Modificar</a>
                        <a class="collapse-item" href="#">Eliminar</a>
                    </div>
                </div>
            </li>
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <%@ include file="header.jsp" %>


        <!-- Main Content -->
        <div id="content" style="font-size: auto;">


            <!--<img style="width: 100%; height: 200%" src="https://codigoespagueti.com/wp-content/uploads/2015/05/Gmail-GIF.gif">--!>
  
  
            <!-- Begin Page Content -->
            <div class="container-fluid">


                <!-- Content Row -->


                <div class="row">

                    <!-- Area Chart -->
                    <div class="col-xl-8 col-lg-7">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary">Info Administrador</h6>
                            </div>
                            <!-- Card Body -->
                            
                            <c:if test="${empty usu}">
                            <div style="font-size: 100%" class="card-body">
                                Nombre<br/>
                                ${usua.getNombre}
                            </div>
                            </c:if>
                        </div>
                    </div>

                    <!-- Pie Chart -->
                    <div class="col-xl-4 col-lg-5">
                        <div class="card shadow mb-4">
                            <!-- Card Header - Dropdown -->
                            <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                <h6 class="m-0 font-weight-bold text-primary">SAAN</h6>

                            </div>
                            <!-- Card Body -->
                            <div class="card-body">
                                <img style="width: 96.5%; height: 96%" src="https://codigoespagueti.com/wp-content/uploads/2015/05/Gmail-GIF.gif">
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
