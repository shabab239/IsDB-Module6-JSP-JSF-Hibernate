
<jsp:useBean class="model.Student" id="student"/>
<jsp:setProperty name="student" property="*"/>
<%@page import="dao.StudentDAO" %>

<%
    int result = StudentDAO.saveStudent(student);
    
    if (result > 0){
        response.sendRedirect("studentlist.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
%>
