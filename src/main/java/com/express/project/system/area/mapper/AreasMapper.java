package com.express.project.system.area.mapper;

import com.express.project.system.area.domain.Areas;

import java.util.List;

/**
 * 区县 数据层
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public interface AreasMapper 
{
	/**
     * 查询区县信息
     * 
     * @param id 区县ID
     * @return 区县信息
     */
	public Areas selectAreasById(Integer id);
	
	/**
     * 查询区县列表
     * 
     * @param areas 区县信息
     * @return 区县集合
     */
	public List<Areas> selectAreasList(Areas areas);
	
	/**
     * 新增区县
     * 
     * @param areas 区县信息
     * @return 结果
     */
	public int insertAreas(Areas areas);
	
	/**
     * 修改区县
     * 
     * @param areas 区县信息
     * @return 结果
     */
	public int updateAreas(Areas areas);
	
	/**
     * 删除区县
     * 
     * @param id 区县ID
     * @return 结果
     */
	public int deleteAreasById(Integer id);
	
	/**
     * 批量删除区县
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAreasByIds(String[] ids);
	
}