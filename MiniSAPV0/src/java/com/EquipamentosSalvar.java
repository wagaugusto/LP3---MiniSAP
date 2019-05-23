package com;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.EquipamentoDAO;
import model.Equipamento;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EquipamentosSalvar")  
public class EquipamentosSalvar extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("nome");  
        String localId=request.getParameter("local");
                  
        Equipamento e=new Equipamento();  
        e.setNome(name);  
        e.setLocalId(Integer.parseInt(localId));
                  
        int status=EquipamentoDAO.save(e);  
        if(status>0){               
            response.sendRedirect("EquipamentosCriar");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  