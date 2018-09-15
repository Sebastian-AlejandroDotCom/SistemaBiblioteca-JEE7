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
                    <h3 class="page-header"><i class="fas fa-book"></i> Registrar Nuevo Libro</h3>
                </div>
            </div>

            <div class="container">
                <div class="row">

                    <div class="col-lg-6 offset-lg-3">
                        <section class="panel">
                            <header class="panel-heading">
                                Datos Libro
                            </header>
                            <div class="panel-body">
                                <form action="registrarLibro" method="post">
                                    <div class="form-group">
                                        <label>ISBN</label>
                                        <input class="form-control" id="isbn" name="isbn" type="text" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Título</label>
                                        <input class="form-control" id="titulo" name="titulo" type="text" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Autor</label>
                                        <select class="form-control" id="autor" name="autor" size="3" multiple="multiple" required>
                                            <c:forEach items="${listaAutores}" var="autor">
                                                <option value="${autor.idAutor}">${autor.nombre} ${autor.apellidoPaterno}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Páginas</label>
                                        <input class="form-control" id="paginas" name="paginas" type="number" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Precio</label>
                                        <input class="form-control" id="precio" name="precio" type="number" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Idioma</label>
                                        <select class="form-control" id="idioma" name="idioma" size="3" multiple="multiple" required>
                                            <c:forEach items="${listaIdiomas}" var="idioma">
                                                <option value="${idioma.idIdioma}">${idioma.nombreIdioma}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Categoría</label>
                                        <select class="form-control" id="categoria" name="categoria" size="3" multiple="multiple" required>
                                            <c:forEach items="${listaCategorias}" var="categoria">
                                                <option value="${categoria.idCategoria}">${categoria.nombreCategoria}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Año</label>
                                        <input class="form-control" id="anno" name="anno" type="date" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Publicación</label>
                                        <input class="form-control" id="publicacion" name="publicacion" type="date" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Editorial</label>
                                        <select class="form-control" id="editorial" name="editorial" required>
                                            <option value="" selected disabled>Seleccione</option>
                                            <c:forEach items="${listaEditoriales}" var="editorial">
                                                <option value="${editorial.idEditorial}">${editorial.nombreEditorial}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <button type="submit" class="btn btn-primary" id="registrarLibro">Registrar</button>
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