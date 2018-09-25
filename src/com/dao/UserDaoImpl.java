package com.dao;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.bean.User;
import com.utils.CommonUtils;
public class UserDaoImpl extends CommonUtils implements UserDao {
	Connection con = null; 
 PreparedStatement pstmt = null;  
 ResultSet rs = null; 
  
 private static UserDaoImpl instance = null;
	public static UserDaoImpl getInstance(){
		if (instance == null)
			instance = new UserDaoImpl();
		return instance;
	}
	// 查询所有用户信息，并以id正序排序 
 @Override 
 public List<User> getAllUser() {
	 List<User> list = new ArrayList<User>();   

String sql = "select * from user order by id";    
try {
	con = this.getDatabaseConnection();    
    pstmt = con.prepareStatement(sql);    
    rs = pstmt.executeQuery();   
    User u = null; 
    while (rs.next()) {
    	u = new User();    
    	u.setId(rs.getInt("id")); 
        u.setName(rs.getString("name"));     
        u.setSex(rs.getString("sex"));
        u.setJob(rs.getString("job"));
        u.setAmount(rs.getInt("amount")); 
        u.setTime(rs.getString("time"));     
        u.setUnit(rs.getString("unit"));     
        u.setHeader(rs.getString("header"));          
        list.add(u); 
 }
 } catch (Exception e) {    
	 e.printStackTrace(); 
	   } finally {
		   this.closeAll(rs, pstmt, con); 
	   } 
	   return list; 
	  } 
	   // 根据id查询用户信息  
@Override 
	  public User getUserById(int id) {
	User u = null; 
	   String sql = "select * from user where id=" + id;   
	   try {
		   con = this.getDatabaseConnection();    
		   pstmt = con.prepareStatement(sql);    
		   rs = pstmt.executeQuery();   
	  
	 u = new User(); 
	     while (rs.next()) {
	    	 u = new User();     
	    	 u.setId(rs.getInt("id")); 
	         u.setName(rs.getString("name"));     
	         u.setSex(rs.getString("sex"));     
	         u.setJob(rs.getString("job"));
	         u.setAmount(rs.getInt("amount")); 
	         u.setTime(rs.getString("time"));     
	         u.setUnit(rs.getString("unit"));     
	         u.setHeader(rs.getString("header")); 
	    
	 } 
	   } catch (Exception e) {    
	 e.printStackTrace(); 
	   } finally {
		   this.closeAll(rs, pstmt, con); 
	   }   return u; 
	  } 
	   // 增加一条用户信息
@Override 
	  	 public int addUser(User u) {
	int result = 0; 
	  String sql = "insert into user(id,name,sex,job,amount,time,unit,header)" + " values(?,?,?,?,?,?,?,?)"; 
	  try {
		  con = this.getDatabaseConnection();    
		  pstmt = con.prepareStatement(sql);
		  pstmt.setInt(1, u.getId());
		  pstmt.setString(2, u.getName());    
		  pstmt.setString(3, u.getSex()); 
		  pstmt.setString(4, u.getJob());
		  pstmt.setInt(5, u.getAmount());     
	      pstmt.setString(6, u.getTime());    
	      pstmt.setString(7, u.getUnit());    
	      pstmt.setString(8, u.getHeader());    
	      result = pstmt.executeUpdate();    
	      if (result != 0) {
	    	  System.out.println("增加一条用户信息");    
	} 
	  } catch (Exception e) {    
	e.printStackTrace(); 
	  } finally {
		  this.closeAll(rs, pstmt, con); 
	  } 
	  return result; 
	 } 
	  // 修改一条用户信息
@Override 
	 public int updateUser(User u) {    
	int result = 0;  	 
	String sql = "update user set name=?,sex=?,job=?,amount=?,time=?,unit=?,header=? where id=" + u.getId(); 
	   try {    
		   con = this.getDatabaseConnection();    
		   pstmt = con.prepareStatement(sql);    
		   pstmt.setString(1, u.getName());    
			  pstmt.setString(2, u.getSex()); 
			  pstmt.setString(3, u.getJob());
			  pstmt.setInt(4, u.getAmount());     
		      pstmt.setString(5, u.getTime());    
		      pstmt.setString(6, u.getUnit());    
		      pstmt.setString(7, u.getHeader());    
	       result = pstmt.executeUpdate();    
	       if (result != 0) {
	    	   System.out.println("修改一条用户信息"); 
	   
	   } 
	     } catch (Exception e) {    
	   e.printStackTrace(); 
	     } finally {
	    	 this.closeAll(rs, pstmt, con); 
	     } 
	     return result; 
	    } 
	     // 删除一条用户信息
@Override 
	    public int deleteUser(int id) {
	    	int result = 0; 
	     
	   String sql = "delete from user where id=?";    
	   try {
		   con = this.getDatabaseConnection();    
		   pstmt = con.prepareStatement(sql);    
		   pstmt.setInt(1, id); 
	       result = pstmt.executeUpdate();    
	      if (result != 0) {
	    	  System.out.println("删除了id为"+id+"的记录"); 	      
	   } 
	     } catch (Exception e) {    
	   e.printStackTrace(); 
	     } finally {
	    	 this.closeAll(rs, pstmt, con); 
	     } 
	     return result; 
	    } 
	    }








/*import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import wsj.bean.User;


public class UserDaoLmpl implements IRepo<Salary> {
	
	private static SalaryRepo instance = null;
	public static SalaryRepo getInstance(){
		if (instance == null)
			instance = new SalaryRepo();
		return instance;
	}

	@Override
	public boolean Create(Salary t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement state =  conn.createStatement();
			state.setQueryTimeout(50);
			String sql = String.format("insert into salary(id,name,amount,time,sex,unit,job) values('%s','%s','%s','%s','%s','%s','%s')",
					t.getId(),t.getName(),t.getAmount(),t.getTime(),t.getSex(),t.getUnit(),t.getJob());

			int affectRows = state.executeUpdate(sql);
			conn.close();
			if (affectRows >0)
				success = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
		}
	 
		
	@Override
	public List<Salary> Retrie() {
		List<Salary> salarys = new ArrayList<Salary>();
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(50);
			ResultSet rs = statement.executeQuery("select * from salary by id");
			while (rs.next()) {
				Salary s = new Salary();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAmount(rs.getInt("amount"));
				s.setTime(rs.getString("time"));
				s.setSex(rs.getString("time"));
				s.setUnit(rs.getString("unit"));
				s.setJob(rs.getString("unit"));
				salarys.add(s);
			}
		conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return salarys;
		}
		
	
	@Override
	public boolean Update(Salary tOld, Salary tNew) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(50);
			String sql = String
.format("update salary set name='%s',amount=%d,time='%s',sex='%s',unit='%s',job='%s', where id=%d",tNew.getName(), tNew.getAmount(), tNew.getTime(),tNew.getSex(),
					tNew.getUnit(), tNew.getJob(), tOld.getId());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0)
				success = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean Delete(Salary t) {
		boolean success = false;
		try {
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(50);
			String sql = String.format("delete from salary where id = %d",
					t.getId());
			int affectRows = statement.executeUpdate(sql);
			conn.close();
			if (affectRows > 0 )
				success = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return success;
		}
	
	public Salary getById(int id) {
		try{
			Connection conn = CommonUtils.getInstance().getDatabaseConnection();
			Statement statement = conn.createStatement();
			statement.setQueryTimeout(50);
			String sql = String.format("select * from salary  where id=%d", id);
			ResultSet rss = statement.executeQuery(sql);
			if (rss.next()) {
			Salary temp = new Salary();
			temp.setId(rss.getInt("id"));
			temp.setName(rss.getString("name"));
			conn.close();
			return temp;
			}
			conn.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
			return null;
			}
	
	public Salary getByName(String name) {
		try {
		Connection conn = CommonUtils.getInstance().getDatabaseConnection();
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(50);
		String sql = String.format("select * from salary where name='%s'",
		name);
		ResultSet rss = statement.executeQuery(sql);
		if (rss.next()) {
		Salary temp = new Salary();
		temp.setId(rss.getInt("id"));
		temp.setName(rss.getString("name"));
		conn.close();
		return temp;
		}
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
		}

	public Salary getFirst() {
		try {
		Connection conn = CommonUtils.getInstance().getDatabaseConnection();
		Statement statement = conn.createStatement();
		statement.setQueryTimeout(50);
		String sql = String
		.format("select * from salary order by id limit 1");
		ResultSet rss = statement.executeQuery(sql);
		if (rss.next()) {
		Salary temp = new Salary();
		temp.setId(rss.getInt("id"));
		temp.setName(rss.getString("name"));
		conn.close();
		return temp;
		}
		conn.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
		}
		}*/

			 
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	