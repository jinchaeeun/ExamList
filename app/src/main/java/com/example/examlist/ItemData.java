package com.example.examlist;

//listView 표시될 한 개의 Item
public class ItemData {
    // Member Variable ----------------------------------------------------
    private String      name;
    private String      phone;
    private String      address;
    private int         imgResId;

    //Alt+ Insert 키, Constructor
    // Constructor(생성자) Method
    //생성자 메서드는 클래스랑 이름 같고 큰 특징으로 return 값이 없음! public ItemData
    public ItemData(String name, String phone, String address, int imgResId) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.imgResId = imgResId;
    }
    //멤버변수 하나하나 접근하려면 getter setter있어야함
    //Member Variable 제어 Method ---------------------------------------------
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImgResId() {
        return imgResId;
    }

    public void setImgResId(int imgResId) {
        this.imgResId = imgResId;
    }
}
