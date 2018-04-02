package com.wkp.design;

/**
 * 访问者模式
 * <p>
 *     访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化。访问者模式适用于数据结构相对稳定算法又易变化的系统。
 *     因为访问者模式使得算法操作增加变得容易。若系统数据结构对象易于变化，经常有新的数据对象增加进来，则不适合使用访问者模式。
 *     访问者模式的优点是增加操作很容易，因为增加操作意味着增加新的访问者。
 *     访问者模式将有关行为集中到一个访问者对象中，其改变不影响系统数据结构。其缺点就是增加新的数据结构很困难。
 * </p>
 */
public class VisitorDemo {
    /**
     * 访问者接口
     */
    interface Visitor{
        void visit(Subject subject);
    }

    /**
     * 被访问者
     */
    interface Subject{
        void accept(Visitor visitor);

        String getSubject();
    }

    /**
     * 访问者实现类
     */
    static class VisitorImpl implements Visitor{

        @Override
        public void visit(Subject subject) {
            System.out.println(subject.getSubject());
        }
    }

    /**
     * 被访问者实现类
     */
    static class SubjectImpl implements Subject{
        private String value;

        public SubjectImpl(String value) {
            this.value = value;
        }

        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override
        public String getSubject() {
            return value;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Visitor visitor = new VisitorImpl();
        Subject subject = new SubjectImpl("Hello Visitor");
        subject.accept(visitor);
    }
}
