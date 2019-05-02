package com.express.project.express.complaint.service;

import com.express.project.express.complaint.domain.Complaint;
import java.util.List;

/**
 * 投诉建议 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IComplaintService 
{
	/**
     * 查询投诉建议信息
     * 
     * @param id 投诉建议ID
     * @return 投诉建议信息
     */
	 Complaint selectComplaintById(Integer id);
	
	/**
     * 查询投诉建议列表
     * 
     * @param complaint 投诉建议信息
     * @return 投诉建议集合
     */
	 List<Complaint> selectComplaintList(Complaint complaint);
	
	/**
     * 新增投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	 void insertComplaint(Complaint complaint)throws Exception;
	
	/**
     * 修改投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	 void updateComplaint(Complaint complaint)throws Exception;
		
	/**
     * 删除投诉建议信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 void deleteComplaintByIds(String ids)throws Exception;
	
}
