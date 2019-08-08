package phase4.chapter16;

/**
 * @classname: EatNoodleThread
 * @description:
 * @author: Desire
 * @date: 2019-08-08 10:17
 */
public class EatNoodleThread extends Thread {

    private final String name;
    //餐具
    private final Tableware leftTool;

    private final Tableware rightTool;

    public EatNoodleThread(String name, Tableware leftTool, Tableware rightTool) {
        this.name = name;
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }


    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (leftTool) {
            System.out.println(name + " take up " + leftTool + " (left)");
            synchronized (rightTool) {
                System.out.println(name + " take up " + rightTool + " (right)");
                System.out.println(name + " is eating now .");
                System.out.println(name + " put down " + rightTool + " (right)");
            }
        }
        System.out.println(name + " put down " + leftTool + " (left)");
    }


    public static void main(String [] args){
        Tableware fork = new Tableware("fork");
        Tableware knife = new Tableware("knife");
        new EatNoodleThread("A",fork,knife).start();
        new EatNoodleThread("B",knife,fork).start();


    }

}
