package transformers;

import rules.CapitalizationRule;
import rules.ReversalRule;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversalTransformer implements IWordTransformer {


    private ReversalRule rule;

    public ReversalTransformer() {
        this.rule = new ReversalRule();
    }

    @Override
    public String transform(String word) {
        if (!rule.matches(word)) {
            return word;
        }

        char[] characters = word.toCharArray();
        String reversedWord = "";

        for (int i = characters.length - 1; i >= 0; i--) {
            reversedWord += characters[i];
        }

        return reversedWord;
    }
}
