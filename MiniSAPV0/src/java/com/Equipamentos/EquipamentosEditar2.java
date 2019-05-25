
package com.Equipamentos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;  
import java.io.PrintWriter;  
import dao.EquipamentoDAO;
import model.Equipamento;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EquipamentosEditar2")  
public class EquipamentosEditar2 extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
          throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();         
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String name=request.getParameter("nome");  
        String localId=request.getParameter("local");
          
        Equipamento e=new Equipamento();  
        e.setId(id);  
        e.setNome(name);          
        e.setLocalId(Integer.parseInt(localId));
          
        int status=EquipamentoDAO.update(e);  
        if(status>0){  
            response.sendRedirect("EquipamentosVer");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  
