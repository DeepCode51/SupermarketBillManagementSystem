package com.test.entity;

import java.util.Date;

/**
 * 当前类的一个“对象”可以封装TEST_TBALE表中一“行”数据
 * @author 超市账单
 *
 */
public class Provider implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer providerId;
	private Integer providerNo;
	private String providerName;
	private String providerDescribe;
	private String providerContacts;
	private String providerTel;
	private String providerLoc;

	
	
	public Integer getProviderId() {
		return providerId;
	}



	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}



	public Integer getProviderNo() {
		return providerNo;
	}



	public void setProviderNo(Integer providerNo) {
		this.providerNo = providerNo;
	}



	public String getProviderName() {
		return providerName;
	}



	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}



	public String getProviderDescribe() {
		return providerDescribe;
	}



	public void setProviderDescribe(String providerDescribe) {
		this.providerDescribe = providerDescribe;
	}



	public String getProviderContacts() {
		return providerContacts;
	}



	public void setProviderContacts(String providerContacts) {
		this.providerContacts = providerContacts;
	}



	public String getProviderTel() {
		return providerTel;
	}



	public void setProviderTel(String providerTel) {
		this.providerTel = providerTel;
	}



	public String getProviderLoc() {
		return providerLoc;
	}



	public void setProviderLoc(String providerLoc) {
		this.providerLoc = providerLoc;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
