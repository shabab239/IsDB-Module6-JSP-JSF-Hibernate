<%-- 
    Document   : studentaddform
    Created on : 30 Jun 2024, 19:21:48
    Author     : Shabab-1281539
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Form</h1>
        
        <form action="savestudent.jsp" method="post">
            Name: <input type="text" name="name"> <br>
            Roll: <input type="number" name="roll"> <br>
            Cell: <input type="number" name="cell"> <br>
            Address: <input type="text" name="address"> <br> <br>
            
            <input type="submit" value="Save">
        </form>
    </body>
</html>
