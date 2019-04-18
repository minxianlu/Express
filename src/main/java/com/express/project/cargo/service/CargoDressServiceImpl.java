package com.express.project.cargo.service;

import com.express.project.cargo.domain.CargoDress;
import com.express.project.cargo.mapper.CargoDressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.text.Convert;

import java.util.List;

/**
 * 货物地址 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Service
public class CargoDressServiceImpl implements ICargoDressService 
{
	@Autowired
	private CargoDressMapper cargoDressMapper;

	/**
     * 查询货物地址信息
     * 
     * @param id 货物地址ID
     * @return 货物地址信息
     */
    @Override
	public CargoDress selectCargoDressById(Integer id)
	{
	    return cargoDressMapper.selectCargoDressById(id);
	}
	
	/**
     * 查询货物地址列表
     * 
     * @param cargoDress 货物地址信息
     * @return 货物地址集合
     */
	@Override
	public List<CargoDress> selectCargoDressList(CargoDress cargoDress)
	{
	    return cargoDressMapper.selectCargoDressList(cargoDress);
	}
	
    /**
     * 新增货物地址
     * 
     * @param cargoDress 货物地址信息
     * @return 结果
     */
	@Override
	public int insertCargoDress(CargoDress cargoDress)
	{
	    return cargoDressMapper.insertCargoDress(cargoDress);
	}
	
	/**
     * 修改货物地址
     * 
     * @param cargoDress 货物地址信息
     * @return 结果
     */
	@Override
	public int updateCargoDress(CargoDress cargoDress)
	{
	    return cargoDressMapper.updateCargoDress(cargoDress);
	}

	/**
     * 删除货物地址对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCargoDressByIds(String ids)
	{
		return cargoDressMapper.deleteCargoDressByIds(Convert.toStrArray(ids));
	}
	
}
