package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReversalRuleTest {
    ReversalRule rule;

    @BeforeEach
    void setUp() {
        this.rule = new ReversalRule();
    }

    @Test
    public void ShouldMatchWordInList() {
        assertTrue(rule.matches("räh"), "Rule did not match word 'räh'");
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
        return Stream.of(WordList.WORDS_TO_REVERSE);
    }
}