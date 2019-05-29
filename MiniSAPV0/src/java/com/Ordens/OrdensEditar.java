package com.Ordens;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.OrdemDAO;
import dao.NotaDAO;
import dao.EspecialidadeDAO;
import java.util.List;
import model.Ordem;
import model.Nota;  
import model.Especialidade;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/OrdensEditar")  
public class OrdensEditar extends HttpServlet {  
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
        out.println("<h1>Atualizar Ordem</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Ordem e=OrdemDAO.getById(id);  
        List<Nota> list1=NotaDAO.getAll();
        List<Especialidade> list2=EspecialidadeDAO.getAll();
          
        out.print("<form action='OrdensEditar2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Título:</td><td><input type='text' name='titulo' value='"+e.getTitulo()+"'/></td></tr>");
        out.print("<tr><td>Descrição:</td><td><input type='text' name='descricao' value='"+e.getDescricao()+"'/></td></tr>");
        out.print("<tr><td colspan='2'>Equipamento: <select name='nota'>");        
        for(Nota f:list1){  
            if (e.getNotaId()==f.getId())
            {
                out.print("<option value=\""+f.getId()+"\" selected>"+f.getTitulo()+"</option>");
            }
            else
            {
                out.print("<option value=\""+f.getId()+"\" >"+f.getTitulo()+"</option>");
            }
        }  
        out.print("</select></td></tr>");
        out.print("<tr><td colspan='2'>Especialidade: <select name='especialidade'>");        
        for(Especialidade f:list2){  
            if (e.getEspecialidadeId()==f.getId())
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
        out.print("<a href='OrdensVer'>Ver Ordens</a>");          
        out.close();  
    }  
}  