<%-- 
    Document   : updateemployeeform
    Created on : 2 Jul 2024, 17:11:11
    Author     : Shabab-1281539
--%>
<%@page import="model.Employee" %>
<%@page import="dao.EmployeeDAO" %>

<%

    String employeeId = request.getParameter("id");
    Employee employee = EmployeeDAO.getEmployeeById(Long.parseLong(employeeId));

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>Edit Employee</h1>

        <form action="updateemployee.jsp" method="post">
            <input type="hidden" name="id" value="<%=employee.getId()%>"/>
            
            Name: <input type="text" name="name" value="<%=employee.getName()%>"/> <br>
            Email: <input type="text" name="email" value="<%=employee.getEmail()%>"/> <br>
            Address: <textarea name="address" rows="5" cols="10"><%=employee.getAddress()%></textarea> <br> <br>

            <input type="submit" value="Update"/>
        </form>
    </body>
</html>
