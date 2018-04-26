<%-- 
    Document   : prestamos
    Created on : 04-25-2018, 05:46:17 PM
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sv.udb.modelos.prestamos"%>
<%@page import="com.sv.udb.modelos.libros"%>
<%@page import="com.sv.udb.modelos.usuarios"%>
<%@page import="com.sv.udb.contoladores.controlPrestamos"%>
<%@page import="com.sv.udb.contoladores.controlLibros"%>
<%@page import="com.sv.udb.contoladores.controlUsuarios"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Prestamos</title>
        <link rel='stylesheet' href='webjars/bootstrap/4.0.0-2/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/4.0.0-2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            boolean estaModi = Boolean.parseBoolean((String) request.getAttribute("estaModi"));
            String nombBton = estaModi ? "Nuevo" : "Guardar"; // Para el texto del botón
            String clssEditBton = estaModi ? "" : "display: none"; //Pra ocultar botones
        %>
        <div class="container">
            <div class="alert alert-success">
                <h1 class="text-center">Mantenimiento de prestamos</h1>
            </div>
            <div class="row">
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">El Formulario</div>
                        <div class="panel-body">
                            <div class="alert alert-success">
                                ${mensAler}
                            </div>
                            <form method="POST" action="PrestamosServ" name="Demo">
                                <input type="hidden" name="codi" id="codi" value="${codi}"/>
                                <div class="form-group">
                                    <label for="libr">Seleccione el libro</label>
                                    <select class="custom-select" name="codLib" id="codLib">
                                        <option selected disabled>Seleccione el libro</option>
                                        <%
                                            for (libros temp : new controlLibros().selectLibros()) {
                                        %>
                                        <option value="<%= temp.getCodilib()%>"><%= temp.getNomb()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="usua">Seleccione el usuario</label>
                                    <select class="custom-select" name="codProv" id="codProv">
                                        <option selected disabled>Seleccione el usuario</option>
                                        <%
                                            for (usuarios temp : new controlUsuarios().selectUsuarios()) {
                                        %>
                                        <option value="<%= temp.getCodiusua()%>"><%= temp.getNomb()%></option>
                                        <%
                                            }
                                        %>
                                    </select>
                                </div>
                                    <div class="form-group">
                                    <label for="Fprest">Seleccione la fecha de prestamo</label>
                                    <input id="datetime" type="datetime-local" value="${fechaPrestamo}">
                                </div>
                                <input type="submit" class="btn btn-default" name="btnPres" value="<%=nombBton%>"/>
                                <input type="submit" class="btn btn-primary" style="<%=clssEditBton%>" name="bntPres" value="Modificar"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Prestamos</div>
                        <div class="panel-body">
                            <form method="POST" action="PrestamosServ" name="Tabl">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th scope="col">Cons</th>
                                            <th scope="col">Usuario</th>
                                            <th scope="col">Libro</th>
                                            <th scope="col">Fecha prestamo</th>
                                            <th scope="col">Fecha devolucion</th>
                                        </tr>
                                        <%
                                            for (prestamos temp : new controlPrestamos().consTodo()) {
                                        %>
                                        <tr>
                                            <td><input type="radio" name="codiPresRadio" value="<%= temp.getCodipres()%>"/></td>
                                            <td><%= temp.getUsuario().getNomb()%></td>
                                            <td><%= temp.getLibro().getNomb()%></td>
                                            <td><%= temp.getFechadevo()%></td>
                                            <td><%= temp.getFechaprest()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                                <input type="submit" class="btn btn-success" name="btnPres" value="Consultar"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
