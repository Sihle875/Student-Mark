/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import za.ac.tut.model.bl.CalculateMarksSBLocal;

/**
 *
 * @author sobet
 */
public class StudentMarksServlet extends HttpServlet {
@EJB CalculateMarksSBLocal cml;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String name = request.getParameter("name");
        int predicate = Integer.parseInt(request.getParameter("predicate"));
        int examMark = Integer.parseInt(request.getParameter("examMark"));
        double finalMark = cml.calculateFinalMark(predicate, examMark);
        String outcome = cml.determineOutcome(finalMark);
        
        updateSession(session,name,predicate,examMark,finalMark);
        
        request.setAttribute("name", name);
        request.setAttribute("predicate", predicate);
        request.setAttribute("examMark", examMark);
        request.setAttribute("finalMark", finalMark);
        request.setAttribute("outcome", outcome);
        
        RequestDispatcher disp = request.getRequestDispatcher("outcome.jsp");
        disp.forward(request, response);
    }

    private void updateSession(HttpSession session, String name, int predicate, int examMark, double finalMark) {
        List<String> names =  (ArrayList)session.getAttribute("names");
        List<Integer> predicates = (ArrayList)session.getAttribute("predicates");
        List<Integer> examMarks = (ArrayList)session.getAttribute("examMarks");
        List<Double> finalMarks = (ArrayList)session.getAttribute("finalMarks");
        
        int totStudents = (Integer)session.getAttribute("totStudents");
        totStudents++;
        session.setAttribute("totStudents", totStudents);
        
        if (finalMark >= 50) {
            int totStudentsPassed = (Integer)session.getAttribute("totStudentsPassed");
            totStudentsPassed++;
            session.setAttribute("totStudentsPassed", totStudentsPassed);
        } else if(finalMark >= 40 && finalMark < 49){
            int totStudentsQualify = (Integer)session.getAttribute("totStudentsQualify");
            totStudentsQualify++;
            session.setAttribute("totStudentsQualify", totStudentsQualify);
        } else {
            int totStudentsFailed = (Integer)session.getAttribute("totStudentsFailed");
            totStudentsFailed++;
            session.setAttribute("totStudentsFailed", totStudentsFailed);
        }
        
        names.add(name);
        session.setAttribute("names", names);
        
        predicates.add(predicate);
        session.setAttribute("predicates", predicates);
        
        examMarks.add(examMark);
        session.setAttribute("examMarks", examMarks);
        
        finalMarks.add(finalMark);
        session.setAttribute("finalMarks", finalMarks);       
       
    }

}
