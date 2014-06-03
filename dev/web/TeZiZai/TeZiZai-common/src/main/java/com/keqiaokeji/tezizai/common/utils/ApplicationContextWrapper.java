package com.keqiaokeji.tezizai.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author: Ivan Vigoss
 * Date: 13-4-23
 * Time: 下午4:33
 */
public class ApplicationContextWrapper implements ApplicationContextAware {

    public static ApplicationContext context;

    /**
     * 服务器启动的时候会自动调用该函数，初始化context对象
     * @param applicationContext
     * @throws org.springframework.beans.BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 这是一个便利的方法，帮助我们快速得到一个BEAN
     * @param beanName bean的名字（如userService）
     * @return 返回一个bean对象
     */
    public static Object getBean( String beanName ) {
        return context.getBean(beanName );
    }
}
