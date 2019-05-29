package com.Ordens;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.NotaDAO;
import dao.EspecialidadeDAO;
import java.util.List;
import model.Nota;
import model.Especialidade;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/OrdensCriar")  
public class OrdensCriar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        List<Nota> list1=NotaDAO.getAll();
        List<Especialidade> list2=EspecialidadeDAO.getAll();
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
        out.println("<h1>Criar Ordem</h1>");                    
        out.print("<form action='OrdensSalvar' method='post'>");                
        out.print("Título:<input type='text' name='titulo' value=''><br>");
        out.print("Descrição:<input type='text' name='descricao' value=''>");
        out.print("<br>");
        out.print("Nota: <select name='nota'>");
        out.print("<option value=\"\" >Selecione a Nota</option>");
        for(Nota e:list1){  
            out.print("<option value=\""+e.getId()+"\" >"+e.getTitulo()+"</option>");
        }  
        out.print("</select>");
        out.print("<br>");
        out.print("Especialidade: <select name='especialidade'>");
        out.print("<option value=\"\" >Selecione a Especialidade</option>");
        for(Especialidade e:list2){  
            out.print("<option value=\""+e.getId()+"\" >"+e.getNome()+"</option>");
        }  
        out.print("</select>");
        out.print("<br>");
        out.print("<input type='submit' value='Salvar'/>");          
        out.print("</form>");  
        out.print("<a href='OrdensVer'>Ver Ordens</a>");   
        out.close();  
    }  
}  