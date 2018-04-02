package com.wkp.design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;

/**
 * 享元模式
 * <p>
 *     享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销，通常与工厂模式一起使用。
 * </p>
 */
public class Flyweight {
    /**
     * 连接池
     */
    static class ConnectionPool{
        private Vector<Connection> mPool;
        private String url = "jdbc:mysql://localhost:3306/test";
        private String driverClassName = "com.mysql.jdbc.Driver";
        private String account = "root";
        private String password = "123456";
        private int poolSize = 50;
        private Connection con;

        public ConnectionPool() {
            mPool = new Vector<>();
            for (int i = 0; i < poolSize; i++) {
                try {
                    Class.forName(driverClassName);
                    Connection connection = DriverManager.getConnection(url, account, password);
                    mPool.add(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void release() {
            mPool.add(con);
            con = null;
        }

        public synchronized Connection getConnection() {
            if (mPool.size() > 0) {
                con = mPool.get(0);
                mPool.remove(con);
                return con;
            }
            return null;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();
        Connection connection = pool.getConnection();
        System.out.println(connection);
    }
}
