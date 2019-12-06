package phase1.chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PreventDuplicated {

    private final static String LOCK_PATH = "D:/";

    private final static String LOCK_FILE = "1.txt";

    private final static String PERMISSION = "rw-------";

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program recieved kill SIGNAL");
            getLockFile().toFile().delete();
        }));
        checkRunning();
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("program is running.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private static void checkRunning() throws IOException {
        Path path = getLockFile();
        if (path.toFile().exists()) {
            throw new RuntimeException("The program already running");
        }
        //linux下才会涉及到权限分配
//        Set<PosixFilePermission> perms = PosixFilePermissions.fromString(PERMISSION);
//        Files.createFile(path, PosixFilePermissions.asFileAttribute(perms));
        //因为本人是windows系统
        Files.createFile(path);
    }

    private static Path getLockFile() {
        return Paths.get(LOCK_PATH, LOCK_FILE);
    }
}
