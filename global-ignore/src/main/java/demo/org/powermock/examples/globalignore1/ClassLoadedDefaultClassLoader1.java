package demo.org.powermock.examples.globalignore1;

public class ClassLoadedDefaultClassLoader1 {
    
    public ClassLoadedDefaultClassLoader1(){
        if (ClassLoadedDefaultClassLoader1.class.getClassLoader() != ClassLoader.getSystemClassLoader()){
            throw new RuntimeException("this class can be loaded only by system class loader");
        }
    }
    
}
