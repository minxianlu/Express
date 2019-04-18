package com.express.project.system.area.domain;


import com.express.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 省份表 provinces
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class Provinces extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id */
	private Integer id;
	/** 省份编码 */
	private Integer provinceid;
	/** 省份名称 */
	private String province;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setProvinceid(Integer provinceid) 
	{
		this.provinceid = provinceid;
	}

	public Integer getProvinceid() 
	{
		return provinceid;
	}
	public void setProvince(String province) 
	{
		this.province = province;
	}

	public String getProvince() 
	{
		return province;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("provinceid", getProvinceid())
            .append("province", getProvince())
            .toString();
    }
}
