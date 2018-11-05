package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CapitalizationRuleTest {
    CapitalizationRule rule;

    @BeforeEach
    void setUp() {
        this.rule = new CapitalizationRule();
    }

    @Test
    public void ShouldMatchWordInList() {
        assertTrue(rule.matches("om"), "Rule did not match word 'om'");
    }

    @Test
    public void ShouldNotMatchWordNotInList() {
        assertFalse(rule.matches("solen"));
    }

    @ParameterizedTest
    @MethodSource("wordProvider")
    public void ThoroughWordMatcher(String word) {
        assertTrue(rule.matches(word), "Rule did not match '" + word + "'");
    }

    private static Stream<String> wordProvider() {
        return Stream.of(WordList.WORDS_TO_CAPITALIZE);
    }
}