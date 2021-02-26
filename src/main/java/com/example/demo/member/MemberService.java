package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 고객과 관련된 기능을 구현한 Service 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Service
public class MemberService {

	@Autowired
	private MemberMapper mapper;
	
	/**
	 * 고객 id를 매개로 고객 정보를 가져옴.
	 * select * from 고객DB where id=?
	 * @param id 고객 id
	 * @return 고객 정보
	 */
	public Member getMember(String id) {
		return mapper.getMember(id);
	}

	/**
	 * 고객 추가(=회원가입)
	 * 회원가입 페이지(/member/joinForm.jsp)에서 수행됨.
	 * insert into 고객DB values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
	 * @param m 추가할 고객정보
	 */
	public void addMember(Member m) {
		mapper.insert(m);
	}

	/**
	 * 고객 수정(=내정보수정)
	 * 내정보수정 페이지(/member/editForm.jsp)에서 수행됨.
	 * UPDATE 고객DB SET password=?, name=?, birth=?, gender=?, postalCode=?, roadAddress=?, address=?, tel=?, email=? WHERE id = ? 
	 * @param m 수정할 고객정보
	 */
	public void editMember(Member m) {
		mapper.update(m);
	}
	
	/**
	 * 고객 삭제(=회원탈퇴)
	 * 마이페이지(/mypage/mypage.jsp)에서 회원탈퇴 버튼 클릭시 수행
	 * delete 고객DB where id=?
	 * @param id 삭제할 고객 id
	 */
	public void delMember(String id) {
		mapper.delete(id);
	}
	
	/**
	 * 고객 id와 비밀번호 찾기.
	 * 로그인 페이지(/member/findForm.jsp)에서 찾기 버튼 클릭시 수행
	 * SELECT id, password FROM 고객DB WHERE email=? AND name=?
	 * @param email 고객 이메일
	 * @param name 고객명
	 * @return id, 비밀번호가 담긴 Member 객체
	 */
	public Member getIdPwd(String email, String name) {
		return mapper.getIdPwd(email, name);
	}
}
