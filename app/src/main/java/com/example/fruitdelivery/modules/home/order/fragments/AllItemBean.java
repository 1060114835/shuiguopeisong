package com.example.fruitdelivery.modules.home.order.fragments;

public class AllItemBean {
    public AllItemBean(String store, String unit, String classFruit,
                       String freight, String saleVolume,
                       String price, String number, String totalPrice,
                       TypeConstant typeConstant) {
        this.store = store;
        this.unit = unit;
        this.classFruit = classFruit;
        this.freight = freight;
        this.saleVolume = saleVolume;
        Price = price;
        this.number = number;
        this.totalPrice = totalPrice;
        this.typeConstant = typeConstant;
    }
    public String store;  //店铺名称
    public String unit;//左边的单价
    public String classFruit;//水果种类
    public String freight;//运费
    public String saleVolume;//销量
    public String Price;//右边的单价
    public String number;//数量
    public String totalPrice;//下面的总价
    public TypeConstant typeConstant; //碎片分类
}