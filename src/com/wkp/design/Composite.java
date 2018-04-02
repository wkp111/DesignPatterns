package com.wkp.design;

/**
 * 组合模式
 * <p>
 *     组合模式有时又叫 部分-整体 模式，在处理类似树形结构的问题时比较方便。
 * </p>
 */
public class Composite {
    /**
     * 外部整体类
     * @param <T>
     */
    static class Tree<T>{
        private TreeNode<T> root;
        private TreeNode<T> point;
        private int size;

        public void add(T data) {
            TreeNode<T> node = new TreeNode<>(data);
            if (root == null) {
                root = node;
                point = node;
            }else {
                point.add(node);
                point = node;
            }
            size++;
        }

        public boolean remove(T data) {
            TreeNode<T> temp = root;
            while (temp != null) {
                if (temp.data == data) {
                    if (temp.equals(root)) {
                        root = temp.next;
                    }
                    temp.remove();
                    size--;
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public int size() {
            return size;
        }

        public void print() {
            TreeNode<T> temp = root;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }

        /**
         * 内部节点类
         * @param <T>
         */
        static class TreeNode<T>{
            private T data;
            private TreeNode<T> pre;
            private TreeNode<T> next;

            private TreeNode(T data) {
                this.data = data;
            }

            private void add(TreeNode node) {
                next = node;
                node.pre = this;
            }

            private void remove() {
                if (pre != null) {
                    pre.next = next;
                }
                if (next != null) {
                    next.pre = pre;
                }
                pre = null;
                next = null;
                data = null;
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();
        boolean a = tree.remove("a");
        System.out.println(a);
        System.out.println(tree.size());
        tree.add("a");
        tree.add("b");
        tree.add("c");
        tree.add("d");
        tree.print();
        System.out.println(tree.size());
        tree.remove("a");
        tree.remove("c");
        tree.print();
        System.out.println(tree.size());
    }
}
