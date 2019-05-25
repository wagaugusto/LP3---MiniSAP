package com.Especialidades;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.EspecialidadeDAO;
import model.Especialidade;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/EspecialidadesSalvar")  
public class EspecialidadesSalvar extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("nome");  
                  
        Especialidade e=new Especialidade();  
        e.setNome(name);  
                  
        int status=EspecialidadeDAO.save(e);  
        if(status>0){               
            response.sendRedirect("EspecialidadesCriar");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  
