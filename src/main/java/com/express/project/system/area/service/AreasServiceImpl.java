package com.express.project.system.area.service;

import java.util.List;

import com.express.project.system.area.domain.Areas;
import com.express.project.system.area.mapper.AreasMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.text.Convert;

/**
 * 区县 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Service
public class AreasServiceImpl implements IAreasService 
{
	@Autowired
	private AreasMapper areasMapper;

	/**
     * 查询区县信息
     * 
     * @param id 区县ID
     * @return 区县信息
     */
    @Override
	public Areas selectAreasById(Integer id)
	{
	    return areasMapper.selectAreasById(id);
	}
	
	/**
     * 查询区县列表
     * 
     * @param areas 区县信息
     * @return 区县集合
     */
	@Override
	public List<Areas> selectAreasList(Areas areas)
	{
	    return areasMapper.selectAreasList(areas);
	}
	
    /**
     * 新增区县
     * 
     * @param areas 区县信息
     * @return 结果
     */
	@Override
	public int insertAreas(Areas areas)
	{
	    return areasMapper.insertAreas(areas);
	}
	
	/**
     * 修改区县
     * 
     * @param areas 区县信息
     * @return 结果
     */
	@Override
	public int updateAreas(Areas areas)
	{
	    return areasMapper.updateAreas(areas);
	}

	/**
     * 删除区县对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteAreasByIds(String ids)
	{
		return areasMapper.deleteAreasByIds(Convert.toStrArray(ids));
	}
	
}
