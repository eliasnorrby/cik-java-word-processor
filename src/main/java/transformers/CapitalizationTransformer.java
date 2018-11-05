package transformers;

import rules.CapitalizationRule;

public class CapitalizationTransformer implements IWordTransformer {

    private CapitalizationRule rule;

    public CapitalizationTransformer() {
        rule = new CapitalizationRule();
    }

    @Override
    public String transform(String word) {
        if (!rule.matches(word))
            return word;

        return word.substring(0,1).toUpperCase() + word.substring(1);
    }
}
