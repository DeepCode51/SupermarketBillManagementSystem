package com.test.entity;

import java.time.LocalDate;
import java.sql.Date;

/**
 * 当前类的一个对象可以封装user_message表中的一行数据
 * 
 * @author 超市账单
 *
 */
public class Bill implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer billId;
	private Integer billNo;
	private String billProname;
	private Integer billPronum;
	private double billPrice;
	private boolean billPayment;
	private String billProdescribe;
	private Date billDate;
	private String providerId;
	private String providerName;//临时变量
	
	public Integer getBillId() {
		return billId;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}



	public Integer getBillNo() {
		return billNo;
	}



	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}



	public String getBillProname() {
		return billProname;
	}



	public void setBillProname(String billProname) {
		this.billProname = billProname;
	}



	public Integer getBillPronum() {
		return billPronum;
	}



	public void setBillPronum(Integer billPronum) {
		this.billPronum = billPronum;
	}



	public double getBillPrice() {
		return billPrice;
	}



	public void setBillPrice(double billPrice) {
		this.billPrice = billPrice;
	}

	public boolean getBillPayment() {
		return billPayment;
	}

	public void setBillPayment(boolean billPayment) {
		this.billPayment = billPayment;
	}

	public String getBillProdescribe() {
		return billProdescribe;
	}



	public void setBillProdescribe(String billProdescribe) {
		this.billProdescribe = billProdescribe;
	}



	public Date getBillDate() {
		return billDate;
	}



	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public String getProviderName() {
		return providerName;
	}



	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}


	public String getProviderId() {
		return providerId;
	}



	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
