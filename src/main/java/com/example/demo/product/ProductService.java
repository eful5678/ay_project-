package com.example.demo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.order.Order;
import com.example.demo.reply.Reply;

/**
 * 상품과 관련된 기능들을 구현한 Service 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Service
public class ProductService {

	@Autowired
	private ProductMapper mapper;
	
	/**
	 * 상품 추가 기능
	 * insert into 상품DB values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
	 * @param p 추가할 상품 정보를 담은 객체
	 */
	public void addProduct(Product p) {
		mapper.insert(p);
	}
	
	/**
	 * 상품번호를 매개로 상품 정보 받아오기
	 * select*from 상품DB where num=?
	 * @param num 상품번호
	 * @return 상품 정보를 담은 객체
	 */
	public Product getProductByNum(int num) {
		return mapper.selectByNum(num);
	}
	
	/**
	 * 상품명을 매개로 상품번호 받아오기
	 * select*from 상품DB where name=? order by num
	 * @param name 상품명
	 * @return 상품 리스트
	 */
	public List getProductByName(String name) {
		return mapper.selectByName(name);
	}

	
	/**
	 * 가격 범위로 상품 리스트 받아오기
	 * select*from 상품DB where price between #{min} and #{max} order by num
	 * @param min 가격 최솟값
	 * @param max 가격 최댓값
	 * @return 상품 리스트
	 */
	public List getProductByPrice(int min, int max) {
		Map map = new HashMap();
		map.put("min", min);
		map.put("min", min);
		return mapper.selectByPrice(map);
	}

	/**
	 * 카테고리 1로 상품 리스트 받아오기
	 * select*from 상품DB where category1 = ? order by num
	 * @param c1 카테고리 1 Id
	 * @return 상품 리스트
	 */
	public List getProductByC1(int c1) {
		return mapper.selectByC1(c1);
	}
	
	/**
	 * 카테고리 2로 상품 리스트 받아오기
	 * select*from 상품DB where category2 = ? order by num
	 * @param c2 카테고리 2 Id
	 * @return 상품 리스트
	 */
	public List getProductByC2(int c2) {
		return mapper.selectByC2(c2);
	}
	
	/**
	 * 모든 상품 목록 받아오기
	 * select * from 상품DB
	 * @return 상품 리스트
	 */
	public List getProductAll() {
		return mapper.selectAll();
	}
	
	/**
	 * 상품 수정
	 * update 상품DB set name=?, maker=?, price=?, origin=?, material=?, quantity=?, imgPath=?, category1=?, category2=?, event_num=? where num=?
	 * @param p 수정할 상품 정보
	 */
	public void editProduct(Product p) {
		mapper.update(p);
	}
		
	/**
	 * 상품 삭제
	 * delete 상품DB where num=?
	 * @param num 삭제할 상품번호
	 */
	public void delProduct(int num) {
		mapper.delete(num);
	}
		
	/**
	 * 시퀀스로부터 nextval 받아오기
	 * select seq_product.nextval from dual
	 * @return 시퀀스 넘버
	 */
	public int getNum() {
		return mapper.getNum();
	}

	/**
	 * 이벤트번호로 상품 리스트 받아오기
	 * select * from product where event_num != 0
	 * @return 상품 리스트
	 */
	public ArrayList<Product> getProductByEvent() {
		return mapper.selectByEvent();
	}
	
	/**
	 * 주문 시 재고수량이 주문수량만큼 감소되도록 하는 기능
	 * @param o 주문 정보
	 */
	public void decreaseProduct(Order o) {
		mapper.decreaseProduct(o);
	}
	
}
