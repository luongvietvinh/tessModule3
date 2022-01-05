<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 31/12/2021
  Time: 10:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="form-group">
        <label>nhap name</label>
        <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="enter name">
    </div>
    <div class="form-group">
        <label>nhap ngay sinh</label>
        <input type=date class="form-control" name="ngaysinh" aria-describedby="emailHelp"
               placeholder="enter ngay sinh">
    </div>
    <div class="form-group">
        <label>nhap address</label>
        <input type="text" class="form-control" name="address" placeholder="enter address">
    </div>
    <div class="form-group">
        <label>nhap phoneNumber</label>
        <input type="number" class="form-control" name="phoneNumber" aria-describedby="emailHelp"
               placeholder="enter phone">
    </div>
    <div class="form-group">
        <label>nhap email</label>
        <input type="email" class="form-control" name="email" aria-describedby="emailHelp" placeholder="enter mail">
    </div>

    <div class="form-group">
        <label>chon lop</label>
        <select name="idCategory">
            <c:forEach items="${classrooms}" var="p">
                <option value="${p.idClassRoom}">
                    <p>${p.nameClassRoom}</p>
                </option>
            </c:forEach>
        </select>

    </div>
    <%--    <div class="form-check">--%>
    <%--        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
    <%--        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
    <%--    </div>--%>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

