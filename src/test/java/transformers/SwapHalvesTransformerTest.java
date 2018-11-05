package transformers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rules.SwapHalvesRule;

import static org.junit.jupiter.api.Assertions.*;

class SwapHalvesTransformerTest {

    SwapHalvesTransformer transformer;

    @BeforeEach
    void setUp() {
        transformer = new SwapHalvesTransformer();
    }

    @Test
    public void ShouldNotAffectWordsNotInList() {
        assertEquals("solsken", transformer.transform("solsken"));
    }

    @Test
    public void ShouldSwapHalvesOfWordsInList() {
        assertEquals("stanna", transformer.transform("nnasta"));
        assertEquals("gjort", transformer.transform("ortgj"));
    }
}