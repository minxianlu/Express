package com.express.project.system.area.domain;


import com.express.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 区县表 areas
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class Areas extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 区县编码 */
	private String areaid;
	/** 区县名称 */
	private String area;
	/** 所属城市编码 */
	private String cityid;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setAreaid(String areaid) 
	{
		this.areaid = areaid;
	}

	public String getAreaid() 
	{
		return areaid;
	}
	public void setArea(String area) 
	{
		this.area = area;
	}

	public String getArea() 
	{
		return area;
	}
	public void setCityid(String cityid) 
	{
		this.cityid = cityid;
	}

	public String getCityid() 
	{
		return cityid;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("areaid", getAreaid())
            .append("area", getArea())
            .append("cityid", getCityid())
            .toString();
    }
}
