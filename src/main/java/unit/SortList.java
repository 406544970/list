package unit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * @author 梁昊
 * @date 2019/3/29
 * @function 排序类
 * @editLog
 */
public class SortList<T> {
    public void Sort(List<T> list, final String method, final String sort) {
        Collections.sort(list, (a, b) -> {
            int ret = 0;
            try {
                Method m1 = ((T) a).getClass().getMethod(method, null);
                Method m2 = ((T) b).getClass().getMethod(method, null);
                if (sort != null && "desc".equals(sort))// 倒序
                    ret = m2.invoke(b, null).toString()
                            .compareTo(m1.invoke(a, null).toString());
                else
                    // 正序
                    ret = m1.invoke(a, null).toString()
                            .compareTo(m2.invoke(b, null).toString());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ne) {
                System.out.println(ne);
            }
            return ret;
        });
    }
}
