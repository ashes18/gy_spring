package cn.bugstack.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 在 Spring 框架下创建 core.io 核心包，在这个包中主要用于处理资源加载流。
 * @author HASEE
 */
public interface Resource {

    /**
     * 定义 Resource 接口，提供获取 InputStream 流的方法，接下来再分别实现三种不同的流文件操作：classPath、FileSystem、URL
     * @return InputStream
     * @throws IOException
     */
    InputStream getInputStream() throws IOException;

}
