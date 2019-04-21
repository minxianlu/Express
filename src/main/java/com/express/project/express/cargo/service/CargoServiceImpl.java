package com.express.project.express.cargo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.cargo.mapper.CargoMapper;
import com.express.project.express.cargo.domain.Cargo;
import com.express.project.express.cargo.service.ICargoService;
import com.express.common.utils.text.Convert;

/**
 * 货物 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class CargoServiceImpl implements ICargoService 
{
	@Autowired
	private CargoMapper cargoMapper;

	/**
     * 查询货物信息
     * 
     * @param id 货物ID
     * @return 货物信息
     */
    @Override
	public Cargo selectCargoById(Integer id)
	{
	    return cargoMapper.selectCargoById(id);
	}
	
	/**
     * 查询货物列表
     * 
     * @param cargo 货物信息
     * @return 货物集合
     */
	@Override
	public List<Cargo> selectCargoList(Cargo cargo)
	{
	    return cargoMapper.selectCargoList(cargo);
	}
	
    /**
     * 新增货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	@Override
	public int insertCargo(Cargo cargo)
	{
	    return cargoMapper.insertCargo(cargo);
	}
	
	/**
     * 修改货物
     * 
     * @param cargo 货物信息
     * @return 结果
     */
	@Override
	public int updateCargo(Cargo cargo)
	{
	    return cargoMapper.updateCargo(cargo);
	}

	/**
     * 删除货物对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteCargoByIds(String ids)
	{
		return cargoMapper.deleteCargoByIds(Convert.toStrArray(ids));
	}
	
}
