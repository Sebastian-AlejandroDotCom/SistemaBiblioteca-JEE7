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
                    <h3 class="page-header"><i class="fas fa-book"></i> Editar Categoria</h3>
                </div>
            </div>

            <div class="container">
                <div class="row">

                    <div class="col-lg-6 offset-lg-3">
                        <section class="panel">
                            <header class="panel-heading">
                                Datos Categoría
                            </header>
                            <div class="panel-body">
                                <form action="editarCategoria" method="post">
                                    <input class="form-control" id="idCategoria" name="idCategoria" value="${categoria.idCategoria}" type="hidden">
                                    <div class="form-group">
                                        <label>Nombre Categoría</label>
                                        <input class="form-control" id="nombreCategoria" name="nombreCategoria" value="${categoria.nombreCategoria}" type="text" required>
                                    </div>
                                    <button type="submit" class="btn btn-primary" id="editarCategoria">Actualizar</button>
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