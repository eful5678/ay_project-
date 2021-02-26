package com.example.demo.event;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 이벤트 관련 기능들을 구현한 Service 클래스입니다.
 * @author 김평기
 * @version main 1
 */
@Service
public class EventService {

	@Autowired
	private EventMapper mapper;
	
	/**
	 * 이벤트 리스트 가져오기
	 * num=0인 경우, 이벤트 없음이므로 
	 * select * from 이벤트DB where num > 0 order by num DESC
	 * @return 이벤트 리스트
	 */
	public ArrayList<Event> getEventList() {
		return mapper.selectEventList();
	}

	/**
	 * 이벤트 시퀀스 넘버 가져오기.
	 * select SEQ_EVENT.nextval from dual
	 * @return sequence.nextval
	 */
	public int getNum() {
		return mapper.getNum();
	}

	/**
	 * 이벤트 추가
	 * insert into 이벤트DB values(?, ?, ?)
	 * @param e 추가할 이벤트 정보
	 */
	public void addEvent(Event e) {
		mapper.insertEvent(e);
	}

	/**
	 * 이벤트 번호를 매개로 이벤트 정보 가져오기.
	 * select * from 이벤트DB where num=?
	 * @param num 이벤트 번호
	 * @return 이벤트 정보
	 */
	public Event getEventByNum(int num) {
		return mapper.selectEventByNum(num);
	}

	/**
	 * 이벤트 수정
	 * update 이벤트DB set name=?, sale=? where num=?
	 * @param e 수정할 이벤트 정보
	 */
	public void editEvent(Event e) {
		mapper.updateEvent(e);
	}

	/**
	 * 이벤트 삭제
	 * delete from event where num=?
	 * @param num 삭제할 이벤트 번호
	 */
	public void deleteEvent(int num) {
		mapper.deleteEvent(num);
	}
	
}
