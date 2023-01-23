package cn.bugstack.springframework;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 代表了 Bean 对象的工厂，可以存放 Bean 定义到 Map 中以及获取。
 * 在 Bean 工厂的实现中，包括了 Bean 的注册，这里注册的是 Bean 的定义信息。同时在这个类中还包括了获取 Bean 的操作。
 *
 * @author HASEE
 */
public class BeanFactory {

    /**
     * HashMap 是一种基于扰动函数、负载因子、红黑树转换等技术内容，形成的拉链寻址的数据结构，它能让数据更加散列的分布在哈希桶以及碰撞时形成的链表和红黑树上。
     * 它的数据结构会尽可能最大限度的让整个数据读取的复杂度在 O(1) ~ O(Logn) ~O(n)之间，当然在极端情况下也会有 O(n) 链表查找数据较多的情况。
     * 不过我们经过10万数据的扰动函数再寻址验证测试，数据会均匀的散列在各个哈希桶索引上，所以 HashMap 非常适合用在 Spring Bean 的容器实现上。
     *
     *
     * ConcurrentHashMap是一个支持高并发更新与查询的哈希表(基于HashMap)。
     * 在保证安全的前提下，进行检索不需要锁定。与hashtable不同，该类不依赖于synchronization去保证线程操作的安全。
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 获取bean
     * @param name
     * @return
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    /**
     * 将bean注册在工厂
     * @param name
     * @param beanDefinition
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

}
