package com;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 
import model.Equipamento;
import dao.EquipamentoDAO;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EquipamentosVer")  
public class EquipamentosVer extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();          
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<a href='EquipamentosCriar'>Adicionar Novo Equipamento</a>");  
        out.println("<h1>Lista de Equipamentos</h1>");  
          
        List<Equipamento> list=EquipamentoDAO.getAll();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Nome</th><th>Id Local</th><th>Nome do Local</th><th>Editar</th><th>Excluir</th></tr>");    
        for(Equipamento e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getNome()+"</td><td>"+e.getLocalId()+
                 "</td><td>"+e.getLocalNome()+"</td><td><a href='EquipamentosEditar?id="+e.getId()+
                 "'>editar</a></td><td><a href='EquipamentosExcluir?id="+e.getId()+"'>excluir</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
    }  
}
