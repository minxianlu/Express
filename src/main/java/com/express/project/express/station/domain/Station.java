package com.express.project.express.station.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 车站表 ex_station
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class Station extends BaseEntity
{
	private static final long serialVersionUID = 1L;

	/** 站台名称 */
	private String stationName;



	public void setStationName(String stationName) 
	{
		this.stationName = stationName;
	}

	public String getStationName() 
	{
		return stationName;
	}



}
