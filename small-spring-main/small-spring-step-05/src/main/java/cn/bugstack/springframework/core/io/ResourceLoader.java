package cn.bugstack.springframework.core.io;

/**
 * 对资源封装的加载器
 * @author HASEE
 */
public interface ResourceLoader {

    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);

}
