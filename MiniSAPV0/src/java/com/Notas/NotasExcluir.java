package com.Notas;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import dao.NotaDAO;
@WebServlet("/NotasExcluir")  
public class NotasExcluir extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        NotaDAO.delete(id);  
        response.sendRedirect("NotasVer");  
    }  
}