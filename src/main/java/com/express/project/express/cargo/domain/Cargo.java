package com.express.project.express.cargo.domain;


import com.express.framework.web.domain.BaseEntity;

/**
 * 货物表 ex_cargo
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class Cargo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 货物编码 */
	private String cargoNo;
	/** 货物名称 */
	private String cargoName;
	/** 货物类型 */
	private Integer cargoTyp;
	/** 包装 */
	private String pack;
	/** 数量 */
	private Integer num;
	/** 总重 */
	private Double weight;
	/** 保价 */
	private Double insurance;
	/** 计费重量 */
	private Double billingWeight;
	/** 单个最大重量 */
	private Double singleMaxWeight;
	/** 长 */
	private Double length;
	/** 宽 */
	private Double width;
	/** 长 */
	private Double height;
	/** 体积 */
	private Double volume;
	/** 状态 */
	private Integer status;

	public void setCargoNo(String cargoNo)
	{
		this.cargoNo = cargoNo;
	}

	public String getCargoNo() 
	{
		return cargoNo;
	}
	public void setCargoName(String cargoName) 
	{
		this.cargoName = cargoName;
	}

	public String getCargoName() 
	{
		return cargoName;
	}
	public void setCargoTyp(Integer cargoTyp) 
	{
		this.cargoTyp = cargoTyp;
	}

	public Integer getCargoTyp() 
	{
		return cargoTyp;
	}
	public void setPack(String pack) 
	{
		this.pack = pack;
	}

	public String getPack() 
	{
		return pack;
	}
	public void setNum(Integer num) 
	{
		this.num = num;
	}

	public Integer getNum() 
	{
		return num;
	}
	public void setWeight(Double weight) 
	{
		this.weight = weight;
	}

	public Double getWeight() 
	{
		return weight;
	}
	public void setInsurance(Double insurance) 
	{
		this.insurance = insurance;
	}

	public Double getInsurance() 
	{
		return insurance;
	}
	public void setBillingWeight(Double billingWeight) 
	{
		this.billingWeight = billingWeight;
	}

	public Double getBillingWeight() 
	{
		return billingWeight;
	}
	public void setSingleMaxWeight(Double singleMaxWeight) 
	{
		this.singleMaxWeight = singleMaxWeight;
	}

	public Double getSingleMaxWeight() 
	{
		return singleMaxWeight;
	}
	public void setLength(Double length) 
	{
		this.length = length;
	}

	public Double getLength() 
	{
		return length;
	}
	public void setWidth(Double width) 
	{
		this.width = width;
	}

	public Double getWidth() 
	{
		return width;
	}
	public void setHeight(Double height) 
	{
		this.height = height;
	}

	public Double getHeight() 
	{
		return height;
	}
	public void setVolume(Double volume) 
	{
		this.volume = volume;
	}

	public Double getVolume() 
	{
		return volume;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
