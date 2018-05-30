/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package powermock.examples.bytebuddy.easymock;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.MockClassLoader;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SampleClass.class)
public class ByteBuddyWithPowerMockTest {
    
    @After
    public void clearPowerMockClassCacheAfterEachTest() {
        MockClassLoader mcl = (MockClassLoader) SampleClass.class.getClassLoader();
        ((Map) Whitebox.getInternalState(mcl, "classes")).clear();
    }
    
    @Test
    public void assertThatPowerMockAndByteBuddyWorksTogetherWhenCallingMockFromPowerMock() throws Exception {
        SampleClass sample = PowerMock.createMock(SampleClass.class);
        assertThat(proxy(sample).getClass().getName(), containsString("$ByteBuddy$"));
    }

    private static SampleClass proxy(SampleClass sample)
            throws IllegalAccessException, InstantiationException {
        return new ByteBuddy()
                .subclass(sample.getClass())
                .make()
                .load(sample.getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
                .getLoaded().newInstance();
    }
}