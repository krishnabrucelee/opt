/**
 * 
 */
package com.java.librarymanagement.service;

import com.java.librarymanagement.model.dao.MemberDao;
import com.java.librarymanagement.model.entity.MemberEntity;

/**
 * @author Krishna 
 * Service Class for Member
 *
 */
public class MemberServiceImpl implements MemberService {

	/**
	 * @param memberDetails
	 * @return userId
	 */
	public int getMemberDetails(int userId) {
		MemberDao dao = new MemberDao();
		dao.deleteUser(userId);

		return userId;
	}

	/**
	 * @param member
	 */
	public void addMemberDetails(MemberEntity member) {
		MemberDao dao = new MemberDao();
		dao.addUser(member);
	}

	/**
	 * @param member
	 */
	public void updateMemberDetails(MemberEntity member) {
		MemberDao dao = new MemberDao();
		dao.updateUser(member);
	}

	/**
	 * @return
	 */
	public Object getAllMemberDetails() {
		MemberDao dao = new MemberDao();
		dao.getAllMembers();
		return null;
	}

}
