package com.wkp.design;

/**
 * 迭代器模式
 * <p>
 *     迭代器模式就是顺序访问聚集中的对象，这句话包含两层意思：一是需要遍历的对象，即聚集对象，二是迭代器对象，用于对聚集对象进行遍历访问。
 * </p>
 */
public class IteratorDemo {
    /**
     * 迭代器接口
     */
    interface Iterator{
        Object pre();

        Object next();

        boolean hasNext();

        Object first();
    }

    /**
     * 集合接口
     */
    interface Collection{
        Iterator iterator();

        Object get(int i);

        int size();
    }

    /**
     * 迭代器实现类
     */
    static class IteratorImpl implements Iterator{

        private Collection mCollection;
        private int pos = -1;

        public IteratorImpl(Collection collection) {
            mCollection = collection;
        }

        @Override
        public Object pre() {
            if (pos > 0) {
                pos--;
            }
            return mCollection.get(pos);
        }

        @Override
        public Object next() {
            if (pos < mCollection.size() - 1) {
                pos++;
            }
            return mCollection.get(pos);
        }

        @Override
        public boolean hasNext() {
            return pos < mCollection.size() - 1;
        }

        @Override
        public Object first() {
            pos = 0;
            return mCollection.get(pos);
        }
    }

    /**
     * 集合实现类
     */
    static class CollectionImpl implements Collection{

        public String[] mStrings = {"a", "b", "c", "d", "e", "f", "g"};

        @Override
        public Iterator iterator() {
            return new IteratorImpl(this);
        }

        @Override
        public Object get(int i) {
            return mStrings[i];
        }

        @Override
        public int size() {
            return mStrings.length;
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Collection collection = new CollectionImpl();
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
