package com.Especialidades;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 
import model.Especialidade;
import dao.EspecialidadeDAO;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EspecialidadesVer")  
public class EspecialidadesVer extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<a href='EspecialidadesCriar'>Adicionar Nova Especialidade</a>");  
        out.println("<h1>Lista de Especialidades</h1>");  
          
        List<Especialidade> list=EspecialidadeDAO.getAll();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Nome</th><th>Editar</th><th>Excluir</th></tr>");    
        for(Especialidade e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+
                 "</td><td><a href='EspecialidadesEditar?id="+e.getId()+"'>editar</a></td>"+
                 "<td><a href='EspecialidadesExcluir?id="+e.getId()+"'>excluir</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
