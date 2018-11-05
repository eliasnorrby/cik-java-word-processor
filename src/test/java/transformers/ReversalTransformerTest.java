package transformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rules.ReversalRule;

import static org.junit.jupiter.api.Assertions.*;

class ReversalTransformerTest {

    ReversalTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new ReversalTransformer();
    }

    @Test
    public void ShouldNotAffectWordsNotInList() {
        assertEquals("katt", transformer.transform("katt"));
    }

    @Test
    public void ShouldReverseWordsInList() {
        assertEquals("här", transformer.transform("räh"));
    }

}