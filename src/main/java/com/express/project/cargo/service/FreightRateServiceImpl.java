package com.express.project.cargo.service;


import com.express.project.cargo.domain.FreightRate;
import com.express.project.cargo.mapper.FreightRateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.text.Convert;

import java.util.List;

/**
 * 运价因子 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Service
public class FreightRateServiceImpl implements IFreightRateService 
{
	@Autowired
	private FreightRateMapper freightRateMapper;

	/**
     * 查询运价因子信息
     * 
     * @param id 运价因子ID
     * @return 运价因子信息
     */
    @Override
	public FreightRate selectFreightRateById(Integer id)
	{
	    return freightRateMapper.selectFreightRateById(id);
	}
	
	/**
     * 查询运价因子列表
     * 
     * @param freightRate 运价因子信息
     * @return 运价因子集合
     */
	@Override
	public List<FreightRate> selectFreightRateList(FreightRate freightRate)
	{
	    return freightRateMapper.selectFreightRateList(freightRate);
	}
	
    /**
     * 新增运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	@Override
	public int insertFreightRate(FreightRate freightRate)
	{
	    return freightRateMapper.insertFreightRate(freightRate);
	}
	
	/**
     * 修改运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	@Override
	public int updateFreightRate(FreightRate freightRate)
	{
	    return freightRateMapper.updateFreightRate(freightRate);
	}

	/**
     * 删除运价因子对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFreightRateByIds(String ids)
	{
		return freightRateMapper.deleteFreightRateByIds(Convert.toStrArray(ids));
	}
	
}
