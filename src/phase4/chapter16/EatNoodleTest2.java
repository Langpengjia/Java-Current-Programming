package phase4.chapter16;

/**
 * @classname: EatNoodleTest2
 * @description: 避免死锁
 * @author: Desire
 * @date: 2019-08-08 10:55
 */
public class EatNoodleTest2 extends Thread {

    private final String name;
    private final TablewarePair tablewarePair;

    public EatNoodleTest2(String name, TablewarePair tablewarePair) {
        this.name = name;
        this.tablewarePair = tablewarePair;
    }

    @Override
    public void run() {
        while (true) {
            this.eat();
        }
    }

    private void eat() {
        synchronized (tablewarePair) {
            System.out.println(name + " take up " + tablewarePair.getLeftTool() + "(left)");
            System.out.println(name + " take up " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " is eating now.");
            System.out.println(name + " put down " + tablewarePair.getRightTool() + "(right)");
            System.out.println(name + " put down " + tablewarePair.getLeftTool() + "(left)");
        }
    }


    public static void main(String [] args){
        TablewarePair tablewarePair = new TablewarePair(new Tableware("fork"),
                new Tableware("knife"));
        new EatNoodleTest2("A",tablewarePair).start();
        new EatNoodleTest2("B",tablewarePair).start();


    }
}
