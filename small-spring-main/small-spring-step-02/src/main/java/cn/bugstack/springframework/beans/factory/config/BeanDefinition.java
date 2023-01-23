package cn.bugstack.springframework.beans.factory.config;

/**
 * 定义bean
 * 只定义一个 Object 类型用于存放对象
 * Object bean 替换为 Class，这样就可以把 Bean 的实例化操作放到容器中处理了
 * @author HASEE
 */
@SuppressWarnings({"rawtypes"})
public class BeanDefinition {

    /**
     * Bean 注册的时候只注册一个类信息，而不会直接把实例化信息注册到 Spring 容器中
     */
    private Class beanClass;

    /**
     * Bean 的实例化操作是放在初始化调用阶段传递给 BeanDefinition 构造函数的
     * @param beanClass
     */
    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
