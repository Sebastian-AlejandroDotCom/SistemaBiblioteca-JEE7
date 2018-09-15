<%-- 
    Document   : layout
    Created on : 16-07-2018, 12:14:09
    Author     : sebastian
--%>

<%@tag description="Layout Page Sistema Biblitoeca" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head id="head">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Sebastian-Alejandro">
        <link rel="shortcut icon" href="img/favicon.png">

        <title>Sistema Biblioteca</title>

        <!-- Bootstrap CSS -->
        <link href="static/css/bootstrap.min.css" rel="stylesheet">
        <!-- bootstrap theme -->
        <link href="static/css/bootstrap-theme.css" rel="stylesheet">
        <!-- font icon -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
        <!-- Custom styles -->
        <link href="static/css/style.css" rel="stylesheet">
        <link href="static/css/style-responsive.css" rel="stylesheet"/>
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
        <!--[if lt IE 9]>
        <script th:src="@{~//js/html5shiv.js}"></script>
        <script th:src="@{~//js/respond.min.js}"></script>
        <script th:src="@{~//js/lte-ie7.js}"></script>
        <![endif]-->

    </head>
    <body>
        <section id="container" class="">
            <!--header start-->
            <header id="header" class="header dark-bg">
                <!--logo start-->
                <a href="/SistemaBiblioteca.Inicio/inicio" class="logo"><i class="fas fa-university"></i> Sistema <span class="lite">Biblioteca</span></a>
                <!--logo end-->
            </header>

            <!--sidebar start-->
            <aside>
                <div id="sidebar" class="nav-collapse ">
                    <!-- sidebar menu start-->
                    <ul class="sidebar-menu">
                        <li class="sub-menu">
                            <a href="javascript:;" class="">
                                <i class="fas fa-book"></i>
                                <span>Libros</span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="/SistemaBiblioteca.Libros/libros"><i class="fas fa-angle-right"></i>Libros</a></li>
                                <li><a class="" href="/SistemaBiblioteca.Autores/autores"><i class="fas fa-angle-right"></i>Autor</a></li>
                                <li><a class="" href="/SistemaBiblioteca.Editoriales/editoriales"><i class="fas fa-angle-right"></i>Editorial</a></li>
                                <li><a class="" href="/SistemaBiblioteca.Categorias/categorias"><i class="fas fa-angle-right"></i>Categoría</a></li>
                                <li><a class="" href="idiomas"><i class="fas fa-angle-right"></i>Idioma</a></li>
                                <li><a class="" href="/SistemaBiblioteca.Estados/estados"><i class="fas fa-angle-right"></i>Estado</a></li>
                            </ul>
                        </li>
                        <li>
                            <a class="" href="#">
                                <i class="fas fa-truck"></i>
                                <span>Distribuidores</span>
                            </a>
                        </li>

                        <li>
                            <a class="" href="#">
                                <i class="fas fa-file-alt"></i>
                                <span>Gestión Factura</span>
                            </a>
                        </li>

                        <li class="sub-menu">
                            <a href="javascript:;" class="">
                                <i class="fas fa-shopping-basket"></i>
                                <span>Gestión Compra</span>
                                <span class="menu-arrow arrow_carrot-right"></span>
                            </a>
                            <ul class="sub">
                                <li><a class="" href="#"><i class="fas fa-angle-right"></i>Método de Pago</a></li>
                                <li><a class="" href="#"><i class="fas fa-angle-right"></i>Transacción</a></li>
                            </ul>
                        </li>

                    </ul>
                    <!-- sidebar menu end-->
                </div>
            </aside>
            <!--sidebar end-->

            <div id="body">
                <jsp:doBody/>
            </div>

            <!--footer start-->
            <footer id="footer">
                <div class="text-center">
                    <div class="credits">
                        <span>Desarrollado en <i class="fab fa-java fa-2x"></i>Java por <a href="#" class="">Sebastián Herrera</a></span>
                        <br/>
                        <br/>
                    </div>
                </div>
            </footer>
            <!--footer end-->

        </section>
        <!-- container section end -->

        <!-- javascripts -->
        <div id="scripts">
            <script src="static/js/jquery.js"></script>
            <script src="static/js/bootstrap.min.js"></script>
            <script src="static/js/jquery.scrollTo.min.js"></script>
            <script src="static/js/jquery.nicescroll.js" type="text/javascript"></script>
            <script src="static/js/scripts.js"></script>
        </div>
    </body>
</html>