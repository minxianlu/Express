package com.express.project.system.area.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.express.common.utils.MapDataUtil;
import com.express.common.utils.bean.BeanUtils;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.mapper.CitiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.text.Convert;

/**
 * 城市 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Service
public class CitiesServiceImpl implements ICitiesService 
{
	@Autowired
	private CitiesMapper citiesMapper;

	/**
     * 查询城市信息
     * 
     * @param id 城市ID
     * @return 城市信息
     */
    @Override
	public Cities selectCitiesById(Integer id)
	{
	    return citiesMapper.selectCitiesById(id);
	}
	
	/**
     * 查询城市列表
     * 
     * @param cities 城市信息
     * @return 城市集合
     */
	@Override
	public List<Cities> selectCitiesList(Cities cities)
	{
	    return citiesMapper.selectCitiesList(cities);
	}
	
    /**
     * 新增城市
     * 
     * @param cities 城市信息
     * @return 结果
     */
	@Override
	public int insertCities(Cities cities)
	{
	    return citiesMapper.insertCities(cities);
	}
	
	/**
     * 修改城市
     * 
     * @param cities 城市信息
     * @return 结果
     */
	@Override
	public int updateCities(Cities cities)
	{
	    return citiesMapper.updateCities(cities);
	}

	/**
     * 删除城市对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCitiesByIds(String ids)
	{
		return citiesMapper.deleteCitiesByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Cities> selectCityByCityIds(List<String> list) {
		return citiesMapper.selectCityByCityIds(list);
	}


	@Override
	public Map<String, Cities> getCityMapByCityIds(List<String> list)throws Exception {
		Map<String,Cities> cityMap=new HashMap<>(16);
		if(BeanUtils.isNotEmpty(list)) {
			List<Cities> cityList=citiesMapper.selectCityByCityIds(list);
			cityMap= MapDataUtil.listToMap("cityid",cityList);
		}
		return cityMap;
	}
}
