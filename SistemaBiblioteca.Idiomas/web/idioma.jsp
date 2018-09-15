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
                        <h3 class="page-header"><i class="fas fa-book"></i> Idiomas</h3>
                    </div>
                </div>

                <section class="panel" style="background-color: #eeeeee;">
                    <div class="row">
                        <div class="col-sm-6">
                            <a class="btn btn-success" href="registrarIdioma"><i class="fas fa-plus fa-lg"></i>
                                Registrar</a>
                            <a class="btn btn-info" href="idiomas"><i class="fas fa-clipboard-list fa-lg"></i>
                                Mostrar Todos</a>
                        </div>
                        <div class="col-sm-6">
                            <form>
                                <input id="searchId" name="searchId" class="form-control"
                                       placeholder="Buscar por ID Idioma" type="number">
                            </form>
                        </div>
                    </div>
                </section>

                <section class="panel">
                    <div class="row">
                        <div class="col-lg-12">
                            <header class="panel-heading">
                                Total de Idiomas
                            </header>

                            <table class="table table-striped table-advance table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre Idioma</th>
                                        <th>Acción</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${idiomas}" var="idioma">
                                        <tr>
                                            <td>${idioma.idIdioma}</td>
                                            <td>${idioma.nombreIdioma}</td>
                                            <td>
                                                <div class="btn-group">
                                                    <a class="btn btn-primary"
                                                       href="editarIdioma?editId=${idioma.idIdioma}"><i
                                                            class="fas fa-edit"></i></a>
                                                    <a class="btn btn-danger"
                                                       href="eliminarIdioma?deleteId=${idioma.idIdioma}"><i
                                                            class="fas fa-trash-alt"></i></a>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </section>
        </section>
    </jsp:body>

</page:layout>