package com.express.project.system.area.service;

import java.util.List;

import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.mapper.ProvincesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.text.Convert;

/**
 * 省份 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Service
public class ProvincesServiceImpl implements IProvincesService 
{
	@Autowired
	private ProvincesMapper provincesMapper;

	/**
     * 查询省份信息
     * 
     * @param id 省份ID
     * @return 省份信息
     */
    @Override
	public Provinces selectProvincesById(Integer id)
	{
	    return provincesMapper.selectProvincesById(id);
	}
	
	/**
     * 查询省份列表
     * 
     * @param provinces 省份信息
     * @return 省份集合
     */
	@Override
	public List<Provinces> selectProvincesList(Provinces provinces)
	{
	    return provincesMapper.selectProvincesList(provinces);
	}
	
    /**
     * 新增省份
     * 
     * @param provinces 省份信息
     * @return 结果
     */
	@Override
	public int insertProvinces(Provinces provinces)
	{
	    return provincesMapper.insertProvinces(provinces);
	}
	
	/**
     * 修改省份
     * 
     * @param provinces 省份信息
     * @return 结果
     */
	@Override
	public int updateProvinces(Provinces provinces)
	{
	    return provincesMapper.updateProvinces(provinces);
	}

	/**
     * 删除省份对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteProvincesByIds(String ids)
	{
		return provincesMapper.deleteProvincesByIds(Convert.toStrArray(ids));
	}
	
}
