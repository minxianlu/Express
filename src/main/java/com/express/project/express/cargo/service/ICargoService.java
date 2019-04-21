package com.express.project.express.cargo.service;

import com.express.project.express.cargo.domain.Cargo;
import java.util.List;

/**
 * 货物 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface ICargoService 
{
	/**
     * 查询货物信息
     * 
     * @param id 货物ID
     * @return 货物信息
     */
	 Cargo selectCargoById(Integer id);
	
	/**
     * 查询货物列表
     * 
     * @param cargo 货物信息
     * @return 货物集合
     */
	 List<Cargo> selectCargoList(Cargo cargo);
	
	/**
     * 新增货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	 int insertCargo(Cargo cargo);
	
	/**
     * 修改货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	 int updateCargo(Cargo cargo);
		
	/**
     * 删除货物信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteCargoByIds(String ids);
	
}
