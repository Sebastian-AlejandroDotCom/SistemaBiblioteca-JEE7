<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="page" tagdir="/WEB-INF/tags/" %>

<page:layout>
    <jsp:body>
        <!-- Content -->
        <section id="main-content">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h3 class="page-header"><i class="fas fa-book"></i> Editar Autor</h3>
                </div>
            </div>

            <div class="container">
                <div class="row">

                    <div class="col-lg-6 offset-lg-3">
                        <section class="panel">
                            <header class="panel-heading">
                                Datos Autor
                            </header>
                            <div class="panel-body">
                                <form action="editarAutor" method="post">
                                    <input class="form-control" id="idAutor" name="idAutor" value="${autor.idAutor}" type="hidden">
                                    <div class="form-group">
                                        <label>Nombre</label>
                                        <input class="form-control" id="nombre" name="nombre" value="${autor.nombre}" type="text" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Apellido Paterno</label>
                                        <input class="form-control" id="apellidoPaterno" name="apellidoPaterno" value="${autor.apellidoPaterno}" type="text" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Apellido Materno</label>
                                        <input class="form-control" id="apellidoMaterno" name="apellidoMaterno" value="${autor.apellidoMaterno}" type="text" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary" id="editarAutor">Actualizar</button>
                                </form>

                            </div>
                        </section>
                    </div>

                </div>
            </div>
        </section>
    </section>
    </jsp:body>
</page:layout>