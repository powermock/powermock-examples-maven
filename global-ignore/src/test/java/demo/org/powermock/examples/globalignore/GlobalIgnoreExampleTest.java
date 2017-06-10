package demo.org.powermock.examples.globalignore;


import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(PowerMockRunner.class)
public class GlobalIgnoreExampleTest {
    
    @Test
    public void should_not_throw_exception() {
        
        Throwable throwable = catchThrowable(new ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                new ClassLoadedDefaultClassLoader();
            }
        });
        
        assertThat(throwable)
            .as("Exception is not thrown")
            .isNull();
    }
    
}