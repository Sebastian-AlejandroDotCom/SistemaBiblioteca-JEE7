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
                        <h3 class="page-header"><i class="fas fa-book"></i> Editar Libro</h3>
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
                                    <form action="editarLibro" method="post">
                                        <input class="form-control" id="numeroSerie" name="numeroSerie" value="${libro.numeroSerie}" type="hidden">
                                        <div class="form-group">
                                            <label>ISBN</label>
                                            <input class="form-control" id="isbn" name="isbn" value="${libro.isbn}" type="text" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Título</label>
                                            <input class="form-control" id="titulo" name="titulo" value="${libro.titulo}" type="text" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Autor</label>
                                            <select class="form-control" id="autor" name="autor" size="6" multiple="multiple" required>
                                                <c:forEach items="${listaAutores}" var="autor">
                                                    <option value="${autor.idAutor}" 
                                                            <c:forEach items="${libro.libroAutorList}" var="libroAutor">
                                                                <c:if test="${libroAutor.autor.idAutor eq autor.idAutor}">
                                                                    <c:out value = "selected"/>
                                                                </c:if>
                                                            </c:forEach>>
                                                        ${autor.nombre} ${autor.apellidoPaterno}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Páginas</label>
                                            <input class="form-control" id="paginas" name="paginas" value="${libro.paginas}" type="number" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Precio</label>
                                            <input class="form-control" id="precio" name="precio" value="${libro.precio}" type="number" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Idioma</label>
                                            <select class="form-control" size="6" id="idioma" name="idioma" multiple="multiple" required>
                                                <c:forEach items="${listaIdiomas}" var="idioma">
                                                    <option value="${idioma.idIdioma}" 
                                                            <c:forEach items="${libro.libroIdiomaList}" var="libroIdioma">
                                                                <c:if test="${libroIdioma.idioma.idIdioma eq idioma.idIdioma}">
                                                                    <c:out value = "selected"/>
                                                                </c:if>
                                                            </c:forEach>>
                                                        ${idioma.nombreIdioma}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Categoría</label>
                                            <select class="form-control" id="categoria" name="categoria" size="6" multiple="multiple" required>
                                                <c:forEach items="${listaCategorias}" var="categoria">
                                                    <option value="${categoria.idCategoria}" 
                                                            <c:forEach items="${libro.libroCategoriaList}" var="libroCategoria">
                                                                <c:if test="${libroCategoria.categoria.idCategoria eq categoria.idCategoria}">
                                                                    <c:out value = "selected"/>
                                                                </c:if>
                                                            </c:forEach>>
                                                        ${categoria.nombreCategoria}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Año</label>
                                            <input class="form-control" id="anno" name="anno" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${libro.año}" />" type="date" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Publicación</label>
                                            <input class="form-control" id="publicacion" name="publicacion" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${libro.publicacion}" />" type="date" required>
                                        </div>
                                        <div class="form-group">
                                            <label>Editorial</label>
                                            <select class="form-control" id="editorial" name="editorial" required>
                                                <c:forEach items="${listaEditoriales}" var="editorial">
                                                    <option value="${editorial.idEditorial}" <c:if test="${editorial.idEditorial eq libro.editorial.idEditorial}"><c:out value = "selected"/></c:if>>${editorial.nombreEditorial}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <button type="submit" class="btn btn-primary" id="editarLibro">Actualizar</button>
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