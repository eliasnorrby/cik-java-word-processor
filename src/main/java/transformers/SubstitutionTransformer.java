package transformers;

import rules.SubstitutionRule;

public class SubstitutionTransformer implements IWordTransformer {

    SubstitutionRule rule;

    public SubstitutionTransformer() {
        rule = new SubstitutionRule();
    }

    @Override
    public String transform(String word) {
        if (!rule.matches(word)) {
            return word;
        }

        return rule.substitute(word);

    }
}
