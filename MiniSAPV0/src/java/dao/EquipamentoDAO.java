package dao;

import java.util.*;  
import java.sql.*;  
import model.Equipamento;
  
public class EquipamentoDAO {  
  
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
    public static int save(Equipamento e){  
        int status=0;  
        try{  
            Connection con=EquipamentoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into equipamentos (nome, localId) values (?,?)");  
            ps.setString(1,e.getNome());                            
            ps.setInt(2,e.getLocalId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Equipamento e){  
        int status=0;  
        try{  
            Connection con=EquipamentoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update equipamentos set nome=?,localID=? where id=?");  
            ps.setString(1,e.getNome());              
            ps.setInt(2,e.getLocalId());                
            ps.setInt(2,e.getId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=EquipamentoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from equipamentos where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Equipamento getById(int id){  
        Equipamento e=new Equipamento();  
          
        try{  
            Connection con=EquipamentoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Nome, a.LocalID, b.Nome as localNome" +
                    " from Equipamentos a inner join Locais b on a.LocalID = b.ID where a.id = ?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2));                  
                e.setLocalId(rs.getInt(3)); 
                e.setLocalNome(rs.getString(4)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Equipamento> getAll(){  
        List<Equipamento> list=new ArrayList<Equipamento>();  
          
        try{  
            Connection con=EquipamentoDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Nome, a.LocalID, b.Nome as localNome" +
                    " from Equipamentos a inner join Locais b on a.LocalID = b.ID"); 
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Equipamento e=new Equipamento();  
                e.setId(rs.getInt(1));  
                e.setNome(rs.getString(2)); 
                e.setLocalId(rs.getInt(3)); 
                e.setLocalNome(rs.getString(4));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
