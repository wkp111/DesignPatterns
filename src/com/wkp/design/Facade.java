package com.wkp.design;

/**
 * 外观模式
 * <p>
 *     外观模式是为了解决类与类之间的依赖关系，像spring一样，可以将类和类之间的关系配置到配置文件中，
 *     而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度，该模式中没有涉及到接口。
 * </p>
 */
public class Facade {

    static class First{
        String start() {
            System.out.println("Start game");
            return "ready";
        }
    }

    static class Second{
        void ready(String str){
            System.out.println("Init has completed:" + str);
        }
    }

    static class Third{
        void play() {
            System.out.println("Come on!");
        }
    }

    /**
     * 外观包装类
     */
    static class FacadeClass{
        private First mFirst;
        private Second mSecond;
        private Third mThird;

        public FacadeClass() {
            mFirst = new First();
            mSecond = new Second();
            mThird = new Third();
        }

        public void playGame() {
            String start = mFirst.start();
            mSecond.ready(start);
            mThird.play();
        }
    }

    /**
     * 测试 客户使用
     * @param args
     */
    public static void main(String[] args) {
        FacadeClass facadeClass = new FacadeClass();
        facadeClass.playGame();
    }
}
