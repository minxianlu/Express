package com.express.project.cargo.mapper;

import com.express.project.cargo.domain.FreightRate;
import java.util.List;

/**
 * 运价因子 数据层
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public interface FreightRateMapper 
{
	/**
     * 查询运价因子信息
     * 
     * @param id 运价因子ID
     * @return 运价因子信息
     */
	public FreightRate selectFreightRateById(Integer id);
	
	/**
     * 查询运价因子列表
     * 
     * @param freightRate 运价因子信息
     * @return 运价因子集合
     */
	public List<FreightRate> selectFreightRateList(FreightRate freightRate);
	
	/**
     * 新增运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	public int insertFreightRate(FreightRate freightRate);
	
	/**
     * 修改运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	public int updateFreightRate(FreightRate freightRate);
	
	/**
     * 删除运价因子
     * 
     * @param id 运价因子ID
     * @return 结果
     */
	public int deleteFreightRateById(Integer id);
	
	/**
     * 批量删除运价因子
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteFreightRateByIds(String[] ids);
	
}