package phase1.chapter1;


import java.util.concurrent.TimeUnit;

/**
 * @classname: TryConcurrency
 * @description:
 * @author: Desire
 * @date: 2019-06-21 14:04
 */
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


    /**
     * Browse the lastest news
     */
    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh，the good news.");
            sleep(1);
        }
    }

    /**
     * Listening and enjoy the music
     */
    private static void enjoyMusic() {

        for (; ; ) {
            System.out.println("Uh-huh，the nice music.");
            sleep(1);
        }
    }


    /**
     * Simulate the wait and ignore exception
     *
     * @param seconds
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
