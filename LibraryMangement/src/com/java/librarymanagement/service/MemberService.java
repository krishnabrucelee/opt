package com.java.librarymanagement.service;

import com.java.librarymanagement.model.entity.MemberEntity;

/**
 * 
 * @author Krishna 
 * Service Class for Member
 *
 */
public interface MemberService {

	public int getMemberDetails(int memberDetails);

	public void addMemberDetails(MemberEntity member);

	public void updateMemberDetails(MemberEntity member);

	public Object getAllMemberDetails();

}
