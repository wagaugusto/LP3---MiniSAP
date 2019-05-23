package com;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.LocalDAO;
import java.util.List;
import model.Local;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EquipamentosCriar")  
public class EquipamentosCriar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        List<Local> list=LocalDAO.getAll();
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<h1>Criar Equipamento</h1>");                    
        out.print("<form action='EquipamentosSalvar' method='post'>");                
        out.print("Nome:<input type='text' name='nome' value=''>");                  
        out.print("<br>");
        out.print("Local: <select name='local'>");
        out.print("<option value=\"\" >Selecione o Local</option>");
        for(Local e:list){  
            out.print("<option value=\""+e.getId()+"\" >"+e.getNome()+"</option>");
        }  
        out.print("</select>");
        out.print("<br>");
        out.print("<input type='submit' value='Salvar'/>");          
        out.print("</form>");  
        out.print("<a href='EquipamentosVer'>Ver Equipamentos</a>");   
        out.close();  
    }  
}  