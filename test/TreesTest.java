import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class TreesTest {
    private Trees test = new Trees("Thuringen Wald", "Forest");

    @BeforeEach
    public void setUp() {
        test = mock(Trees.class);
        when(test.printAll()).thenReturn("Name: Thuringen Wald\nType: Forest");

    }

    @Test
    void printAll() {
        assertEquals("Name: Thuringen Wald\nType: Forest", test.printAll());
        verify(test, atLeastOnce()).printAll();
    }
}