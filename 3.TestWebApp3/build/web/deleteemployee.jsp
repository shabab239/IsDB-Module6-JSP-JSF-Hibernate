




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
