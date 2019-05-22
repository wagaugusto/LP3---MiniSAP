package com;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.LocalDao;
import model.Local;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/LocaisCriar")  
public class LocaisCriar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Criar Local</h1>");                    
        out.print("<form action='LocaisSalvar' method='post'>");  
        out.print("<table>");           
        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value=''/></td></tr>");                  
        out.print("<tr><td colspan='2'><input type='submit' value='Salvar'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("<a href='LocaisVer'>Ver Locais</a>");   
        out.close();  
    }  
}  