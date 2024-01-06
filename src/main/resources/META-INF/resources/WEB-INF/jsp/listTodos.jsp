<%@include file="common/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>List Todo Page</title>
</head>
<body>
<%@include file="common/navigation.jspf" %>
<div>Welcome ${name}</div>
<hr>
<div class="container">
<h2>Your Todos </h2>
<table class="table">
    <thead>
    <tr>
        <th>Id</th>
        <th>Description</th>
        <th>Target Date</th>
        <th>Is Done</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-warning">Update</a> </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
    <a href="add-todos" class="btn btn-success" >Add Todo</a>
</div>
<%@include file="common/footer.jspf" %>