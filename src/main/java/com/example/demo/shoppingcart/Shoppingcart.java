package com.example.demo.shoppingcart;

import java.sql.Date;

/**
 * 장바구니에 대한 DTO입니다.
 * @author 김평기
 * @version main 1
 */
public class Shoppingcart {
	/**
	 * 고유 ID값입니다. [PK]
	 */
	private String m_id;
	
	/**
	 * 장바구니에 담은 상품 번호입니다. [FK]
	 */
	private int p_num;
	
	/**
	 * 장바구니에 담은 상품 가격 [NOT NULL] 
	 * 상품번호로 가져와도 되나 그 경우, 코드가 길어져서 그냥 변수로 넣은듯. 
	 */
	private int cost;
	
	/**
	 * 장바구니에 담은 날짜 [NOT NULL] 
	 */
	private Date o_date;
	
	/**
	 * 장바구니에 담은 상품 이름 
	 */
	private String name;
	
	/**
	 * 기본 생성자입니다. 
	 */
	public Shoppingcart() {
		super();
	}

	/**
	 * 모든 필드를 매개변수로 갖는 생성자입니다.
	 * @param m_id 고객 아이디
	 * @param p_num 상품 번호
	 * @param cost 상품 가격
	 * @param o_date 장바구니에 담은 날짜
	 * @param name 상품명
	 */
	public Shoppingcart(String m_id, int p_num, int cost, Date o_date, String name) {
		super();
		this.m_id = m_id;
		this.p_num = p_num;
		this.cost = cost;
		this.o_date = o_date;
		this.name = name;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public Date getO_date() {
		return o_date;
	}

	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Shoppingcart [m_id=" + m_id + ", p_num=" + p_num + ", cost=" + cost + ", o_date=" + o_date + ", name="
				+ name + "]";
	}

	/**
	 * 로그 찍을 때 편의용
	 * @deprecated logback.xml에 직접 적용.
	 * @return 간격
	 */
	public String category() {
		return "m_id,p_num,cost,o_date,name,methodName\n";
	}

	/**
	 * 로그 찍을 때 편의용
	 * @return 엑셀 규격에 맞게 작성
	 */
	public String content() {
		return  m_id + "," + p_num + "," + cost + "," + o_date + "," + name;
	}   
	
}
