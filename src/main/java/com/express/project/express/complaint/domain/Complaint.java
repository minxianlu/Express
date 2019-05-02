package com.express.project.express.complaint.domain;


import com.express.framework.web.domain.BaseEntity;

/**
 * 投诉建议表 ex_complaint
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class Complaint extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 投诉人名 */
	private String userName;
	/** 联系人方式 */
	private String userPhone;
	/** 身份证 */
	private String idCard;
	/** 邮箱 */
	private String email;
	/** 邮编 */
	private Integer postalCode;
	/** 投诉人地址 */
	private String adress;
	/** 投诉主题 */
	private String complaintTheme;
	/** 投诉内容 */
	private String complaintContent;
	/** 附件Id */
	private Integer attId;
	/** 附件编号 */
	private String attNo;
	/** 投诉回复 */
	private String complaintReplay;
	/** 被投诉单位 */
	private String beComplaint;
	/** 小提示 */
	private String tip;
	/** 状态 */
	private Integer status;
	/** 状态 字符型*/
	private String statusStr;

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone()
	{
		return userPhone;
	}
	public void setIdCard(String idCard) 
	{
		this.idCard = idCard;
	}

	public String getIdCard() 
	{
		return idCard;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getEmail() 
	{
		return email;
	}
	public void setPostalCode(Integer postalCode) 
	{
		this.postalCode = postalCode;
	}

	public Integer getPostalCode() 
	{
		return postalCode;
	}
	public void setAdress(String adress) 
	{
		this.adress = adress;
	}

	public String getAdress() 
	{
		return adress;
	}
	public void setComplaintTheme(String complaintTheme) 
	{
		this.complaintTheme = complaintTheme;
	}

	public String getComplaintTheme() 
	{
		return complaintTheme;
	}
	public void setComplaintContent(String complaintContent) 
	{
		this.complaintContent = complaintContent;
	}

	public String getComplaintContent() 
	{
		return complaintContent;
	}
	public void setAttId(Integer attId) 
	{
		this.attId = attId;
	}

	public Integer getAttId() 
	{
		return attId;
	}
	public void setAttNo(String attNo) 
	{
		this.attNo = attNo;
	}

	public String getAttNo() 
	{
		return attNo;
	}
	public void setComplaintReplay(String complaintReplay) 
	{
		this.complaintReplay = complaintReplay;
	}

	public String getComplaintReplay() 
	{
		return complaintReplay;
	}
	public void setBeComplaint(String beComplaint) 
	{
		this.beComplaint = beComplaint;
	}

	public String getBeComplaint() 
	{
		return beComplaint;
	}
	public void setTip(String tip) 
	{
		this.tip = tip;
	}

	public String getTip() 
	{
		return tip;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
}
