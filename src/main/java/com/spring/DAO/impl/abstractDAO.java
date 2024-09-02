package com.spring.DAO.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.ResourceBundle;



import com.spring.DAO.genericDAO;
import com.spring.mapper.rowMapper;



public class abstractDAO<T> implements genericDAO<T> {

//	static ResourceBundle mrs = ResourceBundle.getBundle("db");

	public static Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/news_jdbc";
			String user ="root";
			String password ="tuanhoang@89";
//			Class.forName(mrs.getString("driverName"));
//			String url = mrs.getString("url");
//			String user =mrs.getString("user");
//			String password =mrs.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		} 	
	}

	@Override
	public <T> ArrayList<T> query(String sql, rowMapper<T> rowMapper, Object... parameters) {
		ArrayList<T> reults = new ArrayList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			setParameter(ps,parameters);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				reults.add(rowMapper.mapRow(resultSet));
			}
			return reults;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		
	}

	private void setParameter(PreparedStatement ps, Object... parameters) {
		try {
			for(int i = 0 ; i< parameters.length;i++) {
				Object parameter = parameters[i];
				int index = i+1;
				if(parameter instanceof Long){
					ps.setLong(index, (Long) parameter);
				}else if(parameter instanceof String) {
					ps.setString(index,(String)parameter);
				}else if(parameter instanceof Integer) {
					ps.setInt(index,(Integer)parameter);
				}else if(parameter instanceof Timestamp) {
					ps.setTimestamp(index,(Timestamp)parameter);
				}
//				else if(parameter == null) {
//					ps.setNull(index,Types.NULL);
//				}
			} 
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update(String sql, Object... parameters) {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql); 
			setParameter(ps,parameters);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Long id = null;
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql ,ps.RETURN_GENERATED_KEYS); 
			setParameter(ps,parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getLong(1);// chu y
			}
			con.commit();
			return id;
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if(con != null) {
					con.close();
				}if(ps != null) {
					ps.close();
				}if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void delete(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql); 
			setParameter(ps,parameters);
			ps.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			int count = 0;
			con = getConnection();
			ps = con.prepareStatement(sql);
			setParameter(ps,parameters);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			return count;
		} catch (SQLException e) {
			return 0;
		} finally {
			try {
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return 0;
			}
		}
	}




}
