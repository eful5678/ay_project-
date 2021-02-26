package com.example.demo.order;

import java.sql.Date;

import com.example.demo.member.Member;
import com.example.demo.product.Product;

/**
 * 구매이력(=order)에 대한 DTO입니다.
 * @author 김평기
 * @version main 1
 */
public class Order {
	
	/**
	 * 고유 num값입니다. [PK]
	 */
	private int num;

	/**
	 * 고객 ID값입니다. [FK]
	 */
	private String m_id;

	/**
	 * 상품 번호값입니다. [FK]
	 */
	private int p_num;

	/**
	 * 주문수량값입니다. [NOT NULL]
	 */
	private int quantity;

	/**
	 * 주문날짜입니다. [NOT NULL]
	 */
	private Date o_date;

	/**
	 * 상세주소값입니다. [NOT NULL]
	 */
	private String address;

	/**
	 * 연락번호값입니다. [NOT NULL]
	 */
	private String tel;

	/**
	 * 주문금액값입니다. [NOT NULL]
	 */
	private int cost;

	/**
	 * 주문상태값입니다. [NOT NULL, DEFAULT=0]
	 * 분류는 0(=배송준비),1(=배송중),2(=배송완료)입니다.
	 */
	private int state;

	/**
	 * 상품 이미지의 경로값입니다. [NOT IN DB]
	 */
	private String imgPath;

	/**
	 * 상품 정보가 담기는 객체입니다. [NOT IN DB]
	 */
	private Product p = new Product();

	/**
	 * 고객 정보가 담기는 객체입니다. [NOT IN DB]
	 */
	private Member m = new Member();
	
	/**
	 * 기본 생성자입니다.
	 */
	public Order() {
		super();
	}

	/**
	 * 실제 주문시 사용되는 매개변수로 갖는 생성자입니다.
	 * @param num
	 * @param m_id
	 * @param p_num
	 * @param quantity
	 * @param o_date
	 * @param state
	 */
	public Order(int num, String m_id, int p_num, int quantity, Date o_date, int state) {
		super();
		this.num = num;
		this.m_id = m_id;
		this.p_num = p_num;
		this.quantity = quantity;
		this.o_date = o_date;
		this.state = state;
	}
	
	/**
	 * 모든 필드를 매개변수로 갖는 생성자입니다.
	 * @param num
	 * @param m_id
	 * @param p_num
	 * @param quantity
	 * @param o_date
	 * @param state
	 * @param p
	 * @param m
	 */
	public Order(int num, String m_id, int p_num, int quantity, Date o_date, String address, String tel, int cost, int state,
			String imgPath, Product p, Member m) {
		super();
		this.num = num;
		this.m_id = m_id;
		this.p_num = p_num;
		this.quantity = quantity;
		this.o_date = o_date;
		this.address = address;
		this.tel = tel;
		this.cost = cost;
		this.state = state;
		this.imgPath = imgPath;
		this.p = p;
		this.m = m;
	}

	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 
	 * @return
	 */
	public String getM_id() {
		return m_id;
	}

	/**
	 * 
	 * @param m_id
	 */
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	/**
	 * 
	 * @return
	 */
	public int getP_num() {
		return p_num;
	}

	/**
	 * 
	 * @param p_num
	 */
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return
	 */
	public Date getO_date() {
		return o_date;
	}

	/**
	 * 
	 * @param o_date
	 */
	public void setO_date(Date o_date) {
		this.o_date = o_date;
	}

	/**
	 * 
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 
	 * @return
	 */
	public String getTel() {
		return tel;
	}
	
	/**
	 * 
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * 
	 * @param cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * 
	 * @return
	 */
	public int getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 
	 * @return
	 */
	public Product getP() {
		return p;
	}

	/**
	 * 
	 * @param p
	 */
	public void setP(Product p) {
		this.p = p;
	}

	/**
	 * 
	 * @return
	 */
	public Member getM() {
		return m;
	}

	/**
	 * 
	 * @param m
	 */
	public void setM(Member m) {
		this.m = m;
	}

	/**
	 * 
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * 
	 * @param imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Order [num=" + num + ", m_id=" + m_id + ", p_num=" + p_num + ", quantity=" + quantity + ", o_date="
				+ o_date + ", address=" + address + ", tel=" + tel + ", cost=" + cost + ", state=" + state
				+ ", imgPath=" + imgPath + ", p=" + p + ", m=" + m + "]";
	}

	/**
	 * 로그편의용
	 * @deprecated [사유] logback.xml에서 설정됨.
	 * @return
	 */
	public String category() {
		return "num,p_num,quantity,address,tel,cost,log_date\n";
	}

	/**
	 * 로그편의용
	 * @return
	 */
	public String content() {
		return num + "," + m.getGender() + "," + m.getBirth() + "," +  address + "," + tel 
				+ "," + m_id + "," + p_num + "," + quantity + "," + cost + ",";
	}

}
