package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 在 Resource 的资源加载器的实现中包括了，ClassPath、系统文件、云配置文件，
 * 这三部分与 Spring 源码中的设计和实现保持一致，最终在 DefaultResourceLoader 中做具体的调用。
 * @author HASEE
 */
public interface Resource {

    /**
     *
     * @return InputStream
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

}
