package com.student.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//import org.apache.tomcat.jdbc.pool.DataSource;
//import org.apache.tomcat.jdbc.pool.PoolProperties;

//import com.mysql.cj.jdbc.MysqlDataSource;
import com.student.demo.pojo.UserDTO;

public class UserDAO {

	String tableName = "user";
	Connection connection = null;

	void setupConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "19921104Mysql");
		connection.setAutoCommit(false);
//		MysqlDataSource dataSource = new MysqlDataSource();
//		dataSource.setUser("root");
//		dataSource.setPassword("19921104Mysql");
//		dataSource.setServerName("jdbc:mysql://localhost:3306/java");
//		connection = dataSource.getConnection();
//		PoolProperties p = new PoolProperties();
//        p.setUrl("jdbc:mysql://localhost:3306/java");
//        p.setDriverClassName("com.mysql.jdbc.Driver");
//        p.setUsername("root");
//        p.setPassword("19921104Mysql");
//        DataSource datasource = new DataSource();
//        datasource.setPoolProperties(p);
//        connection = datasource.getConnection();

	}

	public UserDTO getUserByUsernameAndPassword(String username, String password) throws Exception {
		try {
			setupConnection();
			PreparedStatement getUserByUsernameAndPasswordPreparedStatement = connection
					.prepareStatement("select * from " + tableName + " where username = ? and password = ?");
			getUserByUsernameAndPasswordPreparedStatement.setString(1, username);
			getUserByUsernameAndPasswordPreparedStatement.setString(2, password);

			ResultSet getUserByUsernameAndPasswordResultSet = getUserByUsernameAndPasswordPreparedStatement
					.executeQuery();

			UserDTO userDTO = null;
			while (getUserByUsernameAndPasswordResultSet.next()) {
				userDTO = new UserDTO();
				userDTO.resultSetSetAll(userDTO, getUserByUsernameAndPasswordResultSet);
			}
			return userDTO;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			connection.close();
		}
	}

	public UserDTO getUserById(int id) throws Exception {
		try {
			setupConnection();
			PreparedStatement getUserByIdPreparedStatement = connection
					.prepareStatement("select * from " + tableName + " where id = ?");
			getUserByIdPreparedStatement.setInt(1, id);

			ResultSet getUserByIdPreparedStatementResultSet = getUserByIdPreparedStatement.executeQuery();

			UserDTO userDTO = null;
			while (getUserByIdPreparedStatementResultSet.next()) {
				userDTO = new UserDTO();
				userDTO.resultSetSetAll(userDTO, getUserByIdPreparedStatementResultSet);
			}
			return userDTO;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			connection.close();
		}
	}

	public void deleteUserById(int id) throws Exception {
		try {
			setupConnection();
			PreparedStatement deleteByIdPreparedStatement = connection
					.prepareStatement("delete from " + tableName + " where id = ?");
			deleteByIdPreparedStatement.setInt(1, id);

			deleteByIdPreparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void updateUser(UserDTO userDTO) throws Exception {
		try {
			setupConnection();
			PreparedStatement updateUserByIdPreparedStatement = connection.prepareStatement("update " + tableName
					+ " set name = ?, phone_no = ?, dob = ?, username= ?, password=? where id = ?");
			updateUserByIdPreparedStatement.setString(1, userDTO.getName());
			updateUserByIdPreparedStatement.setString(2, userDTO.getPhone_no());
			updateUserByIdPreparedStatement.setDate(3, new java.sql.Date(userDTO.getDob().getTime()));
			updateUserByIdPreparedStatement.setString(4, userDTO.getUsername());
			updateUserByIdPreparedStatement.setString(5, userDTO.getPassword());
			updateUserByIdPreparedStatement.setInt(6, userDTO.getId());

			updateUserByIdPreparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public void createUser(UserDTO userDTO) throws Exception {
		try {
			setupConnection();
			PreparedStatement createUserPreparedStatement = connection.prepareStatement(
					"insert into " + tableName + "(name, phone_no, dob, username, password) values (?, ?, ?, ?, ?)");
			createUserPreparedStatement.setString(1, userDTO.getName());
			createUserPreparedStatement.setString(2, userDTO.getPhone_no());
			createUserPreparedStatement.setDate(3, new java.sql.Date(userDTO.getDob().getTime()));
			createUserPreparedStatement.setString(4, userDTO.getUsername());
			createUserPreparedStatement.setString(5, userDTO.getPassword());

			createUserPreparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<UserDTO> selectAll() throws Exception {
		try {
			setupConnection();
			PreparedStatement selectAllPreparedStatement = connection.prepareStatement("select * from " + tableName);

			ResultSet selectAllResultSet = selectAllPreparedStatement.executeQuery();

			List<UserDTO> userList = new ArrayList<UserDTO>();
			while (selectAllResultSet.next()) {
				UserDTO userDTO = new UserDTO();
				userDTO.resultSetSetAll(userDTO, selectAllResultSet);
				userList.add(userDTO);
			}
			return userList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			connection.close();
		}
	}
}
