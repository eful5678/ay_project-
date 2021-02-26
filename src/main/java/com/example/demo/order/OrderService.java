package com.example.demo.order;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 주문과 관련된 기능들을 구현한 Service 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Service
public class OrderService {

	@Autowired
	private OrderMapper mapper;

	/**
	 * 고객 Id를 매개로 주문내역을 받아오는 기능.
	 * SELECT * FROM orderDB WHERE m_id=?
	 * @param id 고객 id(=세션 id) 
	 * @return
	 */
	public ArrayList<Order> getMyOrderListById(String id) {
		return mapper.getMyOrderListById(id);
	}

	/**
	 * 주문하기 기능
	 * INSERT INTO orderDB VALUES(?, ?, ?, ?, ?, ?, sysdate, ?, ?)
	 * @param o 추가할 주문 정보를 담은 객체
	 */
	public void addOrder(Order o) {
		mapper.insertOrder(o);
	}

	/**
	 * 모든 주문내역 받아오기
	 * SELECT * FROM orderDB ORDER BY num
	 * @return 주문내역 리스트
	 */
	public ArrayList<Order> getAllOrderList() {
		return mapper.getAllOrderList();
	}
	
	/**
	 * 주문상태 변경
	 * UPDATE orderDB SET state=? WHERE num=?
	 * @param num 주문상태를 변경할 주문내역의 번호
	 * @param state 주문상태
	 */
	public void changeState(int num, int state) {
		mapper.updateState(num, state);
	}

	/**
	 * 시퀀스로부터 번호 받아오기
	 * SELECT SEQ_ORDERDB.nextval FROM dual
	 * @return 시퀀스 번호
	 */
	public int getNum() {
		return mapper.getNum();
	}
}
