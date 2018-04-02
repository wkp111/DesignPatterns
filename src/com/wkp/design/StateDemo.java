package com.wkp.design;

/**
 * 状态模式
 * <p>
 *     核心思想就是：当对象的状态改变时，同时改变其行为。
 * </p>
 */
public class StateDemo {
    /**
     * 状态类
     */
    static class State{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void method1() {
            System.out.println("state1 do something");
        }

        public void method2() {
            System.out.println("state2 do something");
        }
    }

    /**
     * 状态行为切换类
     */
    static class Context{
        private State mState;

        public State getState() {
            return mState;
        }

        public void setState(State state) {
            mState = state;
        }

        public Context(State state) {

            mState = state;
        }

        public void method() {
            switch (mState.value) {
                case "state1":
                    mState.method1();
                    break;
                case "state2":
                    mState.method2();
                    break;
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        State state = new State();
        Context context = new Context(state);
        state.setValue("state1");
        context.method();
        state.setValue("state2");
        context.method();
    }
}
