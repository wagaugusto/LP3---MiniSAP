package com.Notas;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.EquipamentoDAO;
import java.util.List;
import model.Equipamento;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/NotasCriar")  
public class NotasCriar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        List<Equipamento> list=EquipamentoDAO.getAll();
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
        out.println("<h1>Criar Nota</h1>");                    
        out.print("<form action='NotasSalvar' method='post'>");                
        out.print("Título:<input type='text' name='titulo' value=''><br>");
        out.print("Descrição:<input type='text' name='descricao' value=''>");
        out.print("<br>");
        out.print("Equipamento: <select name='equipamento'>");
        out.print("<option value=\"\" >Selecione o Equipamento</option>");
        for(Equipamento e:list){  
            out.print("<option value=\""+e.getId()+"\" >"+e.getNome()+"</option>");
        }  
        out.print("</select>");
        out.print("<br>");
        out.print("<input type='submit' value='Salvar'/>");          
        out.print("</form>");  
        out.print("<a href='NotasVer'>Ver Notas</a>");   
        out.close();  
    }  
}  