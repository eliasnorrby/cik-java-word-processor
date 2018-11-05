package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SwapHalvesRuleTest {

    SwapHalvesRule rule;

    @BeforeEach
    void setUp() {
        rule = new SwapHalvesRule();
    }

    @Test
    public void ShouldMatchWordInList() {
        String wordToMatch = "nnasta";
        assertTrue(rule.matches(wordToMatch), "Rule did not match word " + wordToMatch);
    }

    @Test
    public void ShouldNotMatchWordNotInList() {
        assertFalse(rule.matches("cat"));
    }

    @ParameterizedTest
    @MethodSource("wordProvider")
    public void ThoroughWordMatcher(String word) {
        assertTrue(rule.matches(word));
    }

    private static Stream<String> wordProvider() {
        return Stream.of(WordList.WORDS_TO_SWAPHALVES);
    }
}