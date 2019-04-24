package com.express.common.utils;

import java.util.Collection;

/**
 * 对象工具类
 *
 * @author chenyb
 */
public class BeanUtil {


    /**
     * 判断-是否为空
     * @param o java.lang.Object.
     * @return boolean.
     */
    public static boolean isEmpty(Object o) {
        if(null==o || "".equals(o))
            return true;
        if (o instanceof Collection){
            if (((Collection<?>) o).isEmpty()){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(Object o){
        return !isEmpty(o);
    }
}
