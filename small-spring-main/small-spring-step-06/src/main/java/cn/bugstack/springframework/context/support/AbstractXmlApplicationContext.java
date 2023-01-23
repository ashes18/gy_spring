package cn.bugstack.springframework.context.support;

import cn.bugstack.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * Convenient base class for {@link cn.bugstack.springframework.context.ApplicationContext}
 * implementations, drawing configuration from XML documents containing bean definitions
 * understood by an {@link cn.bugstack.springframework.beans.factory.xml.XmlBeanDefinitionReader}.
 *
 * 上下文中对配置信息的加载:处理了关于 XML 文件配置信息的操作
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author HASEE
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {

    /**
     * 在 AbstractXmlApplicationContext 抽象类的 loadBeanDefinitions 方法实现中，
     * 使用 XmlBeanDefinitionReader 类，处理了关于 XML 文件配置信息的操作。
     * @param beanFactory
     */
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    /**
     * 此方法是为了从入口上下文类，拿到配置信息的地址描述。
     * @return
     */
    protected abstract String[] getConfigLocations();

}
