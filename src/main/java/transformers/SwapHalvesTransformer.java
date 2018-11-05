package transformers;

import rules.SwapHalvesRule;

public class SwapHalvesTransformer implements IWordTransformer {

    SwapHalvesRule rule;

    public SwapHalvesTransformer() {
        rule = new SwapHalvesRule();
    }

    @Override
    public String transform(String word) {
        if (!rule.matches(word)) {
            return word;
        }

        int midPoint = (int) Math.ceil((double) word.length() / 2);

        return word.substring(midPoint) + word.substring(0, midPoint);
    }
}
