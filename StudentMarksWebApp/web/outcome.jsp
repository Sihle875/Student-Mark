<%-- 
    Document   : outcome
    Created on : 25 Mar 2024, 23:27:13
    Author     : sobet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Outcome</h1>
        <p>
            Below is the outcome.
        </p>
        <%
            String name = (String)request.getAttribute("name");
            String outcome = (String)request.getAttribute("outcome");
            int predicate = (Integer)request.getAttribute("predicate");
            int examMark = (Integer)request.getAttribute("examMark");
            double finalMark = (Double)request.getAttribute("finalMark");                   
    
        %>
        <table>
            <tr>
                <td>Student name: </td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>Predicate mark: </td>
                <td><%=predicate%></td>
            </tr>
            <tr>
                <td>Exam mark: </td>
                <td><%=examMark%></td>
            </tr>
            <tr>
                <td>Final mark: </td>
                <td><%=finalMark%>  <%=outcome%></td>
            </tr>
        </table>
        <p>
            Click <a href="student_marks_entry.html">here</a> to enter student details or <a href="summary.jsp">here</a> to display summary
        </p>
    </body>
</html>
