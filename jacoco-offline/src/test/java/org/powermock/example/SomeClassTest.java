package org.powermock.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.doCallRealMethod;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Configuration.class, Lamda.class})
public class SomeClassTest {

    @Before
    public void setUp() throws Exception {
        Whitebox.setInternalState(Configuration.class, "enabled", (Object) null);
    }

    @Test
    public void shouldReturnSumIfEnabled() throws Exception {
        mockStatic(Configuration.class);

        Properties properties = new Properties();
        properties.put("enabled", "true");

        doReturn(properties).when(Configuration.class, "readProperties");
        doCallRealMethod().when(Configuration.class, "isEnabled");
        doCallRealMethod().when(Configuration.class, "loadFromProperties");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(6);
    }

    @Test
    public void shouldReturnZeroIfDisabled() throws Exception {
        mockStatic(Configuration.class);

        Properties properties = new Properties();
        properties.put("enabled", "false");

        doReturn(properties).when(Configuration.class, "readProperties");
        doCallRealMethod().when(Configuration.class, "isEnabled");
        doCallRealMethod().when(Configuration.class, "loadFromProperties");

        assertThat(new SomeClass().add(1, 5)).isEqualTo(0);
    }

    @Test(expected = RuntimeException.class)
    public void shouldC() {
        mockStatic(Lamda.class);
        when(Lamda.capitalize(Mockito.anyString())).thenReturn("01234567890");

        ArrayList<String> in = new ArrayList<>();

        in.add("----");
        in.add(null);

        new Lamda().validate(in);
    }
}