
package com.Notas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;  
import java.io.PrintWriter;  
import dao.NotaDAO;
import model.Nota;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/NotasEditar2")  
public class NotasEditar2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();         
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String titulo=request.getParameter("titulo");  
        String descricao=request.getParameter("descricao");  
        String equipamentoId=request.getParameter("equipamento");
          
        Nota e=new Nota();  
        e.setId(id);  
        e.setTitulo(titulo);  
        e.setDescricao(descricao);  
        e.setEquipamentoId(Integer.parseInt(equipamentoId));
          
        int status=NotaDAO.update(e);  
        if(status>0){  
            response.sendRedirect("NotasVer");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  
