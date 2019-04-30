package com.express.project.express.freightRate.service;

import java.math.BigDecimal;
import java.util.*;

import com.express.common.utils.MapDataUtil;
import com.express.common.utils.bean.BeanUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.framework.web.domain.AjaxResult;
import com.express.project.common.ExpressConstant;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.project.system.dict.domain.DictData;
import com.express.project.system.dict.service.IDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.freightRate.mapper.FreightRateMapper;
import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.freightRate.service.IFreightRateService;
import com.express.common.utils.text.Convert;

/**
 * 运价 服务层实现
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
	@Autowired
	private IDictDataService dictDataService;




	/**
     * 查询运价信息
     * 
     * @param id 运价ID
     * @return 运价信息
     */
    @Override
	public FreightRate selectFreightRateById(Integer id)
	{
	    return freightRateMapper.selectFreightRateById(id);
	}
	
	/**
     * 查询运价列表
     * 
     * @param freightRate 运价信息
     * @return 运价集合
     */
	@Override
	public List<FreightRate> selectFreightRateList(FreightRate freightRate) throws Exception
	{
		List<FreightRate> list=freightRateMapper.selectFreightRateList(freightRate);
		List<Integer> stationIdList=new ArrayList<>();
		List<String> dictTypeList=new ArrayList<>();
		dictTypeList.add(ExpressConstant.EX_SERVICE_MODE);
		dictTypeList.add(ExpressConstant.EX_FREIGHT_RATE_STATUS);

		for (FreightRate rate : list) {
			stationIdList.add(rate.getSendStation());
			stationIdList.add(rate.getReceiveStation());
		}

		Map<String,DictData> dictDataMap=dictDataService.getDictDataMapByDictType(dictTypeList);

		Map<String,Station> stationMap=stationService.getStationMapByIds(stationIdList);


		for (FreightRate rate : list) {
			if(stationMap.containsKey(rate.getSendStation()+"")){
				rate.setSendStationStr(stationMap.get(rate.getSendStation()+"").getStationName());
			}
			if(stationMap.containsKey(rate.getReceiveStation()+"")){
				rate.setReceiveStationStr(stationMap.get(rate.getReceiveStation()+"").getStationName());
			}
			if(dictDataMap.containsKey(ExpressConstant.EX_FREIGHT_RATE_STATUS+rate.getStatus())){
				rate.setStatusStr(dictDataMap.get(ExpressConstant.EX_FREIGHT_RATE_STATUS+rate.getStatus()).getDictLabel());
			}
			if(dictDataMap.containsKey(ExpressConstant.EX_SERVICE_MODE+rate.getServiceMode())){
				rate.setServiceModeStr(dictDataMap.get(ExpressConstant.EX_SERVICE_MODE+rate.getServiceMode()).getDictLabel());
			}
		}

	    return list;
	}
	
    /**
     * 新增运价
     * 
     * @param freightRate 运价信息
     * @return 结果
     */
	@Override
	public void insertFreightRate(FreightRate freightRate)throws Exception
	{
		List<FreightRate> f=freightRateMapper.selectFreightRate(freightRate);
		if(BeanUtils.isNotEmpty(f)){
			throw new Exception("已存在该运价");
		}
		freightRate.setCreateBy(ShiroUtils.getUserName());
		freightRate.setCreateTime(new Date());
		 freightRateMapper.insertFreightRate(freightRate);
	}
	
	/**
     * 修改运价
     * 
     * @param freightRate 运价信息
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
     * 删除运价对象
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
	public List<FreightRate>  queryFreightRate(FreightRate freightRate)throws Exception {
		List<FreightRate> result=freightRateMapper.selectFreightRate(freightRate);
		if(result==null){
			return new ArrayList<FreightRate>();
		}
		List<Integer> stationIds=new ArrayList<>();
		for (FreightRate rate : result) {
			stationIds.add(rate.getSendStation());
			stationIds.add(rate.getReceiveStation());
		}
		Map<String,Station> stationMap=stationService.getStationMapByIds(stationIds);

		Map<String,DictData> dictDataMap=dictDataService.getDictDataMapByDictType(ExpressConstant.EX_SERVICE_MODE);

		for (FreightRate rate : result) {
			if(stationMap.containsKey(rate.getSendStation())){
				rate.setSendStationStr(stationMap.get(rate.getSendStation()).getStationName());
			}
			if(stationMap.containsKey(rate.getReceiveStation())){
				rate.setReceiveStationStr(stationMap.get(rate.getReceiveStation()).getStationName());
			}
			if(dictDataMap.containsKey(ExpressConstant.EX_SERVICE_MODE+rate.getServiceMode())){
				rate.setServiceModeStr(dictDataMap.get(ExpressConstant.EX_SERVICE_MODE+rate.getServiceMode()).getDictLabel());
			}

			if(new BigDecimal(rate.getWeight()).compareTo(new BigDecimal(0))<=0){
				rate.setPrice(0+"");
				continue;
			}
			String t=Integer.parseInt(rate.getWeight())>10?rate.getWeight():10+"";
			BigDecimal bigPriceFactor=new BigDecimal(rate.getPriceFactor());
			BigDecimal bigWeight=new BigDecimal(t);
			String p=bigPriceFactor.multiply(bigWeight).setScale(1,BigDecimal.ROUND_HALF_UP).toString();
			rate.setPrice(Integer.parseInt(p)>2?p:(2+""));
		}
		return result;
	}

	@Override
	public FreightRate selectFreightRateForDetail(Integer id)throws Exception {
		FreightRate freightRate=freightRateMapper.selectFreightRateById(id);
		List<Integer> freightRateIdList=new ArrayList<>();
		freightRateIdList.add(freightRate.getSendStation());
		freightRateIdList.add(freightRate.getReceiveStation());

		List<Station> stationList= stationService.selectStationByIds(freightRateIdList);

		Map<String,DictData> dictDataMap=dictDataService.getDictDataMapByDictType(ExpressConstant.EX_SERVICE_MODE);
		if(dictDataMap.containsKey(ExpressConstant.EX_SERVICE_MODE+freightRate.getServiceMode())){
			freightRate.setServiceModeStr(dictDataMap.get(ExpressConstant.EX_SERVICE_MODE+freightRate.getServiceMode()).getDictLabel());
		}
		for (Station station : stationList) {
			if(freightRate.getSendStation()==station.getId()){
				freightRate.setSendStationStr(station.getStationName());
			}
			if(freightRate.getReceiveStation()==station.getId()){
				freightRate.setReceiveStationStr(station.getStationName());
			}
		}
		return freightRate;
	}
}
