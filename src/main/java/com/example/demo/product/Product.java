package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

public class Product {

	private int num;// 번호
	private String name;// 이름
	private String maker;// 메이커
	private int price;// 가격
	private String origin;// 원산지
	private String material;// 재료
	private int quantity;// 수량
	private String imgPath;//// 사진경로

	private int category1;// 카테고리1
	private int category2;// 카테고리2
	private int event_num;// 이벤트페이지

	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;

	public Product() {
		super();
	}

	public Product(int num, String name, String maker, int price, String origin, String material, int quantity,
			String imgPath) {
		super();
		this.num = num;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.origin = origin;
		this.material = material;
		this.quantity = quantity;
		this.imgPath = imgPath;
	}

	public Product(int num, String name, String maker, int price, String origin, String material, int quantity,
			String imgPath, int category1, int category2, int category3_id, int event_num, MultipartFile file1,
			MultipartFile file2, MultipartFile file3) {
		super();
		this.num = num;
		this.name = name;
		this.maker = maker;
		this.price = price;
		this.origin = origin;
		this.material = material;
		this.quantity = quantity;
		this.imgPath = imgPath;
		this.category1 = category1;
		this.category2 = category2;
		this.event_num = event_num;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getEvent_num() {
		return event_num;
	}

	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", maker=" + maker + ", price=" + price + ", origin=" + origin
				+ ", material=" + material + ", quantity=" + quantity + ", imgPath=" + imgPath + ", category1="
				+ category1 + ", category2=" + category2 + ", event_num=" + event_num + ", file1=" + file1 + ", file2="
				+ file2 + ", file3=" + file3 + "]";
	}

	public String category() {
		return "num,name,maker,price,origin," + "material,quantity,imgPath,category1_id,"
				+ "category2_id,event_num,file1,file2,file3,methodName\n";
	}

	public String content() {
		return num + "," + name + "," + maker + "," + price + "," + origin + "," + material + ","
				+ category1 + "," + category2 + "," + event_num;
	}

}