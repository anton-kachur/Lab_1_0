import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaleTest {

    @Test
    void setTimeZoneTest() {
        assertEquals(Scale.setTimeZone(1), "Timezone: +1");
        assertEquals(Scale.setTimeZone(-2), "Timezone: -2");
    }
}
