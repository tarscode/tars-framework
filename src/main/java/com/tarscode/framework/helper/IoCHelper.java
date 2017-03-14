package com.tarscode.framework.helper;
import com.tarscode.framework.annotation.Inject;
import com.tarscode.framework.util.CollectionUtil;
import com.tarscode.framework.util.ReflectionUtil;
import com.tarscode.framework.util.ArrayUtil;

import java.lang.reflect.Field;
import java.util.Map;
/**
 * 依赖注入辅助类
 * Created by liuyang on 17/3/14.
 */
public final class IoCHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
