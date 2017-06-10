package demo.org.powermock.examples.mockito2;


public final class FinalClass {
    
    public String ask(){
        return "I'm Final class";
    }
    
    public final void say(String name){
        throw new RuntimeException("Hi " + name);
    }
    
}
