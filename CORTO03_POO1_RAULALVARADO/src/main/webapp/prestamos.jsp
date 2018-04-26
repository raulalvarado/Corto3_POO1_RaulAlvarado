<%-- 
    Document   : prestamos
    Created on : 04-25-2018, 05:46:17 PM
    Author     : Estudiante
--%>

<%@page import="java.util.Date"%>
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
        <title>Prestamos</title>
        <link rel='stylesheet' href='webjars/bootstrap/4.0.0-2/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/4.0.0-2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <c:if test="${valid}">
                                <div class="alert alert-success">
                                    ${mensAler}
                                </div>
            </c:if>
            <div class="row">
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Formulario</div>
                        <div class="panel-body">
                            <form method="POST" action="vistaPrestamos" name="Demo">
                                <div class="form-group">
                                    <label for="libro">Libros</label>
                                    <select name="libro" class="form-control" id="libro">
                                        <c:forEach var="item" items="<%=new controlLibros().selectLibros()%>">
                                            <option value="${item.getCodi_libr()}">${item}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="usuario">Usuarios</label>
                                    <select name="usuario" class="form-control" id="usuario">
                                        <c:forEach var="item" items="<%=new controlUsuarios().selectUsuarios()%>">
                                            <option value="${item.getCodi_usua()}">${item}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="fecha_pres">Fecha prestamo</label>
                                    <input type="datetime-local" class="form-control" name="fecha_pres" id="fecha_pres"/>
                                </div>
                                <input type="submit" class="btn btn-default" name="btonBode" value="Guardar"/>
                                
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Prestamos</div>
                        <div class="panel-body">
                            <form method="POST" action="PrestamoServlet" name="Tabl">
                                <display:table id="tablPresDevuelto" export="false" name="<%= new controlPrestamos().consTodo()%>">
                                    <display:column property="codi_libr" title="Libro" sortable="true" />
                                    <display:column property="codi_usua" title="Usuario" sortable="true" />
                                    <display:column property="fecha_press" title="Fecha de prestamo" sortable="true" format="{0,date,dd/MM/yyyy}" />
                                    <display:column property="fecha_devo" title="Fecha de devolucion" sortable="true" format="{0,date,dd/MM/yyyy}" />
                                </display:table>
                            </form>
                        </div>
                    </div>
                </div>          
            </div>
            <div class="row">
                <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Formulario</div>
                        <div class="panel-body">
                            <form method="POST" action="PrestamoServlet" name="Demo">
                                <input type="hidden" name="codigo" id="codi" value="${codigo}"/>
                                <div class="form-group">
                                    <label for="libro">Libros</label>
                                    <select disabled name="libro.id" class="form-control" id="libro">
                                        <c:forEach var="item" items="<%=new controlLibros().selectLibros()%>">
                                            <c:choose>
                                                <c:when test="${item.getCodi_libr() == libro}">
                                                    <option value="${item.getCodi_libr()}" selected>${item}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${item.getCodi_libr()}">${item}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="usuario">Usuario</label>
                                    <select disabled name="usuario" class="form-control" id="usuario">
                                        <c:forEach var="item" items="<%=new controlUsuarios().selectUsuarios()%>">
                                            <c:choose>
                                                <c:when test="${item.getCodi_usua() == usuario}">
                                                    <option value="${item.getCodi_usua()}" selected>${item}</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${item.getCodi_usua()}">${item}</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div disabled class="form-group">
                                    <label for="fecha_pres">Fecha prestamo</label>
                                    <input type="text" class="form-control" name="fecha_pres" id="fecha_pres" value="${fecha_pres}"/>
                                </div>
                                <div class="form-group">
                                    <label for="fecha_dev">Fecha devolucion</label>
                                    <p><fmt:formatDate pattern = "yyyy-MM-dd hh:mm:ss" value = "<%=new Date()%>" /></p>
                                </div>
                                    <input type="submit" class="btn btn-default" name="btonBode" value="Modificar"/>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-7">
                    <div class="panel panel-primary">
                        <div class="panel-heading">La Tabla</div>
                        <div class="panel-body">
                            <form method="POST" action="BodegaServ" name="Tabl">
                                <div class="table-responsive">
                                    <table class="table table-hover">
                                        <tr>
                                            <th scope="col">Cons</th>
                                            <th scope="col">Usuario</th>
                                            <th scope="col">Libro</th>
                                            <th scope="col">Fecha de prestamo</th>
                                        </tr>
                                        <%
                                            for (prestamos temp : new controlPrestamos().consTodo()) {
                                        %>
                                        <tr>
                                            <td><input type="radio" name="codiBodeRadi" value="<%= temp.getCodipres()%>"/></td>
                                            <td><%= temp.getUsuario().getNomb()%></td>
                                            <td><%= temp.getLibro().getNomb()%></td>
                                            <td><%= temp.getFechaprest()%></td>
                                        </tr>
                                        <%
                                            }
                                        %>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="row">
                  <div class="col-md-5">
                    <div class="panel panel-primary">
                        <div class="panel-heading">Reportes</div>
                        <div class="panel-body">
                            <div class="row">
                            <form method="POST" action="ReporteServlet" target="_blank" name="Rep">
                                <input type="hidden" name="tipo" value="1"/>
                                <input type="submit" class="btn btn-default" name="btonBode" value="Reporte Libros"/>
                            </form>
                            <form method="POST" action="ReporteServlet" target="_blank" name="Rep">
                                <input type="hidden" name="tipo" value="2"/>
                                <input type="submit" class="btn btn-default" name="btonBode" value="Reporte Prestamos"/>
                            </form>
                            </div>
                        </div>
                    </div>
                </div>
              </div>
        </div>         
    </body>
</html>
