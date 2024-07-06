<%-- 
    Document   : employeelist
    Created on : 1 Jul 2024, 16:50:04
    Author     : Shabab-1281539
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDAO" %>
<%@page import="java.util.List" %>


<%

    List<Employee> employees = EmployeeDAO.employeeList();
    request.setAttribute("employees", employees);

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
    <style>
        .center-table {
            margin: 0 auto;
            width: 80%;
            text-align: center;
        }
        table {
            width: 100%;
        }
        table th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <div class="center-table">
        <h1>Employee List</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <core:forEach var="employee" items="${employees}">
                    <tr>
                        <td>${employee.getId()}</td>
                        <td>${employee.getName()}</td>
                        <td>${employee.getEmail()}</td>
                        <td>${employee.getAddress()}</td>
                        <td>
                            <a href="updateemployeeform.jsp?id=${employee.getId()}">Edit</a>
                            <a href="deleteemployee.jsp?id=${employee.getId()}">Delete</a>
                        </td>
                    </tr>
                </core:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
