package phase2.chapter10;

import java.io.ByteArrayOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @classname: MyClassLoader
 * @description:   custom Classloader
 * @author: Desire
 * @date: 2019-08-06 15:01
 */
public class MyClassLoader extends ClassLoader {

    private final static Path DEFAULT_CLASS_DIR = Paths.get("F:", "classloader");

    private final Path classDir;

    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(String classDir) {
        super();
        this.classDir = Paths.get(classDir);
    }

    public MyClassLoader(ClassLoader parent, Path classDir) {
        super(parent);
        this.classDir = classDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classBytes = this.readClassBytes(name);
        if(null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException("The class " + name + " not found");
        }

        return this.defineClass(name,classBytes,0,classBytes.length);
    }


    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classpath = name.replace(".", "/");
        Path classFillPath = classDir.resolve(Paths.get(classpath + ".class"));
        if (!classFillPath.toFile().exists()) {
            throw new ClassNotFoundException("The class " + name + " not found");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFillPath, baos);
            return baos.toByteArray();
        } catch (Exception e) {
            throw new ClassNotFoundException("The class " + name + " not found");
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }


}
