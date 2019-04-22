package com.express.project.express.station.service;

import com.express.project.express.station.domain.Station;
import java.util.List;

/**
 * 车站 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IStationService 
{
	/**
     * 查询车站信息
     * 
     * @param id 车站ID
     * @return 车站信息
     */
	 Station selectStationById(Integer id);
	
	/**
     * 查询车站列表
     * 
     * @param station 车站信息
     * @return 车站集合
     */
	 List<Station> selectStationList(Station station);
	
	/**
     * 新增车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	 void insertStation(Station station)throws Exception;
	
	/**
     * 修改车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	 void updateStation(Station station)throws Exception;
		
	/**
     * 删除车站信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 void deleteStationByIds(String ids)throws Exception;
	/**
	 * 批量查询车站
	 *
	 * @param ids 需要查询的数据ID
	 * @return 结果
	 */
	public List<Station> selectStationByIds(String[] ids)throws Exception;
}
