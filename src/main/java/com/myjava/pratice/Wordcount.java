package com.myjava.pratice;

/**
 * this class gives a word length
 */
public class Wordcount {
    private final String Space=" ";

    /**
     *
     * @param inputSentence it is string
     * @return counter
     */
    public int count(String inputSentence) {
        int counter = 0;
        if (inputSentence!=(null)) {
            String[] words = inputSentence.split(Space);
            for (String word : words) {
                if (!word.equals("")) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
