package com.express.project.system.area.service;

import com.express.project.system.area.domain.Provinces;

import java.util.List;

/**
 * 省份 服务层
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public interface IProvincesService 
{
	/**
     * 查询省份信息
     * 
     * @param id 省份ID
     * @return 省份信息
     */
	 Provinces selectProvincesById(Integer id);
	
	/**
     * 查询省份列表
     * 
     * @param provinces 省份信息
     * @return 省份集合
     */
	 List<Provinces> selectProvincesList(Provinces provinces);
	
	/**
     * 新增省份
     * 
     * @param provinces 省份信息
     * @return 结果
     */
	 int insertProvinces(Provinces provinces);
	
	/**
     * 修改省份
     * 
     * @param provinces 省份信息
     * @return 结果
     */
	 int updateProvinces(Provinces provinces);
		
	/**
     * 删除省份信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteProvincesByIds(String ids);
	
}
