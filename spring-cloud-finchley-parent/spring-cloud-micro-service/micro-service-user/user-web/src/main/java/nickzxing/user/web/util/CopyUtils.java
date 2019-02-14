package nickzxing.user.web.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NickZxing
 * @date 2019/1/5 14:32
 * POJO转换类，目前用于VO、BO、PO之间相同属性字段之间的复制
 */
public class CopyUtils {

    /**
     * 复制bean的属性
     *
     * @param source
     * @param targetClazz
     * @return
     */
    public static <T> T copyBean(Object source, Class<T> targetClazz) {
        if (null == source) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(source), targetClazz);
    }

    /**
     * 复制bean的属性并保留NULL值的属性
     *
     * @param source
     * @param targetClazz
     * @return
     */
    public static <T> T copyBeanWithWriteMapNullValue(Object source, Class<T> targetClazz) {
        if (null == source) {
            return null;
        }
        return JSON.parseObject(JSON.toJSONString(source, SerializerFeature.WriteMapNullValue), targetClazz);
    }

    /**
     * 复制ListBean的属性
     *
     * @param sourceList
     * @param targetClazz
     * @return
     */
    public static <T, E> List<T> copyList(List<E> sourceList, Class<T> targetClazz) {
        if (null == sourceList) {
            return null;
        } else if (0 == sourceList.size()) {
            return new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(sourceList), targetClazz);
    }


    /**
     * 复制ListBean的属性并保留NULL值的属性
     *
     * @param sourceList
     * @param targetClazz
     * @return
     */
    public static <T, E> List<T> copyListWithWriteMapNullValue(List<E> sourceList, Class<T> targetClazz) {
        if (null == sourceList) {
            return null;
        } else if (0 == sourceList.size()) {
            return new ArrayList<>();
        }
        return JSON.parseArray(JSON.toJSONString(sourceList, SerializerFeature.WriteMapNullValue), targetClazz);
    }

}
