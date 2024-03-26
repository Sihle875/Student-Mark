<%-- 
    Document   : summary
    Created on : 25 Mar 2024, 23:27:32
    Author     : sobet
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Summary Page</title>
    </head>
    <body>
        <h1>Summary</h1>
        <p>
            Below is the summary
        </p>
        <%
            List<String> names =  (ArrayList)session.getAttribute("names");
            List<Integer> predicates = (ArrayList)session.getAttribute("predicates");
            List<Integer> examMarks = (ArrayList)session.getAttribute("examMarks");
            List<Double> finalMarks = (ArrayList)session.getAttribute("finalMarks");
            
            int totStudentsPassed = (Integer)session.getAttribute("totStudentsPassed");
            int totStudents = (Integer)session.getAttribute("totStudents");
            int totStudentsQualify = (Integer)session.getAttribute("totStudentsQualify");
            int totStudentsFailed = (Integer)session.getAttribute("totStudentsFailed");
        %>
        <table>
            <tr>
                <td>Total number of students</td>
                <td><%=totStudents%></td>
            </tr>
            <tr>
                <td>Total number of students who passed</td>
                <td><%=totStudentsPassed%></td>
            </tr>
            <tr>
                <td>Total number of students qualify for re-exam</td>
                <td><%=totStudentsQualify%></td>
            </tr>
            <tr>
                <td>Total number of students who failed</td>
                <td><%=totStudentsFailed%></td>
            </tr>
            <%
                for (int i = 0; i < names.size(); i++) {
                        String name = names.get(i);
                        int predicate = predicates.get(i);
                        int examMark = examMarks.get(i);
                        double finalMark = finalMarks.get(i);
            %>
            <tr>
                <td>Student name: </td>
                <td><%=name%></td>
            </tr>
            <tr>
                <td>Predicate: </td>
                <td><%=predicate%></td>
            </tr>
            <tr>
                <td>Exam mark</td>
                <td><%=examMark%></td>
            </tr>
            <tr>
                <td>Final mark</td>
                <td><%=finalMark%></td>
            </tr>
            <%
                    }
            %>
        </table>
        <p>
            Click <a href="EndSessionServlet.do">here</a> to end the session.
        </p>
    </body>
</html>
