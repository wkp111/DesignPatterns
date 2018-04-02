package com.wkp.design;

/**
 * 备忘录模式
 * <p>
 *     备忘录模式的主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象。
 * </p>
 */
public class MementoDemo {
    /**
     * 备忘录类
     */
    static class Memento{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Memento(String value) {

            this.value = value;
        }
    }

    /**
     * 原始类
     */
    static class Original{
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Original(String value) {

            this.value = value;
        }

        public Memento createMemento() {
            return new Memento(value);
        }

        public void restoreMemento(Memento memento) {
            this.value = memento.value;
        }
    }

    /**
     * 备忘录存储类
     */
    static class Storage{
        private Memento mMemento;

        public Memento getMemento() {
            return mMemento;
        }

        public void setMemento(Memento memento) {
            mMemento = memento;
        }

        public Storage(Memento memento) {

            mMemento = memento;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Original original = new Original("你好");
        System.out.println("1."+original.getValue());
        Storage storage = new Storage(original.createMemento());
        original.setValue("不好");
        System.out.println("2."+original.getValue());
        original.restoreMemento(storage.getMemento());
        System.out.println("3."+original.getValue());
    }
}
