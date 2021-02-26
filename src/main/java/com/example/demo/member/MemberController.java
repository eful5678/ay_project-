package com.example.demo.member;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 고객과 관련된 기능들을 구현한 Controller 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Controller
public class MemberController {

	// 로그
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberService service;
	
	/**
	 * 기본 url 입력시 메인 페이지(/member/main.jsp)로 이동하도록 url을 자동 리턴
	 * @return Redirect할 Url 
	 */
	@RequestMapping("/")
	public String root() {
		//main페이지를 첫화면으로 설정한다. 
		return "redirect:/member/main";
	}
	
	/**
	 * 메인 페이지로 이동
	 */
	@RequestMapping("/member/main")
	public void main() {
		//main.jsp를 불러와 화면에 보여준다.
	}
	

	/**
	 * 회원가입 페이지(/member/joinForm.jsp)를 불러오고 동시에 아이디중복확인이 이루어질 수 있도록 세션에 idCheck:boolean=false를 추가.
	 * @param req 세션
	 */
	@RequestMapping("/member/joinForm")
	public void joinForm(HttpServletRequest req) {
		//joinForm.jsp를 불러와 화면에 보여준다.
		HttpSession session = req.getSession();
		session.setAttribute("idCheck", false);
		}
	
	/**
	 * 아이디 중복체크 기능
	 * 회원가입 페이지에서 제공되며 관련된 정보들을 member/idCheck로부터 JSON으로 받아옴.
	 * @param req 세션
	 * @param id form에 입력한 id
	 * @return Redirect할 Url 및 아이디 중복여부:boolean
	 */
	@RequestMapping(value = "/member/idCheck")
	public ModelAndView idCheck(HttpServletRequest req, 
		@RequestParam(value = "id") String id) {
		System.out.println("MemController.idCheck() id : " + id);
		HttpSession session = req.getSession(false);
		ModelAndView mav = new ModelAndView("member/idCheck");
		String result = "";
		Member m = service.getMember(id);
		if (m == null) {
			result = "사용가능"; // joinForm.jsp의 div(id=idResult)에 텍스트 채워줄 용
			session.setAttribute("idCheck", true);
		} else {
			result = "사용불가능"; // joinForm.jsp의 div(id=idResult)에 텍스트 채워줄 용
			session.setAttribute("idCheck", false);
		}
		System.out.println(session.getAttribute("idCheck"));
		mav.addObject("result", result);
		return mav;
	}
	
	/**
	 * 회원가입 페이지에서 제공되는 회원가입 기능.
	 * @param m 가입할 계정의 정보
	 * @return Redirect할 Url
	 */
	@PostMapping("/member/join")
	public String join(Member m) {
		//joinForm에서 입력받은 값을 m에 담고 db에 저장한다.
		service.addMember(m);
		return "member/loginForm";
	}
	
	/**
	 * 로그인 페이지(/member/loginForm.jsp)로 이동
	 */
	@RequestMapping("/member/loginForm")
	public void loginForm() {
		//loginForm.jsp를 불러와 화면에 보여준다
	}
	
	/**
	 * 로그인 페이지에서 제공되는 로그인 기능
	 * 로그인 성공시 메인 페이지로, 실패시 로그인 페이지로 이동.
	 * @param m 입력한 아이디, password를 담은 Member 객체
	 * @param req 세션
	 * @return Redirect할 Url 
	 */
	@PostMapping("/member/login")
	public String login(Member m, HttpServletRequest req) {
		//loginForm에서 입력받은 값을 m에 담고 해당하는 아이디에 대한 db 값을 m2에 담는다 
		Member m2 = service.getMember(m.getId());
		// DB로부터 받아온 값이 없고, 받아온 비밀번호가 입력한 비밀번호값과 일치하지않으면 로그인 실패 -> loginForm으로 되돌린다.
		if (m2 == null || !m2.getPassword().equals(m.getPassword())) {
			return "member/loginForm";
		// 로그인 성공시 session을 통해 id 값을 저장한다.
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("id", m2.getId());
			log.info(m2.getId()+",login,");
			return "/member/main";
		}
	}
	
	/**
	 * member/findForm.jsp로 이동하기 위한 메소드
	 */
	@RequestMapping("/member/findForm")
	public void findForm() {
		
	}
	
	/**
	 * 아이디 비번 찾기
	 * @author 김현진
	 * @param email 회원정보를 찾기 위해 입력 받은 email
	 * @param name 회원정보를 찾기 위해 입력 받은 name
	 * @return 회원찾기 폼에서 입력받은 정보로 회원정보를 찾아 findResult.jsp로 전달
	 */
	@PostMapping("/member/find")
	public ModelAndView find(@RequestParam("email")String email, @RequestParam("name")String name) {
		// 폼에서 입력받은 email과 name을 통해 DB에서 Id와 Pwd를 불러와 객체에 해당 정보를 저장한다.
		Member m = service.getIdPwd(email, name);
	
		// 입력 받은 정보와 DB의 정보를 매칭하여 일치하지 않다면 경고 메시지를 findResult.jsp에 보내고, 일치하면 해당 정보를 findResult.jsp에 보낸다.
		ModelAndView mav = new ModelAndView("member/findResult");
		String result="";
		if(m == null) {
			result = "이메일 또는 이름이 등록되지 않았습니다.";
			mav.setViewName("member/failResult");
			mav.addObject("result", result);
			System.out.println(result);
		} else {
			mav.addObject("m", m);
		}
		return mav;
	}
	
	/**
	 * 내정보수정 페이지로 이동
	 * @param req 세션
	 * @return 이동할 Url 및 세션 아이디로 받아온 id값.
	 */
	@RequestMapping(value="/member/editForm")
	public ModelAndView editForm(HttpServletRequest req) {
		HttpSession session = req.getSession();
		//로그인된 아이디 값을 session을 통해 받아온다.
		ModelAndView mav = new ModelAndView("/member/editForm");
		//세션에 저장된 id값을 새로 지정한다.
		String id = (String)session.getAttribute("id");
		Member m = service.getMember(id);
		mav.addObject("m", m);
		return mav;
	}
	
	/**
	 * 내정보수정 페이지에서 제공하는 내정보수정 기능
	 * @param m 수정할 계정 정보
	 * @return 이동할 Url
	 */
	@PostMapping(value="/member/edit")
	public String edit(Member m) {
		service.editMember(m);
		return "/mypage/mypage";
	}
	
	/**
	 * 메인 페이지에서 제공하는 로그아웃 기능
	 * @param req 세션
	 * @return 이동할 Url
	 */
	@RequestMapping(value = "/member/logout")
	public String logout(HttpServletRequest req) {
		//로그인된 아이디 값을 session을 통해 받아온다.
		HttpSession session = req.getSession(false);
		// 세션이 말소되기 전 id를 가져오고
		String id = (String) session.getAttribute("id");
		// 그 id를 이용해 로그를 찍습니다. , 뒤에는 로그 시간이 찍힙니다. 
		log.info(id+",logout,");
		session.removeAttribute("id");
		//id에 대한 세션을 소멸시킨다.
		session.invalidate();
		return "member/loginForm";
	}

	/**
	 * 마이페이지에서 제공하는 회원탈퇴 기능
	 * @param req 세션
	 * @return 이동할 Url
	 */
	@RequestMapping(value = "/member/out")
	public String out(HttpServletRequest req) {
		//로그인된 아이디 값을 session을 통해 받아온다.
		HttpSession session = req.getSession(false);
		//세션에 저장된 id값을 새로 지정한다.
		String id = (String) session.getAttribute("id");
		//새로 지정한 id값을 통해 db에 저장된 id에 대한 정보들을 삭제한다.
		service.delMember(id);
		session.removeAttribute("id");
		session.invalidate();
		return "member/loginForm";
	}
	
	/**
	 * 로고 이미지 받아오기
	 * @return 이미지
	 */
	@RequestMapping("/logo")
	   public ResponseEntity<byte[]> getImg() {
	      String path = "C:\\shopimg\\logo\\logo.png";
	      File f = new File(path);
	      HttpHeaders header = new HttpHeaders();
	      ResponseEntity<byte[]> result = null;
	      try {
	    	  header.add("Content-Type", Files.probeContentType(f.toPath()));
	    	  result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(f), header, HttpStatus.OK);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      return result;
	   }
}