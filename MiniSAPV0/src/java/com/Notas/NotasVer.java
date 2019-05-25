package com.Notas;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 
import model.Nota;
import dao.NotaDAO;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/NotasVer")  
public class NotasVer extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();          
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<a href='NotasCriar'>Adicionar Novo Nota</a>");  
        out.println("<h1>Lista de Notas</h1>");  
          
        List<Nota> list=NotaDAO.getAll();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Título</th><th>Descrição</th><th>Id Equipamento</th><th>Nome do Equipamento</th><th>Editar</th><th>Excluir</th></tr>");    
        for(Nota e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTitulo()+"</td><td>"+e.getDescricao()+"</td><td>"+
                 e.getEquipamentoId()+"</td><td>"+e.getEquipamentoNome()+"</td><td><a href='NotasEditar?id="+e.getId()+
                 "'>editar</a></td><td><a href='NotasExcluir?id="+e.getId()+"'>excluir</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
