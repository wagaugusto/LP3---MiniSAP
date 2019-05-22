package com;

import java.io.IOException;  
import java.io.PrintWriter;  
import dao.LocalDao;
import model.Local;
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/LocaisSalvar")  
public class LocaisSalvar extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("nome");  
                  
        Local e=new Local();  
        e.setNome(name);  
                  
        int status=LocalDao.save(e);  
        if(status>0){               
            response.sendRedirect("LocaisCriar");  
        }else{  
            out.println("Erro ao gravar!");  
        }  
          
        out.close();  
    }  
  
}  
