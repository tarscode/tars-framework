package com.tarscode.framework;

import com.tarscode.framework.helper.BeanHelper;
import com.tarscode.framework.helper.ClassHelper;
import com.tarscode.framework.helper.ControllerHelper;
import com.tarscode.framework.helper.IoCHelper;
import com.tarscode.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 * Created by liuyang on 17/3/14.
 */
public class HelperLoader {
    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IoCHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
