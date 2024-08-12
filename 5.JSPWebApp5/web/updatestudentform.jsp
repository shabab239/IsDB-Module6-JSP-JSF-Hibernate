<%@page import="model.Student" %>
<%@page import="dao.StudentDAO" %>

<%
    String studentId = request.getParameter("id");
    Student student = StudentDAO.getStudentById(Long.parseLong(studentId));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Student</title>
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
            <h1 class="text-center mb-4">Edit Student</h1>

            <form action="updatestudent.jsp" method="post">
                <input type="hidden" name="id" value="<%=student.getId()%>"/>

                <div class="form-group">
                    <label for="name">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" value="<%=student.getName()%>"/>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%=student.getEmail()%>"/>
                </div>
                <div class="form-group">
                    <label for="gender">Gender</label>
                    <div>
                        <label>
                            <input type="radio" name="gender" value="Male" <%= "Male".equals(student.getGender()) ? "checked" : "" %> /> Male
                        </label>
                        <label>
                            <input type="radio" name="gender" value="Female" <%= "Female".equals(student.getGender()) ? "checked" : "" %> /> Female
                        </label>
                        <label>
                            <input type="radio" name="gender" value="Others" <%= "Others".equals(student.getGender()) ? "checked" : "" %> /> Others
                        </label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="subject">Subject</label>
                    <select name="subject" id="subject" class="form-control">
                        <option value="">Please Select</option>
                        <option value="Java" <%= "Java".equals(student.getSubject()) ? "selected" : "" %>>Java</option>
                        <option value="C#" <%= "C#".equals(student.getSubject()) ? "selected" : "" %>>C#</option>
                        <option value="PHP" <%= "PHP".equals(student.getSubject()) ? "selected" : "" %>>PHP</option>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Update</button>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
