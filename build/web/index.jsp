<%-- 
    Document   : index
    Created on : Dec 19, 2020, 3:43:52 PM
    Author     : hoangnghiem
--%>

<%@page import="java.util.List"%>
<%@page import="com.java.demo.entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container-fluid">
        
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">
              <span data-feather="home"></span>
              Dashboard
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/WebApplication1/CategoriesServlet">
              <span data-feather="file"></span>
              Danh mục SP
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="shopping-cart"></span>
              Sản phẩm
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="users"></span>
              Khách hàng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span>
              Đơn hàng
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="layers"></span>
              Nhân viên bán hàng
            </a>
          </li>
        </ul>

      </div>
    </nav>
                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <c:set var="title" value="Danh sách sản phẩm" />

                    <h2>
                        <c:out value="${title}" />
                    </h2>
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Mã sản phẩm</th>
                            <th>Tên</th>
                            <th>Giá</th>
                            <th>Nhóm sản phẩm</th>
                            <th>Hot</th>
                        </tr>
                        </thead>   

                        <c:forEach var="p" items='${requestScope.products}'>
                        <tr>
                            <td>${p.getId()}</td>
                            <td>${p.getName()}</td>
                            <td>${p.getPrice()}</td>
                            <td>${p.getCategory()}</td>
                            <td>${p.isHot()}</td>
                        </tr>    
                        </c:forEach>

                    </table>
                </div>
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Previous">
                              <span aria-hidden="true">&laquo;</span>
                            </a>
                          </li>

                          <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                          </c:forEach>

                          <li class="page-item">
                            <a class="page-link" href="#" aria-label="Next">
                              <span aria-hidden="true">&raquo;</span>
                            </a>
                          </li>
                        </ul>
                    </nav>
                </main>
            </div>
        <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
