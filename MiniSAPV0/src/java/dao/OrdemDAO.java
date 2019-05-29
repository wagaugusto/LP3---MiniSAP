package dao;

import java.util.*;  
import java.sql.*;  
import model.Ordem;
  
public class OrdemDAO {  
  
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
    public static int save(Ordem e){  
        int status=0;  
        try{  
            Connection con=OrdemDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "insert into ordens (titulo, descricao, notaId, especialidadeId) values (?,?,?,?)");  
            ps.setString(1,e.getTitulo());
            ps.setString(2,e.getDescricao());  
            ps.setInt(3,e.getNotaId());  
            ps.setInt(4,e.getEspecialidadeId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int update(Ordem e){  
        int status=0;  
        try{  
            Connection con=OrdemDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update ordens set titulo=?,descricao=?,notaID=?,especialidadeId=? where id=?");  
            ps.setString(1,e.getTitulo());
            ps.setString(2,e.getDescricao());  
            ps.setInt(3,e.getNotaId());  
            ps.setInt(4,e.getEspecialidadeId());                 
            ps.setInt(5,e.getId());  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;  
        try{  
            Connection con=OrdemDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from ordens where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();                
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
    public static Ordem getById(int id){  
        Ordem e=new Ordem();  
          
        try{  
            Connection con=OrdemDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Titulo, a.Descricao, a.notaID," +
                    "b.Titulo as notaTitulo, b.equipamentoID, d.Nome as equipamentoNome,"+
                    "a.especialidadeID, c.Nome as nomeEspecialidade" +
                    " from Ordens a inner join Notas b on a.notaID = b.ID" +
                    " inner join Especialidades c on a.especialidadeID = c.ID"+
                    " inner join Equipamentos d on b.EquipamentoID = d.ID where a.id = ?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setTitulo(rs.getString(2));                  
                e.setDescricao(rs.getString(3));                  
                e.setNotaId(rs.getInt(4)); 
                e.setNotaTitulo(rs.getString(5)); 
                e.setEquipamentoId(rs.getInt(6)); 
                e.setEquipamentoNome(rs.getString(7)); 
                e.setEspecialidadeId(rs.getInt(8)); 
                e.setEspecialidadeNome(rs.getString(9)); 
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
    public static List<Ordem> getAll(){  
        List<Ordem> list=new ArrayList<Ordem>();  
          
        try{  
            Connection con=OrdemDAO.getConnection();  
            PreparedStatement ps=con.prepareStatement("select a.ID, a.Titulo, a.Descricao, a.notaID," +
                    "b.Titulo as notaTitulo, b.equipamentoID, d.Nome as equipamentoNome,"+
                    "a.especialidadeID, c.Nome as nomeEspecialidade" +
                    " from Ordens a inner join Notas b on a.notaID = b.ID" +
                    " inner join Especialidades c on a.especialidadeID = c.ID"+
                    " inner join Equipamentos d on b.EquipamentoID = d.ID"); 
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Ordem e=new Ordem();  
                e.setId(rs.getInt(1));  
                e.setTitulo(rs.getString(2));                  
                e.setDescricao(rs.getString(3));                  
                e.setNotaId(rs.getInt(4)); 
                e.setNotaTitulo(rs.getString(5)); 
                e.setEquipamentoId(rs.getInt(6)); 
                e.setEquipamentoNome(rs.getString(7)); 
                e.setEspecialidadeId(rs.getInt(8)); 
                e.setEspecialidadeNome(rs.getString(9));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
}  
