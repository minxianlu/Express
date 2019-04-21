package com.express.project.express.station.mapper;

import com.express.project.express.station.domain.Station;
import java.util.List;	

/**
 * 车站 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface StationMapper 
{
	/**
     * 查询车站信息
     * 
     * @param id 车站ID
     * @return 车站信息
     */
	public Station selectStationById(Integer id);
	
	/**
     * 查询车站列表
     * 
     * @param station 车站信息
     * @return 车站集合
     */
	public List<Station> selectStationList(Station station);
	
	/**
     * 新增车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	public int insertStation(Station station);
	
	/**
     * 修改车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	public int updateStation(Station station);
	
	/**
     * 删除车站
     * 
     * @param id 车站ID
     * @return 结果
     */
	public int deleteStationById(Integer id);
	
	/**
     * 批量删除车站
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteStationByIds(String[] ids);
	
}