package com.Especialidades;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EspecialidadesCriar")  
public class EspecialidadesCriar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<link href='style.css' rel='stylesheet'>"); 
        out.println("<ul class='topnav'>"); 
        out.println("<li><a href='LocaisVer'>Locais</a></li>"); 
        out.println("<li><a href='EquipamentosVer'>Equipamentos</a></li>"); 
        out.println("<li><a href='EspecialidadesVer'>Especialidades</a></li>"); 
        out.println("<li><a href='NotasVer'>Notas de Manutenção</a></li>"); 
        out.println("<li><a href='OrdensVer'>Ordens de Manutenção</a></li>"); 
        out.println("</ul>");
        out.println("<h1>Criar Especialidade</h1>");                    
        out.print("<form action='EspecialidadesSalvar' method='post'>");  
        out.print("<table>");           
        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value=''/></td></tr>");                  
        out.print("<tr><td colspan='2'><input type='submit' value='Salvar'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("<a href='EspecialidadesVer'>Ver Especialidades</a>");   
        out.close();  
    }  
}  