package demo.org.powermock.examples.globalignore;


import demo.org.powermock.examples.globalignore1.ClassLoadedDefaultClassLoader1;
import demo.org.powermock.examples.globalignore2.ClassLoadedDefaultClassLoader2;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore(globalIgnore = false)
public class SkipGlobalIgnoreExampleTest {
    
    @Test
    public void should_not_throw_exception() {
        
        Throwable throwable1 = catchThrowable(new ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                new ClassLoadedDefaultClassLoader1();
            }
        });

        Throwable throwable2 = catchThrowable(new ThrowingCallable() {
            @Override
            public void call() throws Throwable {
                new ClassLoadedDefaultClassLoader2();
            }
        });

        assertThat(throwable1)
            .as("Exception is not thrown")
            .isNotNull()
            .hasMessageContaining("system class loader");

        assertThat(throwable2)
                .as("Exception is not thrown")
                .isNotNull()
                .hasMessageContaining("system class loader");
    }
    
}