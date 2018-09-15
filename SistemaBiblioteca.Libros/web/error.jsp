<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="page" tagdir="/WEB-INF/tags" %>

<page:layout>
    <jsp:body>
        <!-- Content -->
            <section id="main-content">
                <section class="wrapper">
                    <div class="row">
                        <div class="col-lg-12">
                            <h3 class="page-header"></i>Error</h3>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-2"></div>
                        <div class="col-lg-8">
                            ${msgError}
                        </div>
                        <div class="col-lg-2"></div>
                    </div>
                </section>
            </section>
    </jsp:body>
    
</page:layout>