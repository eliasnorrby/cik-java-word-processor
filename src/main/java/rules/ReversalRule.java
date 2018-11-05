package rules;

import java.util.ArrayList;
import java.util.Arrays;

public class ReversalRule implements IWordRule {

    private ArrayList<String> words = new ArrayList<>(Arrays.asList(WordList.WORDS_TO_REVERSE));

    @Override
    public boolean matches(String word) {
        return words.contains(word);
    }
}
