package newpackage;
import java.sql.*; 
import java.util.ArrayList;
import java.util.List;




public class EmpDao {
    
// ------------------------------------------------ CONNECTION METHOD -----------------------------------------------------------   

    
//    ----------------------------------------------------- SAVE METHOD --------------------------------------------------------------
    
    public static int save(Emp e){
        int status=0;  
        try {
            Connection con =Conn.getConnection();
            
            PreparedStatement ps = con.prepareStatement("insert into user(name,password,email,country) values (?,?,?,?)");
            ps.setString(1,e.getName());
            ps.setString(2, e.getPassword());
            ps.setString(3,e.getEmail());
            ps.setString(4,e.getCountry());
            
          status =  ps.executeUpdate();
          
          con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        
    return status;
    }
    
    //------------------------------------------------------------- UPDATE EMPLOYEE -------------------------------------------------------
    public static int update(Emp e){  
        int status=0;  
        try{  
            Connection con=Conn.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update user set name=?,password=?,email=?,country=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getPassword());  
            ps.setString(3,e.getEmail());  
            ps.setString(4,e.getCountry());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
    //    ----------------------------------------------------------- GET ALL EMPLOYEES -------------------------------------------------
    
     public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=Conn.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){
            e.printStackTrace();
        }  
          
        return list;  
    } 
     
     
    // -------------------------------------------------------- SELECT EMPLOYEE BY ID ---------------------------------------------------
       public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=Conn.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from user where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setPassword(rs.getString(3));  
                e.setEmail(rs.getString(4));  
                e.setCountry(rs.getString(5));  
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
}
