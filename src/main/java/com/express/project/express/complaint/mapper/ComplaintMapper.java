package com.express.project.express.complaint.mapper;

import com.express.project.express.complaint.domain.Complaint;
import java.util.List;	

/**
 * 投诉建议 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface ComplaintMapper 
{
	/**
     * 查询投诉建议信息
     * 
     * @param id 投诉建议ID
     * @return 投诉建议信息
     */
	public Complaint selectComplaintById(Integer id);
	
	/**
     * 查询投诉建议列表
     * 
     * @param complaint 投诉建议信息
     * @return 投诉建议集合
     */
	public List<Complaint> selectComplaintList(Complaint complaint);
	
	/**
     * 新增投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	public int insertComplaint(Complaint complaint);
	
	/**
     * 修改投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	public int updateComplaint(Complaint complaint);
	
	/**
     * 删除投诉建议
     * 
     * @param id 投诉建议ID
     * @return 结果
     */
	public int deleteComplaintById(Integer id);
	
	/**
     * 批量删除投诉建议
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteComplaintByIds(String[] ids);
	
}