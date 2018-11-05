package rules;

import java.util.HashMap;

public class WordList {
    public static final String[] WORDS_TO_CAPITALIZE = {
            "om",
            "king",
            "frontiers"
    };

    public static final String[] WORDS_TO_REVERSE = {
            "räh",
            "remmok"
    };

    public static final String[] WORDS_TO_SWAPHALVES = {
            "nnasta",
            "eernatrain",
            "ortgj"
    };

    public static final HashMap<String, String> WORDS_TO_SUBSTITUTE = new HashMap<>() {
        {
            put("företaget", "Forefront");
            put("förpestas", "förgyllas");
            put("inget", "allt");
            put("äppelkaka", "motstånd");
        }

    };
}
