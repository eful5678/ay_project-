package com.example.demo.shoppingcart;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 장바구니 관련 기능들을 구현한 Service 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Service
public class CartService {

	@Autowired
	private CartMapper mapper;
	
	/**
	 * 장바구니 리스트 받아오기.
	 * SELECT * FROM 장바구니DB WHERE m_id = ?
	 * @param id 고객 아이디(=세션 아이디)
	 * @return 장바구니 리스트
	 */
	public ArrayList<Shoppingcart> getShoppingcartById(String id) {
		return mapper.getShoppingcartById(id);
	}

	/**
	 * 장바구니에 상품 추가.
	 * INSERT INTO cart VALUES(?, ?, ?, sysdate)
	 * @param cart 장바구니에 추가될 상품 및 고객에 대한 정보
	 */
	public void addCart(Shoppingcart cart) {
		mapper.insertCart(cart);
	}
	
	
}
