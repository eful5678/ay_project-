package com.example.demo.member;

import java.sql.Date;

/**
 * 고객(=Member)에 대한 DTO입니다.
 * @author 김평기
 * @version main 1
 */
public class Member {
	/**
	 * 고유 ID값입니다. [PK]
	 */
	private String id;
	
	/**
	 * 고객 비밀번호입니다. [NOT NULL]
	 */
	private String password;
	
	/**
	 * 고객명입니다. [NOT NULL]
	 */
	private String name;
	
	/**
	 * 고객 생년월일입니다. [NOT NULL]
	 */
	private Date birth;
	
	/**
	 * 고객 성별입니다. [NOT NULL]
	 */
	private String gender;
	
	/**
	 * 고객 우편번호입니다. [NOT NULL]
	 */
	private String postalCode;
	
	/**
	 * 고객 도로명주소입니다. [NOT NULL]
	 */
	private String roadAddress;
	
	/**
	 * 고객 상세주소입니다. [NOT NULL]
	 */
	private String address;
	
	/**
	 * 고객 전화번호입니다. [NOT NULL]
	 */
	private String tel;
	
	/**
	 * 고객 이메일입니다. [NOT NULL]
	 */
	private String email;
	
	/**
	 * 기본 생성자입니다. 
	 */
	public Member() {
		super();
	}

	/**
	 * 아이디랑 비밀번호만 받는 생성자입니다.
	 * @param id
	 * @param password
	 */
	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	/**
	 * 모든 필드를 매개변수로 갖는 생성자입니다.
	 * @param id
	 * @param password
	 * @param name
	 * @param birth
	 * @param gender
	 * @param postalCode
	 * @param roadAddress
	 * @param address
	 * @param tel
	 * @param email
	 */
	public Member(String id, String password, String name, Date birth, String gender, String postalCode,
			String roadAddress, String address, String tel, String email) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.postalCode = postalCode;
		this.roadAddress = roadAddress;
		this.address = address;
		this.tel = tel;
		this.email = email;
	}

	/**
	 * id의 getter입니다.
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * id의 setter입니다.
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * password의 getter입니다.
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * password의 setter입니다.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * name의 getter입니다.
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * name의 setter입니다.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * birth의 getter입니다.
	 * @return
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * birth의 setter입니다.
	 * @param birth
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * gender의 getter입니다.
	 * @return
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * gender의 setter입니다.
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * postalCode의 getter입니다.
	 * @return
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * postalCode의 setter입니다.
	 * @param postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * roadAddress의 getter입니다.
	 * @return
	 */
	public String getRoadAddress() {
		return roadAddress;
	}

	/**
	 * roadAddress의 setter입니다.
	 * @param roadAddress
	 */
	public void setRoadAddress(String roadAddress) {
		this.roadAddress = roadAddress;
	}

	/**
	 * address의 getter입니다.
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * address의 setter입니다.
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * tel의 getter입니다.
	 * @return
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * tel의 setter입니다.
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * email의 getter입니다.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * email의 setter입니다.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", birth=" + birth + ", gender="
				+ gender + ", postalCode=" + postalCode + ", roadAddress=" + roadAddress + ", address=" + address
				+ ", tel=" + tel + ", email=" + email + "]";
	}

	/**
	 * 로그 편의용
	 * @deprecated
	 * @return
	 */
	public String category() {
		return "id,password,name,birth,gender,address,tel,email,methodName\n";
	}


	/**
	 * 로그편의용
	 * @return
	 */
	public String content() {
		return id + "," + password + "," + name + "," + birth 
				+ "," + gender + "," + address + "," + tel + "," + email;
	}

}