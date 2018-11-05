import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordProcessorTest {

    WordProcessor wp;

    @BeforeEach
    void setUp() {
        wp = new WordProcessor();
    }

    @Test
    public void ShouldCapitalizeWords() {
        assertEquals("Om", wp.processText("om"));
    }

    @Test
    public void ShouldReverseWords() {
        assertEquals("kommer", wp.processText("remmok"));
    }

    @Test
    public void ShouldSubstituteWords() {
        assertEquals("Forefront", wp.processText("företaget"));
    }

    @Test
    public void ShouldSwapHalvesOfWords() {
        assertEquals("stanna", wp.processText("nnasta"));
    }

    @Test
    public void ShouldProcesssMultipleWords() {
        assertEquals("stanna här", wp.processText("nnasta räh"));
    }

    @Test
    public void ShouldNotProcessSpecialCharacters() {
        assertEquals("solsken.", wp.processText("solsken."));
        assertEquals("Om!", wp.processText("om!"));
    }

    @Test
    public void ShouldRetainPlacementOfSpecialCharacter() {
        assertEquals("Om!", wp.processText("om!"));
        assertEquals("kommer?", wp.processText("remmok?"));
    }

    @Test
    public void ShouldTrowExceptionOnMultipleSpecialCharacters() {
        assertThrows(TooManySpecialCharactersException.class, () -> wp.processWord("!Hej!"));
    }

    @Test
    public void ShouldTransformDemoText() {
        String demoText = "Företaget är räh för att nnasta. Med stöd av alla frontiers remmok eernatrain mosa inget " +
                "äppelkaka. om två år remmok företaget förpestas när eernatrain ortgj klart utbildningen Code is king!";
        System.out.println("Before transform:");
        System.out.println(demoText);

        String transformedText = wp.processText(demoText);
        System.out.println("After transform:");
        System.out.println(transformedText);
    }


}