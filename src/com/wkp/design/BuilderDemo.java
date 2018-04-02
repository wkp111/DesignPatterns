package com.wkp.design;

/**
 * 建造者模式
 * <p>
 *     建造者模式是将各种产品集中起来进行管理，用来创建复合对象。
 * </p>
 */
public class BuilderDemo {

    static class Color{
    }

    static class Context{
    }

    protected static class DialogController{
        Color mColor;
        Context mContext;
    }

    /**
     * 目标类
     */
    static class Dialog{
        private Context mContext;
        private Color mColor;
        protected Dialog(Context context) {
            mContext = context;
        }

        public void setColor(Color color) {
            mColor = color;
        }

        public void show() {
            System.out.println("Dialog show!");
        }

        /**
         * 建造者类
         */
        static class Builder{
            private DialogController mDialogController = null;

            public Builder(Context context) {
                mDialogController = new DialogController();
                mDialogController.mContext = context;
            }

            public Builder setColor(Color color) {
                mDialogController.mColor = color;
                return this;
            }

            public Dialog build() {
                Dialog dialog = new Dialog(mDialogController.mContext);
                if (mDialogController.mColor != null) {
                    dialog.setColor(mDialogController.mColor);
                }
                return dialog;
            }
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Dialog dialog = new Dialog.Builder(new Context())
                .setColor(new Color())
                .build();
        dialog.show();
    }
}
