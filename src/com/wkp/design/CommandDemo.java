package com.wkp.design;

/**
 * 命令模式
 * <p>
 *      命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开。
 * </p>
 */
public class CommandDemo {
    /**
     * 命令接口
     */
    interface Command{
        void exe();
    }

    /**
     * 命令发出者
     */
    static class Invoker{
        private Command mCommand;

        public Invoker(Command command) {
            mCommand = command;
        }

        public void action() {
            mCommand.exe();
        }
    }

    /**
     * 命令执行者
     */
    static class Receiver{
        public void action() {
            System.out.println("command start");
        }
    }

    /**
     * 命令实现类
     */
    static class CommandImpl implements Command{
        private Receiver mReceiver;

        public CommandImpl(Receiver receiver) {
            mReceiver = receiver;
        }

        @Override
        public void exe() {
            mReceiver.action();
        }
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new CommandImpl(new Receiver()));
        invoker.action();
    }

}
