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
	 int insertStation(Station station);

	/**
     * 修改车站
     *
     * @param station 车站信息
     * @return 结果
     */
	 int updateStation(Station station);

	/**
     * 删除车站
     *
     * @param id 车站ID
     * @return 结果
     */
	 int deleteStationById(Integer id);

	/**
     * 批量删除车站
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteStationByIds(String[] ids);
	/**
	 * 批量查询车站
	 *
	 * @param ids 需要查询的数据ID
	 * @return 结果
	 */
	 List<Station> selectStationByIds(String[] ids);
	/**
	 * 查询不在集合中的车站
	 *
	 * @param list 条件数据集合
	 * @return 结果
	 */
	List<Station> selectStationNotInIds(List<Integer> list);
}