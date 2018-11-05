package rules;

import java.util.Map;

public class SubstitutionRule implements IWordRule {

    Map<String, String> words = WordList.WORDS_TO_SUBSTITUTE;

    @Override
    public boolean matches(String word) {
        return words.containsKey(word);
    }

    public String substitute(String word) {
        return words.get(word);
    }
}
