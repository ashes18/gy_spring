package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 一级缓存
     * 放置已经被实例化好的 bean【已完成生命周期】 单例 bean 才会存在这里，而原型是不需要缓存的，每次调用 getBean() 去创建新的 bean。
     */
    private Map<String, Object> singletonObjects = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

}
