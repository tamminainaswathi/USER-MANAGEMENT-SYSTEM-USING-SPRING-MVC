package com.techpalle.dao;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techpalle.model.Student;

public class ConnectionCode {
	String url="jdbc:mysql://localhost:3306/palle";
	String username="root";
	String pwd="admin";
	public Connection con=null;
	public PreparedStatement ps=null;
	public Statement stm=null;
	public void delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,pwd);
			
			String qry="delete from student where id = ?";
			ps=con.prepareStatement(qry);
			ps.setInt(1, id);
			//execute query/statement
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void update(Student s)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,pwd);
			
			String qry="update student set sname=?,email=?,pw=?,mob=? where id = ?";
			ps=con.prepareStatement(qry);
			
			//set values for placeholders
			ps.setString(1,s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPass());
			ps.setLong(4, s.getMobile());
			ps.setInt(5,s.getId());
			
			//execute query/statement
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public Student getStudentById(int id)
	{
		Student s= new Student();
		Connection con = null;
		PreparedStatement ps= null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pwd);
		ps=	con.prepareStatement("Select * from student where id=?");
		ps.setInt(1,id);
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			s.setId(id);
			s.setName(rs.getString("sname"));
			s.setEmail(rs.getString("email"));
			s.setPass(rs.getString("pw"));
			s.setMobile(rs.getLong("mob"));
		}
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return s;
	}
	
	
	public void insert(Student s)  {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,pwd);
			
			String qry="insert into student(sname,email,pw,mob)values(?,?,?,?)";
			ps=con.prepareStatement(qry);
			
			//set values for placeholders
			ps.setString(1,s.getName());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPass());
			ps.setLong(4, s.getMobile());
			
			//execute query/statement
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
			
		
		
		
			
		public ArrayList<Student> getAllStudents(){
			ArrayList<Student> al = new ArrayList<Student>();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				con=DriverManager.getConnection(url,username,pwd);
				
				
				stm=con.createStatement();
				ResultSet rs=stm.executeQuery("select * from student");
				while(rs.next()) {
					
					int i=rs.getInt("id");
					String n= rs.getString("sname");
					String e= rs.getString("email");
					String p= rs.getString("pw");
					Long m= rs.getLong("mob");
					
					Student stud=new Student(i, n, e, p, m);
					al.add(stud);
					
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				if(stm!=null) {
					try {
						stm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			return al;
			
			
		}	
		
	}


