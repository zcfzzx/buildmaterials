package com.entity.vo;

import com.entity.OrdersEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-03-14 09:22:59
 */
public class OrdersVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 商品表名
	 */
	
	private String tablename;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
		
	/**
	 * 商品id
	 */
	
	private Long goodid;
		
	/**
	 * 商品名称
	 */
	
	private String goodname;
		
	/**
	 * 商品图片
	 */
	
	private String picture;
		
	/**
	 * 购买数量
	 */
	
	private Integer buynumber;
		
	/**
	 * 价格
	 */
	
	private Float price;
		
	/**
	 * 折扣价格
	 */
	
	private Float discountprice;
		
	/**
	 * 总价格
	 */
	
	private Float total;
		
	/**
	 * 折扣总价格
	 */
	
	private Float discounttotal;
		
	/**
	 * 支付类型
	 */
	
	private Integer type;
		
	/**
	 * 状态
	 */
	
	private String status;
		
	/**
	 * 地址
	 */
	
	private String address;
		
	/**
	 * 电话
	 */
	
	private String tel;
		
	/**
	 * 收货人
	 */
	
	private String consignee;
		
	/**
	 * 备注
	 */
	
	private String remark;
		
	/**
	 * 物流
	 */
	
	private String logistics;
		
	/**
	 * 商户名称
	 */
	
	private String shangjiazhanghao;
		
	/**
	 * 商品类型
	 */
	
	private String goodtype;

	/**
	 * 销售总数
	 */
	private int count;

	private float month1;

	private float month2;

	private float month3;

	private float month4;

	private float month5;

	private float month6;

	private float month7;

	private float month8;

	private float month9;

	private float month10;

	private float month11;

	private float month12;

	private int num1;

	private int num2;

	private int num3;

	private int num4;

	private int num5;

	private int num6;

	private int num7;

	private int num8;

	private int num9;

	private int num10;

	private int num11;

	private int num12;

	public int getNum1() {
		return num1;
	}

	public void setNum1(int num1) {
		this.num1 = num1;
	}

	public int getNum2() {
		return num2;
	}

	public void setNum2(int num2) {
		this.num2 = num2;
	}

	public int getNum3() {
		return num3;
	}

	public void setNum3(int num3) {
		this.num3 = num3;
	}

	public int getNum4() {
		return num4;
	}

	public void setNum4(int num4) {
		this.num4 = num4;
	}

	public int getNum5() {
		return num5;
	}

	public void setNum5(int num5) {
		this.num5 = num5;
	}

	public int getNum6() {
		return num6;
	}

	public void setNum6(int num6) {
		this.num6 = num6;
	}

	public int getNum7() {
		return num7;
	}

	public void setNum7(int num7) {
		this.num7 = num7;
	}

	public int getNum8() {
		return num8;
	}

	public void setNum8(int num8) {
		this.num8 = num8;
	}

	public int getNum9() {
		return num9;
	}

	public void setNum9(int num9) {
		this.num9 = num9;
	}

	public int getNum10() {
		return num10;
	}

	public void setNum10(int num10) {
		this.num10 = num10;
	}

	public int getNum11() {
		return num11;
	}

	public void setNum11(int num11) {
		this.num11 = num11;
	}

	public int getNum12() {
		return num12;
	}

	public void setNum12(int num12) {
		this.num12 = num12;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getMonth1() {
		return month1;
	}

	public void setMonth1(float month1) {
		this.month1 = month1;
	}

	public float getMonth2() {
		return month2;
	}

	public void setMonth2(float month2) {
		this.month2 = month2;
	}

	public float getMonth3() {
		return month3;
	}

	public void setMonth3(float month3) {
		this.month3 = month3;
	}

	public float getMonth4() {
		return month4;
	}

	public void setMonth4(float month4) {
		this.month4 = month4;
	}

	public float getMonth5() {
		return month5;
	}

	public void setMonth5(float month5) {
		this.month5 = month5;
	}

	public float getMonth6() {
		return month6;
	}

	public void setMonth6(float month6) {
		this.month6 = month6;
	}

	public float getMonth7() {
		return month7;
	}

	public void setMonth7(float month7) {
		this.month7 = month7;
	}

	public float getMonth8() {
		return month8;
	}

	public void setMonth8(float month8) {
		this.month8 = month8;
	}

	public float getMonth9() {
		return month9;
	}

	public void setMonth9(float month9) {
		this.month9 = month9;
	}

	public float getMonth10() {
		return month10;
	}

	public void setMonth10(float month10) {
		this.month10 = month10;
	}

	public float getMonth11() {
		return month11;
	}

	public void setMonth11(float month11) {
		this.month11 = month11;
	}

	public float getMonth12() {
		return month12;
	}

	public void setMonth12(float month12) {
		this.month12 = month12;
	}

	/**
	 * 设置：商品表名
	 */
	 
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	
	/**
	 * 获取：商品表名
	 */
	public String getTablename() {
		return tablename;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
				
	
	/**
	 * 设置：商品id
	 */
	 
	public void setGoodid(Long goodid) {
		this.goodid = goodid;
	}
	
	/**
	 * 获取：商品id
	 */
	public Long getGoodid() {
		return goodid;
	}
				
	
	/**
	 * 设置：商品名称
	 */
	 
	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}
	
	/**
	 * 获取：商品名称
	 */
	public String getGoodname() {
		return goodname;
	}
				
	
	/**
	 * 设置：商品图片
	 */
	 
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	/**
	 * 获取：商品图片
	 */
	public String getPicture() {
		return picture;
	}
				
	
	/**
	 * 设置：购买数量
	 */
	 
	public void setBuynumber(Integer buynumber) {
		this.buynumber = buynumber;
	}
	
	/**
	 * 获取：购买数量
	 */
	public Integer getBuynumber() {
		return buynumber;
	}
				
	
	/**
	 * 设置：价格
	 */
	 
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * 获取：价格
	 */
	public Float getPrice() {
		return price;
	}
				
	
	/**
	 * 设置：折扣价格
	 */
	 
	public void setDiscountprice(Float discountprice) {
		this.discountprice = discountprice;
	}
	
	/**
	 * 获取：折扣价格
	 */
	public Float getDiscountprice() {
		return discountprice;
	}
				
	
	/**
	 * 设置：总价格
	 */
	 
	public void setTotal(Float total) {
		this.total = total;
	}
	
	/**
	 * 获取：总价格
	 */
	public Float getTotal() {
		return total;
	}
				
	
	/**
	 * 设置：折扣总价格
	 */
	 
	public void setDiscounttotal(Float discounttotal) {
		this.discounttotal = discounttotal;
	}
	
	/**
	 * 获取：折扣总价格
	 */
	public Float getDiscounttotal() {
		return discounttotal;
	}
				
	
	/**
	 * 设置：支付类型
	 */
	 
	public void setType(Integer type) {
		this.type = type;
	}
	
	/**
	 * 获取：支付类型
	 */
	public Integer getType() {
		return type;
	}
				
	
	/**
	 * 设置：状态
	 */
	 
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
				
	
	/**
	 * 设置：地址
	 */
	 
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
				
	
	/**
	 * 设置：电话
	 */
	 
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
				
	
	/**
	 * 设置：收货人
	 */
	 
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * 获取：收货人
	 */
	public String getConsignee() {
		return consignee;
	}
				
	
	/**
	 * 设置：备注
	 */
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
				
	
	/**
	 * 设置：物流
	 */
	 
	public void setLogistics(String logistics) {
		this.logistics = logistics;
	}
	
	/**
	 * 获取：物流
	 */
	public String getLogistics() {
		return logistics;
	}
				
	
	/**
	 * 设置：商户名称
	 */
	 
	public void setShangjiazhanghao(String shangjiazhanghao) {
		this.shangjiazhanghao = shangjiazhanghao;
	}
	
	/**
	 * 获取：商户名称
	 */
	public String getShangjiazhanghao() {
		return shangjiazhanghao;
	}
				
	
	/**
	 * 设置：商品类型
	 */
	 
	public void setGoodtype(String goodtype) {
		this.goodtype = goodtype;
	}
	
	/**
	 * 获取：商品类型
	 */
	public String getGoodtype() {
		return goodtype;
	}
			
}
