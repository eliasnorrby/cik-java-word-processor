package transformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutionTransformerTest {

    SubstitutionTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new SubstitutionTransformer();
    }

    @Test
    public void ShouldNotAffectWordsNotInList() {
        assertEquals("konsult", transformer.transform("konsult"));
    }

    @Test
    public void ShouldSubstituteWordsInList() {
        assertEquals("motstånd", transformer.transform("äppelkaka"));
    }

}