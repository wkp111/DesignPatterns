package com.wkp.design;

/**
 * 策略模式
 * <p>
 *     策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互替换，且算法的变化不会影响到使用算法的客户。
 *     策略模式的决定权在用户，系统本身提供不同算法的实现，新增或者删除算法，对各种算法做封装。
 *     策略模式多用在算法决策系统中，外部用户只需要决定用哪个算法即可
 * </p>
 */
public class Strategy {
    /**
     * 计算接口
     */
    interface ICalculator{
        int calculate(String expression);
    }

    /**
     * 辅助计算类
     */
    static abstract class Assist{
        protected int[] split(String exp, String regex) {
            String[] split = exp.split(regex);
            int[] ints = new int[2];
            ints[0] = Integer.parseInt(split[0]);
            ints[1] = Integer.parseInt(split[1]);
            return ints;
        }
    }

    /**
     * 加法运算
     */
    static class Plus extends Assist implements ICalculator{

        @Override
        public int calculate(String expression) {
            int[] ints = split(expression, "\\+");
            return ints[0] + ints[1];
        }
    }

    /**
     * 减法运算
     */
    static class Minus extends Assist implements ICalculator{

        @Override
        public int calculate(String expression) {
            int[] ints = split(expression, "-");
            return ints[0] - ints[1];
        }
    }

    /**
     * 乘法运算
     */
    static class Multiply extends Assist implements ICalculator{

        @Override
        public int calculate(String expression) {
            int[] ints = split(expression, "\\*");
            return ints[0] * ints[1];
        }
    }

    /**
     * 除法运算
     */
    static class Division extends Assist implements ICalculator{

        @Override
        public int calculate(String expression) {
            int[] ints = split(expression, "\\/");
            return ints[0] / ints[1];
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Plus().calculate("10+20"));
        System.out.println(new Minus().calculate("100-55"));
        System.out.println(new Multiply().calculate("11*22"));
        System.out.println(new Division().calculate("999/67"));
    }
}
