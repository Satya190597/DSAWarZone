class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split sentences into arrays of words, determining the shorter and longer sentence
        String[] minimumArrayOfWords;
        String[] maximumArrayOfWords;
        if (sentence1.length() < sentence2.length()) {
            minimumArrayOfWords = sentence1.split(" ");
            maximumArrayOfWords = sentence2.split(" ");
        } else {
            minimumArrayOfWords = sentence2.split(" ");
            maximumArrayOfWords = sentence1.split(" ");
        }

        int start = 0; // Pointer for the beginning of the minimum array
        int end = minimumArrayOfWords.length - 1; // Pointer for the end of the minimum array
        
        // Check for matching prefix in the maximum array
        for (int i = 0; i < maximumArrayOfWords.length; i++) {
            // Break if we've matched all words in the minimum array
            if (start >= minimumArrayOfWords.length) break;

            // If words match, move the start pointer forward
            if (minimumArrayOfWords[start].equals(maximumArrayOfWords[i])) {
                start++;
                continue;
            }
            break; // Stop if there's no match
        }
        
        // Check for matching suffix in the maximum array
        for (int i = maximumArrayOfWords.length - 1; i > 0; i--) {
            // Break if we've matched all words in the minimum array
            if (end < 0) break;

            // If words match, move the end pointer backward
            if (minimumArrayOfWords[end].equals(maximumArrayOfWords[i])) {
                end--;
                continue;
            }
            break; // Stop if there's no match
        }
        
        // Return true if all words from the minimum array are matched in the maximum array
        return end < start;
    }
}
