package com.example.demo.event;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.category.Category;

/**
 * @author kpk
 * 이벤트 관련 기능을 처리하는 컨트롤러
 */
@Controller
public class EventController {

	@Autowired
	private EventService service;

	// 이미지 파일이 저장될 위치
	public static String basePath = "C:\\shopimg\\e";

	/**
	 * 이벤트 List와 List의 배열길이만큼 공차가 1인 등차수열을 리턴한다.
	 * 등차수열을 리턴하는 이유는 배열 길이만큼 버튼을 생성하고, 버튼에 각 이미지로 넘어갈 수 있는 num을 설정하기 위해서이다. 
	 * @return view.name
	 */
	@RequestMapping("/event/list")
	public ModelAndView eventList() {
		// list에 service.getProductAll()을 담는다
		ArrayList<Event> list = (ArrayList<Event>) service.getEventList();

		// mav에 product/list를 담는다
		ModelAndView mav = new ModelAndView("event/eventList");

		// 리스트 갯수만큼 반복
		for (int i = 0; i < list.size(); i++) {

			// path에 basePath에 담긴 이미지와 list에 담긴 번호를 저장
			String path = basePath + list.get(i).getNum() + "\\";

			// File imgDir에 Filepath를 지정
			File imgDir = new File(path);

			// files에 imgDir에 있는 파일 경로들을 저장
			String[] files = imgDir.list();
			
			// mav에 files에 저장된 값을 저장한다
			if (imgDir.exists()) {
				// 이미지 경로를 저장한다.
				list.get(i).setImgPath(files[0]);
				System.out.println(list.get(i).toString());
			}
		}

		// 공차가 1인 등차수열 생성.
		ArrayList<Integer> lengths = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			lengths.add(i);
		}

		// mav에 list를 담는다.
		mav.addObject("list", list);
		// mav에 lengths(=등차수열)을 넣는다.
		mav.addObject("lengths", lengths);
		System.out.println("lengths : " + lengths.toString() + ", " + lengths.size());
		return mav;
	}

	/**
	 * url에 /event/write가 들어왔을 경우, 세션의 유무에 따라 다른 view로 이동시킨다.
	 * @param req = session.id를 가져오기 위함.
	 * @return viewName
	 */
	@GetMapping("/event/write")
	public String writeEventForm(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session == null) {
			return "/admin/loginForm";
		} else {
			return "/event/writeForm";
		}

	}

	/**
	 * 
	 * @param e : Mybatis로 인해 자동매핑, 단 num은 고정적으로 0이 들어온다.
	 * @return
	 */
	@PostMapping("/event/write")
	public String writeEvent(Event e) {
		// Event e에 0이 들어오므로 service.getNum을 활용해
		int num = service.getNum();
		e.setNum(num);
		// 목표 디렉토리에 파일 저장
		saveEventImg(e.getNum(), e.getFile());
		// 이벤트 추가
		service.addEvent(e);
		return "redirect:/admin/admin";
	}

	/**
	 * basePath + num 에 새로운 파일을 추가하는 메소드입니다.
	 * 이때, 해당 디렉토리의 다른 파일은 쓸모가 없으니 새로운 파일을 추가하기 전에 일괄삭제합니다.
	 * 
	 * @param num : 파일 디렉토리를 결정하는 넘버 ('shopimg/e' + num) 식으로
	 * @param file : 이미지 파일
	 */
	public void saveEventImg(int num, MultipartFile file) { // 이미지 저장하기
		String fileName = file.getOriginalFilename();
		// 파일이름이 없거나 공백이 아니면
		if (fileName != null && !fileName.equals("")) {
			File dir = new File(basePath + num);
			// 디렉토리가 없으면 만들어줌.
			if (!dir.exists()) {
				dir.mkdirs();
			} else { // 있으면 디렉토리 안 모든 파일을 제거함.
				String[] files = dir.list();
				for (int j = 0; j < files.length; j++) {
					File del = new File(basePath + num + "\\" + files[j]);
					System.out.println("TARGET : " + files[j].toString());
					del.delete();
				}
			}

			// 파일 생성 후
			File f = new File(basePath + num + "\\" + fileName);
			try {
				// 받아온 파일을 f로 옮김.
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 해당 디렉토리의 파일을 가져오는 역할
	 * @param fname : 파일 이름
	 * @param num : 디렉토리 결정 num
	 * @return
	 */
	@RequestMapping("/event/img")
	public ResponseEntity<byte[]> getEventImg(String fname, int num) {
		String path = basePath + num + "\\" + fname;
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

	
	@GetMapping("/event/edit")
	public ModelAndView eventDetail(@RequestParam("num") int num, @RequestParam("file") String file,
			HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		ModelAndView mav = new ModelAndView("event/editForm");

		Event e = service.getEventByNum(num);

		e.setImgPath(file);
		mav.addObject("e", e);
		
		if (session == null) {
			mav.setViewName("admin/adminLoginForm");
		}
		return mav;

	}

	@PostMapping("/event/edit")
	public String editEvent(Event e) {

		saveEventImg(e.getNum(), e.getFile());
		service.editEvent(e);
		System.out.println("TARGET : " + e.toString());
		return "redirect:/admin/admin";
	}

	/**
	 * 이벤트 삭제
	 * @param num
	 * @return
	 */
	@RequestMapping("/event/del")
	public String deleteEvent(@RequestParam("num") int num) {
		service.deleteEvent(num);
		return "redirect:/admin/admin";
	}
	
	/**
	 * JSON으로 EVENT 값 받아올 때 사용.
	 * @return 
	 */
	@RequestMapping("/event/getEvent")
	public ModelAndView getEvent() {
		System.out.println("EventController.getEvent()");
		ModelAndView mav = new ModelAndView("event/getEvent");
		ArrayList<Event> list = service.getEventList();
		System.out.println("TAG : " + list.size());
		mav.addObject("list", list);
		return mav;
	}

}
