<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 31/12/2021
  Time: 9:40 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        .fakeimg {
            height: 200px;
            background: #aaa;
        }
    </style>
</head>
<body>

<div class="jumbotron text-center" style="margin-bottom:0">

</div>

<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-6">
            <h2><i>student</i></h2>
            <form action="/student?action=search" method="post">
                <input type="search" name="search">
                <button type="submit">search</button>
            </form>
            <br>
            <table class="table table-striped">
                <thead>
                <tbody>

            <th>stt       </th>
            <td>name       </td>
            <th>ngay_sinh  </th>
            <th>dia_chi   </th>
            <th>sdt        </th>
            <th>email      </th>
            <th>tenlop      </th>
           <th>  <a href="/student?action=create&id=${p.id}" class="btn btn-success">create</a></th>
                <c:forEach items="${students}" var="p" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${p.name}</td>
                        <td>${p.ngaysinh}</td>
                        <td>${p.address}</td>
                        <td>${p.phoneNumber}</td>
                        <td>${p.email}</td>
                        <td>${p.nameClasRoom}</td>

                        <td><a href="/student?action=edit&id=${p.id}" class="btn btn-success">edit</a></td>
                        <td><a href="/student?action=delete&id=${p.id}" class="btn btn-danger">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
                </thead>


            </table>
            <h1> user name</h1>
            <%= request.getParameter("name") %>>


        </div>
    </div>
</div>

<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>

</body>
</html>