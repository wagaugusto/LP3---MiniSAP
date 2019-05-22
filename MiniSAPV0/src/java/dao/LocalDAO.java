package dao;

import java.util.*;  
import java.sql.*;  
import model.Local;
  
public class LocalDao {  
  
    public static Connection getConnection(){  
        Connection con=null;  
        try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;"
		                    + "database=MiniSAP;" +
	                              "user=sa;" +
	                              "password=123456;"); 
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
    public static int save(Local e){  
        int status=0;  
        try{  
            Connection con=LocalDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into locais(nome) values (?)");  
            ps.setString(1,e.getNome());                            
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Local e){  
        int status=0;  
        try{  
            Connection con=LocalDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update locais set nome=? where id=?");  
            ps.setString(1,e.getNome());              
            ps.setInt(2,e.getId());                
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=LocalDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from locais where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Local getById(int id){  
        Local e=new Local();  
          
        try{  
            Connection con=LocalDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from locais where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2));                  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Local> getAll(){  
        List<Local> list=new ArrayList<Local>();  
          
        try{  
            Connection con=LocalDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from locais");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Local e=new Local();  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2));                  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
