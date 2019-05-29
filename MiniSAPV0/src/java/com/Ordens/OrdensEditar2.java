
package com.Ordens;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;  
import java.io.PrintWriter;  
import dao.OrdemDAO;
import model.Ordem;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/OrdensEditar2")  
public class OrdensEditar2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();         
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String titulo=request.getParameter("titulo");  
        String descricao=request.getParameter("descricao");  
        String notaId=request.getParameter("nota");
        String especialidadeId=request.getParameter("especialidade");
          
        Ordem e=new Ordem();  
        e.setId(id);  
        e.setTitulo(titulo);  
        e.setDescricao(descricao);  
        e.setNotaId(Integer.parseInt(notaId));
        e.setEspecialidadeId(Integer.parseInt(especialidadeId));
          
        int status=OrdemDAO.update(e);  
        if(status>0){  
            response.sendRedirect("OrdensVer");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  
