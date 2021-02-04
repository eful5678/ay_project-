package com.example.demo.review;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {

	void insert(Review r);
	   
	ArrayList<Review> selectAll();
	   
	void update(Review r);
	   
	void delete(int num);
}
