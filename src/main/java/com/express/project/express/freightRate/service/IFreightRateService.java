package com.express.project.express.freightRate.service;

import com.express.project.express.freightRate.domain.FreightRate;
import java.util.List;

/**
 * 运价因子 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IFreightRateService 
{
	/**
     * 查询运价因子信息
     * 
     * @param id 运价因子ID
     * @return 运价因子信息
     */
	 FreightRate selectFreightRateById(Integer id);
	
	/**
     * 查询运价因子列表
     * 
     * @param freightRate 运价因子信息
     * @return 运价因子集合
     */
	 List<FreightRate> selectFreightRateList(FreightRate freightRate);
	
	/**
     * 新增运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	 int insertFreightRate(FreightRate freightRate);
	
	/**
     * 修改运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	 int updateFreightRate(FreightRate freightRate);
		
	/**
     * 删除运价因子信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteFreightRateByIds(String ids);
	/**
	 * 根据车站Ids查询运价因子
	 *
	 * @param ids 车站ids
	 * @return 结果
	 */
	 List<FreightRate> selectFreightRateByStationIds(String ids) throws Exception;
	
}
