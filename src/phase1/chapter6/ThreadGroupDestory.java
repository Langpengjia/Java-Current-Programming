package phase1.chapter6;

public class ThreadGroupDestory {

    public static void main(String [] args){
        ThreadGroup group = new ThreadGroup("TestGroup");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("group.isDestroyed = "+group.isDestroyed());

        mainGroup.list();
        group.destroy();

        System.out.println("group.isDestroyed = "+group.isDestroyed());
        mainGroup.list();

    }

}
