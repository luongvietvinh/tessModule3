<%--
  Created by IntelliJ IDEA.
  User: Admind
  Date: 31/12/2021
  Time: 10:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <title>Title</title>
</head>
<body>
<form  method="post">
    <div class="form-group">
        <label >nhap lai name</label>
        <input type="text" class="form-control" name="name" aria-describedby="emailHelp" placeholder="enter name">
    </div>
    <div class="form-group">
        <label>nhap lai ngay sinh</label>
        <input type="text" class="form-control" name="ngaysinh" aria-describedby="emailHelp" placeholder="enter ngay sinh">
    </div>
    <div class="form-group">
        <label >nhap lai address</label>
        <input type="text" class="form-control" name="address" placeholder="enter address">
    </div>
    <div class="form-group">
        <label>nhap lai phonenumber</label>
        <input type="text" class="form-control" name="phoneNumber" aria-describedby="emailHelp" placeholder="enter phone">
    </div>
    <div class="form-group">
        <label>nhap lai email</label>
        <input type="text" class="form-control" name="email" aria-describedby="emailHelp" placeholder="enter email">
    </div>
    <%--    <div class="form-check">--%>
    <%--        <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
    <%--        <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
    <%--    </div>--%>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
