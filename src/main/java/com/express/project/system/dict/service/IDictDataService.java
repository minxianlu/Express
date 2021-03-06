package com.express.project.system.dict.service;

import java.util.List;
import java.util.Map;

import com.express.project.system.dict.domain.DictData;

/**
 * 字典 业务层
 * 
 * @author chenyb
 */
public interface IDictDataService
{
    /**
     * 根据条件分页查询字典数据
     * 
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
     List<DictData> selectDictDataList(DictData dictData);

    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
     List<DictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
     String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
     DictData selectDictDataById(Long dictCode);

    /**
     * 通过字典ID删除字典数据信息
     * 
     * @param dictCode 字典数据ID
     * @return 结果
     */
     int deleteDictDataById(Long dictCode);

    /**
     * 批量删除字典数据
     * 
     * @param ids 需要删除的数据
     * @return 结果
     */
     int deleteDictDataByIds(String ids);

    /**
     * 新增保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
     int insertDictData(DictData dictData);

    /**
     * 修改保存字典数据信息
     * 
     * @param dictData 字典数据信息
     * @return 结果
     */
     int updateDictData(DictData dictData);

    /**
     * 通过字典类型集合批量查询
     *
     * @param dictTypeList 字典类型集合
     * @return 结果
     */
    List<DictData> selectDictDataByDictTypeList(List<String> dictTypeList);


    /**
     * 通过dictType查询dictData,以Map形式返回；key=dictType+dictValue，value:dictData
     *
     * @param dictType 字典类型
     * @return 结果
     */
    Map<String, DictData> getDictDataMapByDictType(String dictType)throws Exception;

    /**
     * 通过dictType集合查询dictData,以Map形式返回；key=dictType+dictValue，value:dictData
     *
     * @param dictTypeList 字典类型
     * @return 结果
     */
    Map<String, DictData> getDictDataMapByDictType(List<String> dictTypeList)throws Exception;
}
