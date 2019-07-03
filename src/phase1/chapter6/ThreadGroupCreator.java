package phase1.chapter6;

/**
 * @classname: ThreadGroupCreator
 * @description:
 * @author: Desire
 * @date: 2019-07-03 9:45
 */
public class ThreadGroupCreator {

    public static void main(String [] args){

        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("Group1");

        System.out.println(group1.getParent() == currentGroup);

        ThreadGroup group2 = new ThreadGroup(group1,"Group2");

        System.out.println(group2.getParent() == group1);


    }


}
