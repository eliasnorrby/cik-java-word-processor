import transformers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessor {

    private ArrayList<IWordTransformer> transformers;

    public WordProcessor() {
        transformers = new ArrayList<>() {
            {
                add(new CapitalizationTransformer());
                add(new ReversalTransformer());
                add(new SubstitutionTransformer());
                add(new SwapHalvesTransformer());
            }
        };
    }

    public String processText(String text) {

        String[] words = text.split(" ");

        try {
            for (int i = 0; i < words.length; i++) {
                words[i] = processWord(words[i]);
            }
        } catch (TooManySpecialCharactersException e) {
            e.printStackTrace();
        }

        return String.join(" ", words);
    }

    public String processWord(String word) throws TooManySpecialCharactersException {
//        String processedWord;
//        transformers.forEach(tr -> processedWord = tr.transform(word));

        String patternString = "[^A-Za-zÅÄÖåäö0-9]";
        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(word);

        boolean hasSpecialCharacter = matcher.find();

        String specialCharacter = "";
        if (hasSpecialCharacter) {
            specialCharacter = word.substring(word.length() - 1);
            word = word.substring(0, word.length() - 1);
        }

        matcher = pattern.matcher(word);

        boolean stillHasSpecialCharacters = matcher.find();

        if (stillHasSpecialCharacters) {
            throw new TooManySpecialCharactersException();
        }

        for (IWordTransformer tr : transformers) {
            word = tr.transform(word);
        }

        return word + specialCharacter;
    }
}