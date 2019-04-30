package com.express.project.system.area.service;

import com.express.project.system.area.domain.Cities;

import java.util.List;
import java.util.Map;

/**
 * 城市 服务层
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public interface ICitiesService 
{
	/**
     * 查询城市信息
     * 
     * @param id 城市ID
     * @return 城市信息
     */
	 Cities selectCitiesById(Integer id);
	
	/**
     * 查询城市列表
     * 
     * @param cities 城市信息
     * @return 城市集合
     */
	 List<Cities> selectCitiesList(Cities cities);
	
	/**
     * 新增城市
     * 
     * @param cities 城市信息
     * @return 结果
     */
	 int insertCities(Cities cities);
	
	/**
     * 修改城市
     * 
     * @param cities 城市信息
     * @return 结果
     */
	 int updateCities(Cities cities);
		
	/**
     * 删除城市信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteCitiesByIds(String ids);

	/**
	 * 批量查询城市，根据城市编码集合批量查询
	 *
	 * @param list 需要查询的数据citiesId
	 * @return 结果
	 */
	List<Cities> selectCityByCityIds(List<String> list);

	/**
	 * 通过城市编码集合查询，以Map形式返回，key:城市编码，value:城市
	 *
	 * @param list 需要查询的数据citiesId
	 * @return 结果
	 */
	Map<String,Cities> getCityMapByCityIds(List<String> list)throws Exception;

}
