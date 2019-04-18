package com.express.project.system.area.domain;


import com.express.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 城市表 cities
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class Cities extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	private Integer id;
	/** 城市编码 */
	private String cityid;
	/** 城市名称 */
	private String city;
	/** 所属省份编码 */
	private String provinceid;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCityid(String cityid) 
	{
		this.cityid = cityid;
	}

	public String getCityid() 
	{
		return cityid;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getCity() 
	{
		return city;
	}
	public void setProvinceid(String provinceid) 
	{
		this.provinceid = provinceid;
	}

	public String getProvinceid() 
	{
		return provinceid;
	}

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("cityid", getCityid())
            .append("city", getCity())
            .append("provinceid", getProvinceid())
            .toString();
    }
}
