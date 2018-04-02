package com.wkp.design;

/**
 * 抽象工厂模式（对工厂方法模式的改进）
 * <p>
 *     工厂方法模式有一个问题就是，类的创建依赖工厂类，如果想要拓展程序，必须对工厂类进行修改，这违背了闭包原则；所以，从设计角度考虑，有一定的问题。
 *     而抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
 * </p>
 */
public class AbstractFactory {
    /**
     * 共同功能接口
     */
    interface Function{
        void play();
    }

    /**
     * 工厂共同生产接口
     */
    interface Provider {
        Function produce();
    }

    /**
     * LOL游戏实现功能接口
     */
    static class Lol implements Function {

        @Override
        public void play() {
            System.out.println("Summoner! Please select your hero!");
        }
    }

    /**
     * 荒野行动游戏实现功能接口
     */
    static class KnivesOut implements Function {

        @Override
        public void play() {
            System.out.println("LYB");
        }
    }

    /**
     * LOL工厂类
     */
    static class LolFactory implements Provider{

        @Override
        public Function produce() {
            return new Lol();
        }
    }

    /**
     * KNO工厂类
     */
    static class KnoFactory implements Provider{

        @Override
        public Function produce() {
            return new KnivesOut();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        LolFactory lolFactory = new LolFactory();
        lolFactory.produce().play();
        KnoFactory knoFactory = new KnoFactory();
        knoFactory.produce().play();
    }
}
