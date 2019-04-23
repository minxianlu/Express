package com.express.project.express.freightRate.service;

import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.station.domain.Station;

import java.util.List;

/**
 * 运价 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IFreightRateService 
{
	/**
     * 查询运价信息
     * 
     * @param id 运价ID
     * @return 运价信息
     */
	 FreightRate selectFreightRateById(Integer id);
	
	/**
     * 查询运价列表
     * 
     * @param freightRate 运价信息
     * @return 运价集合
     */
	 List<FreightRate> selectFreightRateList(FreightRate freightRate);
	
	/**
     * 新增运价
     * 
     * @param freightRate 运价信息
     * @return 结果
     */
	 int insertFreightRate(FreightRate freightRate);
	
	/**
     * 修改运价
     * 
     * @param freightRate 运价信息
     * @return 结果
     */
	 int updateFreightRate(FreightRate freightRate);
		
	/**
     * 删除运价信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteFreightRateByIds(String ids);
	/**
	 * 根据车站Ids查询运价
	 *
	 * @param ids 车站ids
	 * @return 结果
	 */
	 List<FreightRate> selectFreightRateByStationIds(String ids) throws Exception;

	/**
	 * 根据车站Id删除运价信息
	 *
	 * @param ids 车站的Id集合
	 * @return 结果
	 */
	 void deleteFreightRateByStationIds(String ids)throws Exception;

	/**
	 * 运价界面中，根据选中的车站的信息，查询不在运价表中的车站信息
	 *
	 * @param freightRate 包含车站信息
	 * @return 结果
	 */
	List<Station> selectStationByFreightRate(FreightRate freightRate) throws Exception;
}
