package unit;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author 梁昊
 * @date 2019/3/30
 * @function
 * @editLog
 */
public class PageList {
    /**
     * LEFT JOIN 将相关字典表查询list信息合并到主业务查询数据List中(list数据左关联,mainList中存在匹配到dictList的数据有值,其余的没值)
     *
     * @param mainList 主业务数据的list
     * @param dictList 相关字典表信息list
     * @param mainKey  主业务数据中和字典信息关联的字段,主业务表中不含有该键值的数值,则直接返回主业务数据
     * @param dictKey  字典信息中和主业务数据关联的字段,字典表中不含有该键值的数值,则直接返回主业务数据
     * @return List
     */
    public static List<Map<String, Object>> mergeListLeft(List<Map<String, Object>> mainList,
                                                          List<Map<String, Object>> dictList,
                                                          String mainKey, String dictKey) {
        // 结果返回的List
        List<Map<String, Object>> returnList = new ArrayList<Map<String, Object>>();

        // 防空校验
        if (mainList == null || dictList == null) {
            return returnList;
        }

        // 循环主业务数据的List
        for (Map<String, Object> mainMap : mainList) {
            String mainValue = mainMap.get(mainKey) != null ? mainMap.get(mainKey).toString() : null;
            // 如果主业务表中不存在以mainKey为键值的字段则直接返回主业务数据
            if (null == mainValue) {
                return mainList;
            }
            String dictValue = "";
            // 每条主业务数据和字典表信息依次去匹配
            int dictListSize = dictList.size();
            int currentSize = 0;
            for (Map<String, Object> dictMap : dictList) {
                dictValue = dictMap.get(dictKey) != null ? dictMap.get(dictKey).toString() : null;
                // 如果字典表中不存在以dictKey为键值的字段则直接返回主业务数据
                if (null == dictValue) {
                    return mainList;
                }
                // 迭代字典表信息
                Iterator<Map.Entry<String, Object>> it = dictMap.entrySet().iterator();
                // 主业务信息中比较字段的值和字典信息中比较字段的值相等则将该条字典表数据合并到当前迭代的主业务信息数据中
                // 存在匹配值的时候将字典表信息加入业务表数据
                if (mainValue.equals(dictValue)) {
                    while (it.hasNext()) {
                        Map.Entry<String, Object> dictEntry = (Map.Entry<String, Object>) it.next();
                        // 将字典表信息中和主业务信息中重复的key的字段去掉,剩余的合并到主业务信息中
                        if (!mainMap.containsKey(dictEntry.getKey())) {
                            mainMap.put(dictEntry.getKey(), dictEntry.getValue());
                        }
                    }
                    returnList.add(mainMap);
                    break;
                    // 字典没有匹配的数据,将字典表的值清空放入业务表
                } else {
                    if (++currentSize == dictListSize) {
                        dealIterator(mainMap, it);
                        returnList.add(mainMap);
                    }
                }
            }

        }

        // 主业务数据和字典表数据无匹配的数据也直接返回主业务数据
        return returnList.isEmpty() ? mainList : returnList;
    }


    /**
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param mainMap
     * @param it
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    private static void dealIterator(Map<String, Object> mainMap, Iterator<Map.Entry<String, Object>> it) {
        while (it.hasNext()) {
            Map.Entry<String, Object> dictEntry = (Map.Entry<String, Object>) it.next();
            // 将字典表信息中和主业务信息中重复的key的字段去掉,剩余的合并到主业务信息中
            if (!mainMap.containsKey(dictEntry.getKey())) {
                mainMap.put(dictEntry.getKey(), null);
            }
        }

    }

    /**
     * 将list转成Map
     *
     * @param list          待转的列表
     * @param keyMethodName 根据要转的方法名
     * @param c             列表类
     * @param <K>           转后关键类属性
     * @param <V>           转后列表
     * @return 得到以关键类属性为键的值MAP
     */
    public static <K, V> Map<K, V> listToMap(List<V> list, String keyMethodName, Class<V> c) {
        Map<K, V> map = new HashMap<>();
        if (list != null) {
            try {
                Method methodGetKey = c.getMethod(keyMethodName);
                for (int i = 0; i < list.size(); i++) {
                    V value = list.get(i);
                    @SuppressWarnings("unchecked")
                    K key = (K) methodGetKey.invoke(list.get(i));
                    map.put(key, value);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("field can't match the key!");
            }
        }

        return map;
    }

    /**
     * 得到分页的列表
     *
     * @param pageIndex 当前页数
     * @param pageSize  每页条数
     * @param myList    需分页的列表
     * @return 列表
     */
    public static List<?> getPageList(int pageIndex, int pageSize, List<?> myList) {
        if ((myList == null) || myList.isEmpty()) {
            return myList.subList(0, 0);
        }
        if (pageIndex >= 1000) {
            return myList;
        }
        pageIndex = pageIndex < 1 ? 1 : pageIndex;
        int maxSize = myList.size();
        int pageCount = maxSize / pageSize;
        int fromIndex = (pageIndex - 1) * pageSize;
        int toIndex = (fromIndex + pageSize >= maxSize) ? maxSize : (fromIndex + pageSize);
        if (pageIndex > pageCount + 1) {
            fromIndex = 0;
            toIndex = 0;
        }
        return myList.subList(fromIndex, toIndex);
    }

}
