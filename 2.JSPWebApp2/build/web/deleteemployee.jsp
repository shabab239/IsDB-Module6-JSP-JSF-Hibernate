<%-- 
    Document   : savestudent
    Created on : 1 Jul 2024, 15:36:29
    Author     : Shabab-1281539
--%>

<jsp:useBean class="model.Employee" id="employee"/>
<jsp:setProperty name="employee" property="*"/>
<%@page import="dao.EmployeeDAO" %>

<%
    int result = EmployeeDAO.deleteEmployee(employee);
    
    if (result > 0){
        response.sendRedirect("employeelist.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
%>
