package com.express.project.express.cargo.mapper;

import com.express.project.express.cargo.domain.Cargo;
import java.util.List;	

/**
 * 货物 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface CargoMapper 
{
	/**
     * 查询货物信息
     * 
     * @param id 货物ID
     * @return 货物信息
     */
	public Cargo selectCargoById(Integer id);
	
	/**
     * 查询货物列表
     * 
     * @param cargo 货物信息
     * @return 货物集合
     */
	public List<Cargo> selectCargoList(Cargo cargo);
	
	/**
     * 新增货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	public int insertCargo(Cargo cargo);
	
	/**
     * 修改货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	public int updateCargo(Cargo cargo);
	
	/**
     * 删除货物
     * 
     * @param id 货物ID
     * @return 结果
     */
	public int deleteCargoById(Integer id);
	
	/**
     * 批量删除货物
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteCargoByIds(String[] ids);

	/**
	 * 根据订单号删除货物
	 *
	 * @param cargoNo 需要删除的数据的订单号
	 * @return 结果
	 */
	int deleteCargoByCargoNo(String cargoNo);
	
}