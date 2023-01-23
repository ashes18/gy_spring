package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * 实例化Bean类
 * @author HASEE
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            //实现了 Bean 的实例化操作 newInstance，其实这块会埋下一个坑，有构造函数入参的对象怎么处理？可以提前思考
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        //在处理完 Bean 对象的实例化后，直接调用 addSingleton 方法存放到单例对象的缓存中去
        addSingleton(beanName, bean);
        return bean;
    }

}
