package com.express.project.cargo.mapper;

import com.express.project.cargo.domain.CargoDress;

import java.util.List;

/**
 * 货物地址 数据层
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public interface CargoDressMapper 
{
	/**
     * 查询货物地址信息
     * 
     * @param id 货物地址ID
     * @return 货物地址信息
     */
	public CargoDress selectCargoDressById(Integer id);
	
	/**
     * 查询货物地址列表
     * 
     * @param cargoDress 货物地址信息
     * @return 货物地址集合
     */
	public List<CargoDress> selectCargoDressList(CargoDress cargoDress);
	
	/**
     * 新增货物地址
     * 
     * @param cargoDress 货物地址信息
     * @return 结果
     */
	public int insertCargoDress(CargoDress cargoDress);
	
	/**
     * 修改货物地址
     * 
     * @param cargoDress 货物地址信息
     * @return 结果
     */
	public int updateCargoDress(CargoDress cargoDress);
	
	/**
     * 删除货物地址
     * 
     * @param id 货物地址ID
     * @return 结果
     */
	public int deleteCargoDressById(Integer id);
	
	/**
     * 批量删除货物地址
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCargoDressByIds(String[] ids);
	
}