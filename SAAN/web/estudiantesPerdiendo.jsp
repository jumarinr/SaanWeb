<%-- 
    Document   : estudiantesPerdiendo
    Created on : 27/03/2019, 12:17:58 AM
    Author     : juann
--%>
<%--
    Document   : index
    Created on : 17/03/2019, 09:27:33 PM
    Author     : juann
--%>
    <%@ include file="header2.jsp" %>
    <body id="page-top">
        
        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" >
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

                <!-- Mejores grupos -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="./inicio">
                        <img class="img-profile rounded-circle" src="https://cdn1.iconfinder.com/data/icons/unigrid-bluetone-human-vol-1/60/011_007_collective_group_masses_people_company-128.png">
                        <span style="font-size: 70%;">${mensaje.get("megru")}</span>
                    </a>
                </li>
                <!-- Personas que van perdiendo -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="./estudiantesPerdiendo">
                        <img class="img-profile rounded-circle" src="https://cdn4.iconfinder.com/data/icons/jetflat-2-gestures/60/007_002_no_dislike_disagree_vote_thumbs-down_thumbs_left-128.png">
                        <span style="font-size: 70%;">${mensaje.get("estper")}</span>
                    </a>
                </li>
                <!--Generar datos ficticios-->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="./datosFicticios">
                        <img class="img-profile rounded-circle" src="https://cdn2.iconfinder.com/data/icons/ui-data-storage-sever/64/data-storage-add-256.png">
                        <span style="font-size: 70%;">Generar datos ficticios</span>
                    </a>
                </li>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <%@ include file="header.jsp" %>


      <!-- Main Content -->
      <div id="content" style="font-size: auto;">

        
          <!--<img style="width: 100%; height: 200%" src="https://codigoespagueti.com/wp-content/uploads/2015/05/Gmail-GIF.gif">--!>


          <!-- Begin Page Content -->
                 <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Nombre</th>
                      <th>Materia</th>
                      <th>Grupo</th>
                      <th>Identificacion</th>
                      <th>Correo</th>
                      <th>Nota</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Tiger Nixon</td>
                      <td>Estadistica 1</td>
                      <td>2</td>
                      <td>1289138</td>
                      <td>yaper@unal.edu.co</td>
                      <td>2.91</td>
                    </tr>
                    <tr>
                      <td>Garrett Winters</td>
                      <td>Algebra Lineal</td>
                      <td>1</td>
                      <td>30071728</td>
                      <td>jodido@gmail.com</td>
                      <td>2.9</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
          <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <%@ include file="footer.jsp" %>
      




