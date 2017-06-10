package demo.org.powermock.examples.globalignore;

public class ClassLoadedDefaultClassLoader {
    
    public ClassLoadedDefaultClassLoader(){
        if (ClassLoadedDefaultClassLoader.class.getClassLoader() != ClassLoader.getSystemClassLoader()){
            throw new RuntimeException("this class can be loaded only by system class loader");
        }
    }
    
}
