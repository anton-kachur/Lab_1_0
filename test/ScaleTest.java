import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import javax.lang.model.element.PackageElement;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ScaleTest {

    @Test
    void setTimeZone() {
        Scale test = mock(Scale.class);
        when(test.setTimeZone(1)).thenReturn("Timezone: +1");
        when(test.setTimeZone(-2)).thenReturn("Timezone: -2");



        assertEquals(Scale.setTimeZone(1), "Timezone: +1");
        assertEquals(Scale.setTimeZone(-2), "Timezone: -2");
        verify(test).setTimeZone(1);
        verify(test).setTimeZone(-2);
    }
}