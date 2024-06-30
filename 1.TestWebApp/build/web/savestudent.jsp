<%-- 
    Document   : savestudent
    Created on : 30 Jun 2024, 19:04:48
    Author     : Shabab-1281539
--%>

<jsp:useBean class="model.Student" id="student"/>
<%@page import="dao.StudentDAO" %>
<jsp:setProperty name="student" property="*"/>

<%

    int i = StudentDAO.saveStudent(student);

    if (i > 0) {
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
%>
