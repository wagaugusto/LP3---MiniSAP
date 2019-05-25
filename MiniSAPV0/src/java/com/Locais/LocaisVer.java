package com.Locais;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 
import model.Local;
import dao.LocalDAO;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/LocaisVer")  
public class LocaisVer extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<a href='LocaisCriar'>Adicionar Novo Local</a>");  
        out.println("<h1>Lista de Locais</h1>");  
          
        List<Local> list=LocalDAO.getAll();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Nome</th><th>Editar</th><th>Excluir</th></tr>");    
        for(Local e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+
                 "</td><td><a href='LocaisEditar?id="+e.getId()+"'>editar</a></td>"+
                 "<td><a href='LocaisExcluir?id="+e.getId()+"'>excluir</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
