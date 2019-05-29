package com.Ordens;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List; 
import model.Ordem;
import dao.OrdemDAO;

import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/OrdensVer")  
public class OrdensVer extends HttpServlet {  
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
        out.println("<h1>Lista de Ordens</h1>");  
          
        List<Ordem> list=OrdemDAO.getAll();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Título</th><th>Descrição</th>"+
                "<th>Id do Equipamento</th><th>Nome do Equipamento</th>"+
                "<th>Id da Nota</th><th>Título da Nota</th>"+
                "<th>Id da Especialidade</th><th>Nome da Especialidade</th>"+
                "<th>Editar</th><th>Excluir</th></tr>");    
        for(Ordem e:list){  
         out.print("<tr><td>"+e.getId()+"</td><td>"+e.getTitulo()+"</td><td>"+e.getDescricao()+
                 "</td><td>"+e.getEquipamentoId()+"</td><td>"+e.getEquipamentoNome()+
                 "</td><td>"+e.getNotaId()+"</td><td>"+e.getNotaTitulo()+
                 "</td><td>"+e.getEspecialidadeId()+"</td><td>"+e.getEspecialidadeNome()+
                 "</td><td><a href='OrdensEditar?id="+e.getId()+
                 "'>editar</a></td><td><a href='OrdensExcluir?id="+e.getId()+"'>excluir</a></td></tr>");  
        }  
        out.print("</table><br>");  
        out.println("<a href='OrdensCriar'>Adicionar Nova Ordem</a>");    
        out.close();  
    }  
}
