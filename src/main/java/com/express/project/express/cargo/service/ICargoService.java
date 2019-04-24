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
	 void insertCargo(Cargo cargo)throws  Exception;
	
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
	/**
	 * 删除货物信息
	 *
	 * @param orderNo 需要删除的数据的订单编号
	 * @return 结果
	 */
	 void deleteCargoByOrderNo(String orderNo)throws  Exception;


	/**
	 * 根据订单号集合，批量查询
	 *
	 * @param cargoNoList 需要查询的数据的订单号
	 * @return 结果
	 */
	List<Cargo> selectCargoByOrderNoList(List<String> cargoNoList)throws Exception;
}
