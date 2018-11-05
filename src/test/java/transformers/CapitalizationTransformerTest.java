package transformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizationTransformerTest {

    CapitalizationTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new CapitalizationTransformer();
    }

    @Test
    public void ShouldCapitalizeWordInList() {
        assertEquals("Om", transformer.transform("om"));
    }

    @Test
    public void ShouldNotCapitalizeWordNotInList() {
        assertEquals("cat", transformer.transform("cat"));
    }
}