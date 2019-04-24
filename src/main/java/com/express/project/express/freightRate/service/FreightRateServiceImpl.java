package com.express.project.express.freightRate.service;

import java.math.BigDecimal;
import java.util.*;

import com.express.common.utils.security.ShiroUtils;
import com.express.framework.web.domain.AjaxResult;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.freightRate.mapper.FreightRateMapper;
import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.freightRate.service.IFreightRateService;
import com.express.common.utils.text.Convert;

/**
 * 运价因子 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class FreightRateServiceImpl implements IFreightRateService 
{
	@Autowired
	private FreightRateMapper freightRateMapper;
	@Autowired
	private IStationService stationService;

	/**
     * 查询运价因子信息
     * 
     * @param id 运价因子ID
     * @return 运价因子信息
     */
    @Override
	public FreightRate selectFreightRateById(Integer id)
	{
	    return freightRateMapper.selectFreightRateById(id);
	}
	
	/**
     * 查询运价因子列表
     * 
     * @param freightRate 运价因子信息
     * @return 运价因子集合
     */
	@Override
	public List<FreightRate> selectFreightRateList(FreightRate freightRate)
	{
	    return freightRateMapper.selectFreightRateList(freightRate);
	}
	
    /**
     * 新增运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	@Override
	public void insertFreightRate(FreightRate freightRate)throws Exception
	{
		FreightRate f=freightRateMapper.selectFreightRate(freightRate);
		if(f!=null){
			throw new Exception("已存在该运价");
		}
		freightRate.setCreateBy(ShiroUtils.getUserName());
		freightRate.setCreateTime(new Date());
		 freightRateMapper.insertFreightRate(freightRate);
	}
	
	/**
     * 修改运价因子
     * 
     * @param freightRate 运价因子信息
     * @return 结果
     */
	@Override
	public void updateFreightRate(FreightRate freightRate)throws Exception
	{
		freightRate.setUpdateBy(ShiroUtils.getUserName());
		freightRate.setUpdateTime(new Date());
		freightRateMapper.updateFreightRate(freightRate);
	}

	/**
     * 删除运价因子对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteFreightRateByIds(String ids)
	{
		return freightRateMapper.deleteFreightRateByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<FreightRate> selectFreightRateByStationIds(String ids) throws Exception {
		return freightRateMapper.selectFreightRateByStationIds(Convert.toStrArray(ids));
	}

	@Override
	public void deleteFreightRateByStationIds(String ids) throws Exception {
		freightRateMapper.deleteFreightRateByStationIds(Convert.toStrArray(ids));
	}


	@Override
	public List<Station> selectStationByFreightRate(FreightRate freightRate) throws Exception {
		List<FreightRate> freightRateList=freightRateMapper.selectFreightRateList(freightRate);
		List<Integer> stationList = new ArrayList<Integer>();
		if(freightRate.getSendStation()!=null){
			stationList.add(freightRate.getSendStation());
		}
		if(freightRate.getReceiveStation()!=null){
			stationList.add(freightRate.getReceiveStation());
		}
		for (FreightRate rate : freightRateList) {
			if(rate.getSendStation()!=null){
				stationList.add(rate.getSendStation());
			}
			if(rate.getReceiveStation()!=null){
				stationList.add(rate.getReceiveStation());
			}
		}
		return stationService.selectStationNotInIds(stationList);
	}


	@Override
	public FreightRate selectFreightRate(FreightRate freightRate)throws Exception {
		FreightRate result=freightRateMapper.selectFreightRate(freightRate);
		if(result==null){
			return new FreightRate() ;
		}
		String t=Integer.parseInt(result.getWeight())>10?result.getWeight():10+"";
		BigDecimal bigPriceFactor=new BigDecimal(result.getPriceFactor());
		BigDecimal bigWeight=new BigDecimal(t);
		String p=bigPriceFactor.multiply(bigWeight).setScale(1,BigDecimal.ROUND_HALF_UP).toString();
		result.setPrice(Integer.parseInt(p)>2?p:(2+""));
		return result;
	}
}
