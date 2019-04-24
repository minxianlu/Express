package com.express.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.http.HttpServletRequest;

/**
 * Map通用处理方法
 * 
 * @author chenyb
 */
public class MapDataUtil
{
    public static Map<String, Object> convertDataMap(HttpServletRequest request)
    {
        Map<String, String[]> properties = request.getParameterMap();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        Iterator<?> entries = properties.entrySet().iterator();
        Map.Entry<?, ?> entry;
        String name = "";
        String value = "";
        while (entries.hasNext())
        {
            entry = (Entry<?, ?>) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if (null == valueObj)
            {
                value = "";
            }
            else if (valueObj instanceof String[])
            {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++)
                {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            }
            else
            {
                value = valueObj.toString();
            }
            returnMap.put(name, value);
        }
        return returnMap;
    }


    /**
     * 用于把List<Object>转换成Map<String,Object>形式
     *
     * @author minxl
     * @param keyName
     *            主键属性
     * @param list
     *            集合
     * @return 返回对象
     */
    public static <T> Map<String, T> listToMap(String keyName, List<T> list) {
        Map<String, T> m = new HashMap<String, T>();
        if ((null != list) && StringUtils.isNotEmpty(keyName)) {
            try {
                for (T t : list) {
                    PropertyDescriptor pd = new PropertyDescriptor(keyName, t.getClass());
                    Method getMethod = pd.getReadMethod();// 获得get方法
                    Object o = getMethod.invoke(t);// 执行get方法返回一个Object
                    if(BeanUtil.isNotEmpty(o)){
                        m.put(o.toString(), t);
                    }
                }
                return m;
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return m;
    }



}
