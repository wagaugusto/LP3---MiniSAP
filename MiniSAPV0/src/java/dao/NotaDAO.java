package dao;

import java.util.*;  
import java.sql.*;  
import model.Nota;
  
public class NotaDAO {  
  
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
    public static int save(Nota e){  
        int status=0;  
        try{  
            Connection con=NotaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into notas (titulo, descricao, equipamentoId) values (?,?,?)");  
            ps.setString(1,e.getTitulo());
            ps.setString(2,e.getDescricao());  
            ps.setInt(3,e.getEquipamentoId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Nota e){  
        int status=0;  
        try{  
            Connection con=NotaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update notas set titulo=?,descricao=?,localID=? where id=?");  
            ps.setString(1,e.getTitulo());
            ps.setString(2,e.getDescricao());  
            ps.setInt(3,e.getEquipamentoId());                
            ps.setInt(4,e.getId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=NotaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from notas where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Nota getById(int id){  
        Nota e=new Nota();  
          
        try{  
            Connection con=NotaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Titulo, a.Descricao, a.EquipamentoID, b.Nome as equipamentoNome" +
                    " from Notas a inner join Equipamentos b on a.EquipamentoID = b.ID where a.id = ?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setTitulo(rs.getString(2));                  
                e.setDescricao(rs.getString(3));                  
                e.setEquipamentoId(rs.getInt(4)); 
                e.setEquipamentoNome(rs.getString(5)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Nota> getAll(){  
        List<Nota> list=new ArrayList<Nota>();  
          
        try{  
            Connection con=NotaDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Titulo, a.Descricao, a.EquipamentoID, b.Nome as equipamentoNome" +
                    " from Notas a inner join Equipamentos b on a.EquipamentoID = b.ID");
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Nota e=new Nota();  
                e.setId(rs.getInt(1));  
                e.setTitulo(rs.getString(2));                  
                e.setDescricao(rs.getString(3));                  
                e.setEquipamentoId(rs.getInt(4)); 
                e.setEquipamentoNome(rs.getString(5)); 
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
