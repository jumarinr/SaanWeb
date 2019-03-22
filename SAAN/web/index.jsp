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
    <script>location.href='./inicio'</script>
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
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <!-- Sidebar Toggle (Topbar) -->
          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!-- AVISO SAAN -->

                        
            <div class="input-group-append" style="margin-top: 1%">
                <h4>${mensaje.get("saan")}</h4>
            </div>
            


          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">          
      
            <div class="topbar-divider d-none d-sm-block"></div>            
            <form action="./inicio" method="POST" style="margin-top: 6.5%">                
                <button type="submit" value="español" name="action" style="width: auto; height: auto;"class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">
                    ${mensaje.get("esp")}
                </button>
                <button type="submit" value="ingles" name="action" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">
                    ${mensaje.get("ing")}
                </button>
            </form>
            <!-- Nav Item - User Information -->
            <li class="nav-item dropdown no-arrow">
              <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="mr-2 d-none d-lg-inline text-gray-600 small">${mensaje.get("inisec")}</span>
                <img class="img-profile rounded-circle" src="https://cdn1.iconfinder.com/data/icons/unigrid-bluetone-symbols-arrows-vol-3/60/024_106_enter_input_login_door_sign-128.png">
              </a>
            </li>

          </ul>

        </nav>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          
          <!-- Content Row -->
          <div class="row">

            

          
          <!-- Content Row -->


          <!-- Content Row -->
          <div class="row">


            <div class="col-lg-6 mb-4">


              <!-- Approach -->
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">Saan Web</h6>
                </div>
                <div class="card-body">
               </div>
                <img style="width: 100%; height: 200%" src="https://codigoespagueti.com/wp-content/uploads/2015/05/Gmail-GIF.gif">
                
                
              </div>

            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; SAAN 2019</span>
          </div>
        </div>
      </footer>
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

