<%-- 
    Document   : addStudentForm
    Created on : 1 Jul 2024, 15:32:26
    Author     : Shabab-1281539
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title</title>
    </head>
    <body>
        <h1>Add Employee</h1>

        <form action="saveemployee.jsp" method="post">
            Name: <input type="text" name="name"/> <br>
            Email: <input type="text" name="email"/> <br>
            Address: <textarea name="address" rows="5" cols="10"></textarea> <br> <br>

            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
