package com.wkp.design;

/**
 * 解释器模式
 * <p>
 *     解释器模式一般主要应用在OOP开发中的编译器的开发中。
 * </p>
 */
public class Interpreter {
    /**
     * 上下文
     */
    static class Context{
        private int num1;
        private int num2;

        public int getNum1() {
            return num1;
        }

        public void setNum1(int num1) {
            this.num1 = num1;
        }

        public int getNum2() {
            return num2;
        }

        public void setNum2(int num2) {
            this.num2 = num2;
        }

        public Context(int num1, int num2) {

            this.num1 = num1;
            this.num2 = num2;
        }
    }

    /**
     * 表达式接口
     */
    interface Expression{
        int interpret(Context context);
    }

    /**
     * 加法解释器
     */
    static class Plus implements Expression{

        @Override
        public int interpret(Context context) {
            return context.getNum1() + context.getNum2();
        }
    }

    /**
     * 减法解释器
     */
    static class Minus implements Expression{

        @Override
        public int interpret(Context context) {
            return context.getNum1() - context.getNum2();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        //998-668+1080
        int interpret = new Plus().interpret(new Context(new Minus().interpret(new Context(998, 668)), 1080));
        System.out.println(interpret);
    }
}
