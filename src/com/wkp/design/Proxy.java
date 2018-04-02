package com.wkp.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理模式
 * <p>
 *      代理模式与装饰模式类似，都持有待操作类的对象，但装饰模式一般在编译时不明确待装饰对象，并且一般是增强待装饰对象的功能；而代理模式一般是在编译时就明确了
 *      编译对象（内部创建待代理对象），主要用于限制访问，不暴露真实对象。
 * </p>
 */
public class Proxy {
    interface InputStream{
        void read();
    }

    interface OutputStream{
        void write(byte b);
    }

    static class FileInputStream implements InputStream{

        @Override
        public void read() {
            System.out.println("File read");
        }
    }

    static class FileOutputStream implements OutputStream{

        @Override
        public void write(byte b) {
            System.out.println("File write");
        }
    }

    /**
     * 静态代理模式
     */
    static class FileProxy implements InputStream, OutputStream{
        private InputStream mInputStream;
        private OutputStream mOutputStream;

        public FileProxy() {
            mInputStream = new FileInputStream();
            mOutputStream = new FileOutputStream();
        }

        @Override
        public void read() {
            System.out.println("限制条件");
            mInputStream.read();
        }

        @Override
        public void write(byte b) {
            System.out.println("限制条件");
            mOutputStream.write(b);
        }
    }

    /**
     * 动态代理模式（Java自带动态代理机制）
     */
    static class DynamicProxy implements InvocationHandler{
        private OutputStream mOutputStream;

        public DynamicProxy(OutputStream outputStream) {
            mOutputStream = outputStream;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(mOutputStream, args);
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        FileProxy proxy = new FileProxy();
        proxy.read();
        proxy.write((byte) 0x01);

        DynamicProxy dynamicProxy = new DynamicProxy(new FileOutputStream());
        OutputStream outputStream = (OutputStream) java.lang.reflect.Proxy.newProxyInstance(dynamicProxy.getClass().getClassLoader(), new
                Class[]{OutputStream.class}, dynamicProxy);
        outputStream.write((byte) 0x02);
    }
}
