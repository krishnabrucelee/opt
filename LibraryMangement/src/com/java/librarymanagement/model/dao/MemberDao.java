/**
 * 
 */
package com.java.librarymanagement.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.librarymanagement.model.entity.MemberEntity;
import com.java.librarymanagement.utils.DbUtil;

/**
 * @author Krishna
 *
 */
public class MemberDao {

	private Connection connection;

	public MemberDao() {
		connection = DbUtil.getConnection();
	}

	// Add Members
	public void addUser(MemberEntity member) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(firstname,lastname,dob,email) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, member.getFirstName());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(member.getDob().getTime()));
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Delete Members
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from users where userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Members
	public void updateUser(MemberEntity member) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update users set firstname=?, lastname=?, dob=?, email=?" + "where userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, member.getFirstName());
			preparedStatement.setString(2, member.getLastName());
			preparedStatement.setDate(3, new java.sql.Date(member.getDob().getTime()));
			preparedStatement.setString(4, member.getEmail());
			preparedStatement.setInt(5, member.getUserid());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// List All Members
	public List<MemberEntity> getAllMembers() {
		List<MemberEntity> members = new ArrayList<MemberEntity>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from users");
			while (rs.next()) {
				MemberEntity member = new MemberEntity();
				member.setUserid(rs.getInt("userid"));
				member.setFirstName(rs.getString("firstname"));
				member.setLastName(rs.getString("lastname"));
				member.setDob(rs.getDate("dob"));
				member.setEmail(rs.getString("email"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return members;
	}

	// List by MemberId
	public MemberEntity getUserById(int userId) {
		MemberEntity member = new MemberEntity();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				member.setUserid(rs.getInt("userid"));
				member.setFirstName(rs.getString("firstname"));
				member.setLastName(rs.getString("lastname"));
				member.setDob(rs.getDate("dob"));
				member.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}
}
