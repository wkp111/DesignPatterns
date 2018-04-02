package com.wkp.design;

/**
 * 责任链模式
 * <p>
 *      责任链模式：有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一对象决定处理该请求。
 *      但是发出者并不清楚到底最终哪个对象会处理该请求，所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整。
 * </p>
 */
public class ChainResponse {
    /**
     * 功能接口
     */
    interface Chain{
        void operate();
    }

    /**
     * 加工类
     */
    static class AbstractChain{
        private Chain mChain;

        public Chain getChain() {
            return mChain;
        }

        public void setChain(Chain chain) {
            mChain = chain;
        }
    }

    /**
     * 实现类
     */
    static class ManageChain extends AbstractChain implements Chain{
        private String mName;

        public ManageChain(String name) {
            mName = name;
        }

        @Override
        public void operate() {
            System.out.println("Hello "+mName);
            if (getChain() != null) {
                getChain().operate();
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        ManageChain chain1 = new ManageChain("Chain1");
        ManageChain chain2 = new ManageChain("Chain2");
        ManageChain chain3 = new ManageChain("Chain3");

        chain1.setChain(chain2);
        chain2.setChain(chain3);

        chain1.operate();
    }
}
