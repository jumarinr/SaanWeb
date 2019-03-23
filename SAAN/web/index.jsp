<%--
    Document   : index
    Created on : 17/03/2019, 09:27:33 PM
    Author     : pipel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SAAN: ${mensaje.get("ini")}</title>

        <!-- Custom fonts for this template-->
        <link href="dashboard/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="dashboard/css/sb-admin-2.min.css" rel="stylesheet">

        <c:if test="${empty mensaje}">
            <script>location.href = './inicio'</script>
        </c:if>
    </head>

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

                <!-- Mejores grupos -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <img class="img-profile rounded-circle" src="https://cdn1.iconfinder.com/data/icons/unigrid-bluetone-human-vol-1/60/011_007_collective_group_masses_people_company-128.png">
                        <span style="font-size: 70%;">${mensaje.get("megru")}</span>
                    </a>
                </li>
                <!-- Personas que van perdiendo -->
                <li class="nav-item">
                    <a class="nav-link collapsed" href="#">
                        <img class="img-profile rounded-circle" src="https://cdn4.iconfinder.com/data/icons/jetflat-2-gestures/60/007_002_no_dislike_disagree_vote_thumbs-down_thumbs_left-128.png">
                        <span style="font-size: 70%;">${mensaje.get("estper")}</span>
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
          <div class="container-fluid">


              <!-- Content Row -->


              <div class="row">

                  <!-- Area Chart -->
                  <div class="col-xl-8 col-lg-7">
                      <div class="card shadow mb-4">
                          <!-- Card Header - Dropdown -->
                          <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                              <h6 class="m-0 font-weight-bold text-primary">Integrantes</h6>

                          </div>
                          <!-- Card Body -->

                          <div style="font-size: 100%" class="card-body">
                              <ol>
                                  <li>
                                      Juan Pablo Moya Alarcón
                                  </li>
                                  <li>
                                      Juan Diego Marin Rodriguez
                                  </li>
                                  <li>
                                      Juan Felipe Usuga Villegas
                                  </li>
                                  <li>
                                      Julian Ospina Murgueitio
                                  </li>

                              </ol>
                              <br/><br/>
                          </div>
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
      <!-- End of Footer -->

  </div>

            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>


        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/chart.js/Chart.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/chart-area-demo.js"></script>
        <script src="js/demo/chart-pie-demo.js"></script>

    </body>

</html>
