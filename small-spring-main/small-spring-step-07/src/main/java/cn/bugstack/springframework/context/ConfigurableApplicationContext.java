package cn.bugstack.springframework.context;

import cn.bugstack.springframework.beans.BeansException;

/**
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link cn.bugstack.springframework.context.ApplicationContext} interface.
 *
 *
 *
 * @author HASEE
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;
    /**
     * 虚拟机关闭钩子注册调用销毁方法
     */
    void registerShutdownHook();

    /**
     * 手动关闭
     */
    void close();

}
