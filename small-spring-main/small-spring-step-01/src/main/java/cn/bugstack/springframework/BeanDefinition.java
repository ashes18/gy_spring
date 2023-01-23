package cn.bugstack.springframework;

/**
 * 定义 Bean 实例化信息，现在的实现是以一个 Object 存放对象
 * @author HASEE
 */
public class BeanDefinition {

    /**
     * 只有一个 Object 用于存放 Bean 对象
     */
    private Object bean;

    /**
     * 在 Bean 的注册中，这里是直接把 UserService 实例化后作为入参传递给 BeanDefinition 的
     */
    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }

}
