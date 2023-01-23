package cn.bugstack.springframework.beans.factory.support;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;

/**
 *
 * 抽象类定义模板方法
 *
 * BeanFactory 这个 Bean 工厂接口由抽象类 AbstractBeanFactory 实现。这样使用模板模式 (opens new window)的设计方式，
 * 可以统一收口通用核心方法的调用逻辑和标准定义，也就很好的控制了后续的实现者不用关心调用逻辑，按照统一方式执行。
 * 那么类的继承者只需要关心具体方法的逻辑实现即可。
 *
 * BeanFactory 的定义由 AbstractBeanFactory 抽象类实现接口的 getBean 方法
 * 而 AbstractBeanFactory 又继承了实现了 SingletonBeanRegistry 的DefaultSingletonBeanRegistry 类
 * AbstractBeanFactory 抽象类就具备了单例 Bean 的注册功能
 * @author HASEE
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    /**
     * 获取bean
     * 01、缓存获取bean
     * 02、缓存没有bean则获取bean的定义、实例化bean,调用 addSingleton 方法存放到单例对象的缓存中去
     * @param name
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name) throws BeansException {
        //继承了 DefaultSingletonBeanRegistry，也就具备了使用单例注册类方法
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        //获取不到时需要拿到 Bean 的定义做相应 Bean 实例化操作
        //getBean 并没有自身的去实现这些方法，而是只定义了调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应实现
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    /**
     * 获取bean定义
     * @param beanName
     * @return
     * @throws BeansException
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 实例化bean,调用 addSingleton 方法存放到单例对象的缓存中去
     * @param beanName
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

}
