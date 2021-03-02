package com.example.demo.product;

import org.springframework.web.multipart.MultipartFile;

/**
 * 상품(=Product)에 대한 DTO입니다.
 * @author 김평기
 * @version main 1
 */
public class Product {

	/**
	 * 상품번호값입니다. [PK]
	 */
	private int num;// 번호

	/**
	 * 상품명값입니다. [NOT NULL]
	 */
	private String name;// 이름

	/**
	 * 제조사값입니다. [NOT NULL]
	 */
	private String maker;// 메이커

	/**
	 * 가격값입니다. [NOT NULL]
	 */
	private int price;// 가격

	/**
	 * 원산지값입니다. [NOT NULL]
	 */
	private String origin;// 원산지

	/**
	 * 재료값입니다. [NOT NULL]
	 */
	private String material;// 재료

	/**
	 * 재고수량값입니다. [NOT NULL]
	 */
	private int quantity;// 재고수량

	/**
	 * 이미지 경로입니다. [NOT NULL] 
	 * DB에서 소멸시켜도 되는 값입니다.
	 */
	private String imgPath;//// 사진경로

	/**
	 * 카테고리1값입니다. [FK]
	 */
	private int category1;// 카테고리1

	/**
	 * 카테고리2값입니다. [FK]
	 */
	private int category2;// 카테고리2

	/**
	 * 이벤트번호입니다. [FK]
	 */
	private int event_num;// 이벤트번호

	/**
	 * 파일 1값입니다. [NOT IN DB]
	 */
	private MultipartFile file1;

	/**
	 * 파일 2값입니다. [NOT IN DB]
	 */
	private MultipartFile file2;

	/**
	 * 파일 3값입니다. [NOT IN DB]
	 */
	private MultipartFile file3;

	/**
	 * 기본 생성자입니다.
	 */
	public Product() {
		super();
	}

	/**
	 * DB에 존재하는 모든 컬럼을 매개변수로 받는 생성자입니다.
	 * @param num
	 * @param name
	 * @param maker
	 * @param price
	 * @param origin
	 * @param material
	 * @param quantity
	 * @param imgPath
	 */
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

	/**
	 * 모든 필드를 매개변수로 갖는 생성자입니다.
	 * @param num
	 * @param name
	 * @param maker
	 * @param price
	 * @param origin
	 * @param material
	 * @param quantity
	 * @param imgPath
	 * @param category1
	 * @param category2
	 * @param category3_id
	 * @param event_num
	 * @param file1
	 * @param file2
	 * @param file3
	 */
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

	/**
	 * 
	 * @return
	 */
	public int getNum() {
		return num;
	}

	/**
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
	public String getMaker() {
		return maker;
	}

	/**
	 * 
	 * @param maker
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * 
	 * @return
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * 
	 * @return
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * 
	 * @param origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * 
	 * @return
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * 
	 * @param material
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * 
	 * @param imgPath
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	/**
	 * 
	 * @return
	 */
	public int getCategory1() {
		return category1;
	}

	/**
	 * 
	 * @param category1
	 */
	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	/**
	 * 
	 * @return
	 */
	public int getCategory2() {
		return category2;
	}

	/**
	 * 
	 * @param category2
	 */
	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	/**
	 * 
	 * @return
	 */
	public int getEvent_num() {
		return event_num;
	}

	/**
	 * 
	 * @param event_num
	 */
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}

	/**
	 * 
	 * @return
	 */
	public MultipartFile getFile1() {
		return file1;
	}

	/**
	 * 
	 * @param file1
	 */
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	/**
	 * 
	 * @return
	 */
	public MultipartFile getFile2() {
		return file2;
	}

	/**
	 * 
	 * @param file2
	 */
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	/**
	 * 
	 * @return
	 */
	public MultipartFile getFile3() {
		return file3;
	}

	/**
	 * 
	 * @param file3
	 */
	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", maker=" + maker + ", price=" + price + ", origin=" + origin
				+ ", material=" + material + ", quantity=" + quantity + ", imgPath=" + imgPath + ", category1="
				+ category1 + ", category2=" + category2 + ", event_num=" + event_num + ", file1=" + file1 + ", file2="
				+ file2 + ", file3=" + file3 + "]";
	}

	/**
	 * 로그 편의용
	 * @deprecated logback.xml 설정으로 사라져도 되는 값입니다.
	 * @return
	 */
	public String category() {
		return "num,name,maker,price,origin," + "material,quantity,imgPath,category1_id,"
				+ "category2_id,event_num,file1,file2,file3,methodName\n";
	}

	/**
	 * 로그 편의용
	 * @return
	 */
	public String content() {
		return num + "," + name + "," + maker + "," + price + "," + origin + "," + material + "," + quantity + ","
				+ imgPath + "," + category1 + "," + category2 + "," + event_num + "," + file1.getName() + ","
				+ file2.getName() + "," + file3.getName();
	}

}