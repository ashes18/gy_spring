package cn.bugstack.springframework.beans.factory;

/**
 * Interface to be implemented by beans that want to release resources
 * on destruction. A BeanFactory is supposed to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 *
 * InitializingBean、DisposableBean，两个接口方法还是比较常用的，在一些需要结合 Spring 实现的组件中，
 * 经常会使用这两个方法来做一些参数的初始化和销毁操作。比如接口暴漏、数据库数据读取、配置文件加载等等。
 *
 * 来自于对开源项目的学习；
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @author HASEE
 */
public interface DisposableBean {

    /**
     * 销毁操作
     * @throws Exception
     */
    void destroy() throws Exception;

}
