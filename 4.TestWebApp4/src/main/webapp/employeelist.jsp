
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDAO" %>
<%@page import="java.util.List" %>


<%

    List<Employee> employees = EmployeeDAO.employeeList();
    request.setAttribute("employees", employees);

%>

<jsp:include page="header.jsp"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee List</title>
</head>
<body>
    <div class="container">
        <h1 class="text-center">Employee List</h1>

        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
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
                            <a class="btn btn-primary btn-sm" href="updateemployeeform.jsp?id=${employee.getId()}">Edit</a>
                            <a class="btn btn-danger btn-sm ml-1" href="deleteemployee.jsp?id=${employee.getId()}">Delete</a>
                        </td>
                    </tr>
                </core:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>