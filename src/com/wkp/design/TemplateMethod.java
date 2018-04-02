package com.wkp.design;

/**
 * 模板方法模式
 * <p>
 *      模板方法模式主要是创建一个抽象类，其中包含模板方法（主方法），而类中其他方法均由主方法调配，子类可以根据自己的特性重写其他方法，从而达到需求。
 * </p>
 */
public class TemplateMethod {
    /**
     * 模板类
     */
    static abstract class AbstractCalculator {

        /*主方法，实现对本类其它方法的调用*/
        public final int calculate(String exp,String opt){
            int array[] = split(exp,opt);
            return calculate(array[0],array[1]);
        }

        /*被子类重写的方法*/
        abstract public int calculate(int num1,int num2);

        public int[] split(String exp,String opt){
            String array[] = exp.split(opt);
            int arrayInt[] = new int[2];
            arrayInt[0] = Integer.parseInt(array[0]);
            arrayInt[1] = Integer.parseInt(array[1]);
            return arrayInt;
        }
    }

    /**
     * 实现类 加法运算
     */
    static class Plus extends AbstractCalculator {

        @Override
        public int calculate(int num1,int num2) {
            return num1 + num2;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        AbstractCalculator calculator = new Plus();
        int calculate = calculator.calculate("998+98", "\\+");
        System.out.println(calculate);
    }
}
