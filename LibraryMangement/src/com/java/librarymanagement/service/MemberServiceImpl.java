/**
 * 
 */
package com.java.librarymanagement.service;

import com.java.librarymanagement.model.dao.MemberDao;

/**
 * @author Assistanz
 *
 */
public class MemberServiceImpl implements MemberService {

	@Override
	public int getMemberDetails(int userId) {
		MemberDao dao = new MemberDao();
		dao.deleteUser(userId);

		return userId;
	}

}
