package phase1.chapter1;


import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    public static void main(String[] args) {
        main2();
    }

    public static void main1() {
        browseNews();
        enjoyMusic();
    }

    public static void main2() {
        new Thread(() -> enjoyMusic()).start();
        browseNews();
    }


    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh，the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {

        for (; ; ) {
            System.out.println("Uh-huh，the nice music.");
            sleep(1);
        }
    }


    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
