<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page import="model.Student" %>
<%@page import="dao.StudentDAO" %>
<%@page import="java.util.List" %>

<%
    List<Student> students = StudentDAO.studentList();
    request.setAttribute("students", students);
    
    int serial = 1;
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student List</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">TEST WEB APP</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" aria-current="page" href="/webapp3">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="addstudentform.jsp">Add Student</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="studentlist.jsp">Student List</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container mt-4">
            <h1 class="text-center">Student List</h1>

            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>SL</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Subject</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <core:forEach var="student" items="${students}">
                        <tr>
                            <td><%= serial++ %></td>
                            <td>${student.getName()}</td>
                            <td>${student.getEmail()}</td>
                            <td>${student.getGender()}</td>
                            <td>${student.getSubject()}</td>
                            <td>
                                <a href="updatestudentform.jsp?id=${student.getId()}" class="btn btn-primary btn-sm">Edit</a>
                                <a href="deletestudent.jsp?id=${student.getId()}" class="btn btn-danger btn-sm">Delete</a>
                            </td>
                        </tr>
                    </core:forEach>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
