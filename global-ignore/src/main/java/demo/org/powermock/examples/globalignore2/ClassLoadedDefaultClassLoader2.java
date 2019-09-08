package demo.org.powermock.examples.globalignore2;

public class ClassLoadedDefaultClassLoader2 {

    public ClassLoadedDefaultClassLoader2() {
        if (ClassLoadedDefaultClassLoader2.class.getClassLoader() != ClassLoader.getSystemClassLoader()) {
            throw new RuntimeException("this class can be loaded only by system class loader");
        }
    }

}
