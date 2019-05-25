package com.Equipamentos;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.EquipamentoDAO;
import dao.LocalDAO;
import java.util.List;
import model.Equipamento;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import model.Local;
@WebServlet("/EquipamentosEditar")  
public class EquipamentosEditar extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();
        out.println("<link href='//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css' rel='stylesheet'>");           
        out.println("<h1>Atualizar Local</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Equipamento e=EquipamentoDAO.getById(id);  
        List<Local> list=LocalDAO.getAll();
          
        out.print("<form action='EquipamentosEditar2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='nome' value='"+e.getNome()+"'/></td></tr>");
        out.print("<tr><td colspan='2'>Local: <select name='local'>");        
        for(Local f:list){  
            if (e.getLocalId()==f.getId())
            {
                out.print("<option value=\""+f.getId()+"\" selected>"+f.getNome()+"</option>");
            }
            else
            {
                out.print("<option value=\""+f.getId()+"\" >"+f.getNome()+"</option>");
            }
        }  
        out.print("</select></td></tr>");
        out.print("<tr><td colspan='2'><input type='submit' value='Salvar'/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("<a href='EquipamentosVer'>Ver Equipamentos</a>");          
        out.close();  
    }  
}  