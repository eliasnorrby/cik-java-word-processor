package rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstitutionRuleTest {

    SubstitutionRule rule;

    @BeforeEach
    void setUp() {
        rule = new SubstitutionRule();
    }

    @Test
    public void ShouldMatchWordInList() {
        assertTrue(rule.matches("företaget"), "Rule did not match word 'företaget'");
    }

    @Test
    public void ShouldNotMatchWordNotInList() {
        assertFalse(rule.matches("kantarell"));
    }

    @Test
    public void ShouldContainSubstitutionForMatchingWord() {
        assertEquals("Forefront", rule.substitute("företaget") );
    }
}