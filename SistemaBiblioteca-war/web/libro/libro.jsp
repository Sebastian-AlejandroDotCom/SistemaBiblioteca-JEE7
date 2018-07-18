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
                        <h3 class="page-header"><i class="fas fa-book"></i> Libros</h3>
                    </div>
                </div>

                <section class="panel" style="background-color: #eeeeee;">
                    <div class="row">
                        <div class="col-sm-6">
                            <a class="btn btn-success" href="libros/registrar"><i class="fas fa-plus fa-lg"></i>
                                Registrar</a>
                            <a class="btn btn-info" href="libros"><i class="fas fa-clipboard-list fa-lg"></i>
                                Mostrar Todos</a>
                        </div>
                        <div class="col-sm-6">
                            <form>
                                <input id="searchISBN" name="searchISBN" class="form-control"
                                       placeholder="Buscar por ISBN" type="number">
                            </form>
                        </div>
                    </div>
                </section>

                <section class="panel">
                    <div class="row">
                        <div class="col-lg-12">
                            <header class="panel-heading">
                                Total de Libros
                            </header>

                            <table class="table table-striped table-advance table-hover">
                                <thead>
                                    <tr>
                                        <th>ISBN</th>
                                        <th>Título</th>
                                        <th>Autor</th>
                                        <th>Páginas</th>
                                        <th>Precio</th>
                                        <th>Idioma</th>
                                        <th>Categoría</th>
                                        <th>Stock</th>
                                        <th>Año</th>
                                        <th>Publicación</th>
                                        <th>Editorial</th>
                                        <th>Acción</th>
                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach items="${libros}" var="libro">
                                        <tr>
                                            <td>${libro.isbn}</td>
                                            <td>${libro.titulo}</td>
                                            <td>
                                                <c:if test="${empty libro.libroAutorList}">No Registrado(s)</c:if>
                                                <c:forEach items="${libro.libroAutorList}" var="autores">
                                                    <c:out default='ninguno' escapeXml="true" value="${autores.autor.nombre}" />
                                                    <c:out default='ninguno' escapeXml="true" value="${autores.autor.apellidoPaterno}" />
                                                </c:forEach>
                                            </td>
                                            <td>${libro.paginas}</td>
                                            <td>${libro.precio}</td>
                                            <td>
                                                <c:if test="${empty libro.libroIdiomaList}">No Registrado(s)</c:if>
                                                <c:forEach items="${libro.libroIdiomaList}" var="idiomas">
                                                    <c:out default='ninguno' escapeXml="true" value="${idiomas.idioma.nombreIdioma}" />
                                                </c:forEach>
                                            </td>
                                            <td>
                                                <c:if test="${empty libro.libroCategoriaList}">No Registrada(s)</c:if>
                                                <c:forEach items="${libro.libroCategoriaList}" var="categorias">
                                                    <c:out default='ninguno' escapeXml="true" value="${categorias.categoria.nombreCategoria}" />
                                                </c:forEach>
                                            </td>
                                            <td>${libro.stock}</td>
                                            <td><fmt:formatDate type="DATE" value="${libro.año}" /></td>
                                            <td><fmt:formatDate type="DATE" value="${libro.publicacion}" /></td>
                                            <td>
                                                <c:set var="editorial" scope="request" value="${libro.editorial}"/>
                                                <c:out default='No Registrada' escapeXml="true" value="${editorial.nombreEditorial}" />
                                            </td>
                                            <td>
                                                <div class="btn-group">
                                                    <a class="btn btn-primary"
                                                       href="@{/libros/editar(editISBN=${libro.getIsbn()})}"><i
                                                            class="fas fa-edit"></i></a>
                                                    <a class="btn btn-danger"
                                                       href="@{/libros/eliminar(deleteISBN=${libro.getIsbn()})}"><i
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
