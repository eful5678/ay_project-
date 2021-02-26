package com.example.demo.shoppingcart;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 장바구니 기능들을 구현한 Controller 클래스
 * @author 김평기
 * @version main 1
 */
@Controller
public class CartController {

	@Autowired
	private CartService service;
	
	/**
	 * 장바구니 추가 기능
	 * 상품 상세 페이지(/product/detail.jsp)에서 실행됨
	 * @param req 세션
	 */
	@RequestMapping("/cart/addCart")
	public void addCart(HttpServletRequest req) {
		String m_id = req.getParameter("m_id");
		int p_num = Integer.parseInt(req.getParameter("p_num"));
		int cost = Integer.parseInt(req.getParameter("cost"));
		Shoppingcart cart = new Shoppingcart();
		cart.setM_id(m_id);
		cart.setP_num(p_num);
		cart.setCost(cost);
		service.addCart(cart);
	}
}
