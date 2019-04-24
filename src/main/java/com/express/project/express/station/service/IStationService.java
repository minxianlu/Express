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
	 Station selectStationById(Integer id)throws Exception;
	
	/**
     * 查询车站列表
     * 
     * @param station 车站信息
     * @return 车站集合
     */
	 List<Station> selectStationList(Station station)throws Exception;
	
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
	 * @param stationIdList 需要查询的数据ID
	 * @return 结果
	 */
	 List<Station> selectStationByIds(List<Integer> stationIdList)throws Exception;

	/**
	 * 查询不在集合中的车站
	 *
	 * @param list 条件数据集合
	 * @return 结果
	 */
	List<Station> selectStationNotInIds(List<Integer> list)throws Exception;


}
