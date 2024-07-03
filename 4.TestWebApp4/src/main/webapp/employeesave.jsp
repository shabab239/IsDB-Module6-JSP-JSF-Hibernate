

<jsp:useBean class="model.Employee" id="employee"/>
<jsp:setProperty name="employee" property="*"/>
<%@page import="dao.EmployeeDAO" %>

<%
    int result = EmployeeDAO.saveEmployee(employee);
    
    if (result > 0){
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
%>
