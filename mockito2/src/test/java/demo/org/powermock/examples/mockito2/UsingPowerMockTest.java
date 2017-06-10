package demo.org.powermock.examples.mockito2;


import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass.class)
public class UsingPowerMockTest {
    
    @Test
    public void should_mock_static_method() {
        final String value = RandomStringUtils.randomAlphanumeric(10);
        
        mockStatic(StaticClass.class);
        
        when(StaticClass.ask()).thenReturn(value);
        
        assertThat(StaticClass.ask())
            .as("Static method is mocked")
            .isEqualTo(value);
    }
    
}