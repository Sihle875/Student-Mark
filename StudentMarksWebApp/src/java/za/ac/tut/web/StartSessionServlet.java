/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sobet
 */
public class StartSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);      
        
        initialiseSession(session);
        
        RequestDispatcher disp = request.getRequestDispatcher("session_started.html");
        disp.forward(request, response);
    }

    private void initialiseSession(HttpSession session) {
        List<String> names = new ArrayList<>();
        List<Integer> predicates = new ArrayList<>();
        List<Integer> examMarks = new ArrayList<>();
        List<Double> finalMarks = new ArrayList<>();
        int totStudents = 0, totStudentsPassed = 0, totStudentsFailed =0, totStudentsQualify = 0;
        
        session.setAttribute("names", names);
        session.setAttribute("predicates", predicates);
        session.setAttribute("examMarks", examMarks);
        session.setAttribute("finalMarks", finalMarks);
        session.setAttribute("totStudents", totStudents);
        session.setAttribute("totStudentsPassed", totStudentsPassed);
        session.setAttribute("totStudentsFailed", totStudentsFailed);
        session.setAttribute("totStudentsQualify", totStudentsQualify);
    }

}
