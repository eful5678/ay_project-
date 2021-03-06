package com.example.demo.review;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper mapper; 
	
	@Transactional
	public void addReview(Review r) {
		mapper.insert(r);
	}
	
	@Transactional
	public void addReviewID(Review r) {
		mapper.insertID(r);
	}
	
	public ArrayList<Review> getAll(){
		return mapper.selectAll();
	}
	   
	public Review getDetail(int num) {
		return mapper.select(num);
	}
	   
	public ArrayList<Review> getDetailByDate(int num) {
		return mapper.selectByDate(num);
	}
	      
	@Transactional
	public void editReview(Review r) {
		mapper.update(r);
	}
	   
	@Transactional
	public void delReview(int num) {
		mapper.delete(num);
	}

	public ArrayList<Review> getByPnum(int p_num) {
		// TODO Auto-generated method stub
		return mapper.selectByPnum(p_num);
	}
	
	public ArrayList<Review> getDetailByLike(int p_num){
		return mapper.selectByLike(p_num);
	}
	
	public ArrayList<Review> getDetailByStar(HashMap<String, Object> map){
		return mapper.selectByStar(map);
	}
	
	public ArrayList<ReviewLike> getLikeByid(int num) {
		return mapper.selectLikeById(num);
	}
	
	public ArrayList<Review> getDetailByWord(HashMap<String, Object> map){
		return mapper.selectByWord(map);
	}
	
	@Transactional
	public int getNum() {
		return mapper.getNum();
	}
	
	@Transactional
	public void IncRating(Review r) {
		mapper.increaseRating(r);
	}
	
	@Transactional
	public void DecRating(Review r) {
		mapper.decreaseRating(r);
	}
}
