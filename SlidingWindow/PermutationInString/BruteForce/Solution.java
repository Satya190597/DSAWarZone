class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Get the lengths of both strings
        int sizeOfFirstString = s1.length();
        int sizeOfSecondString = s2.length();

        // If s2 is shorter than s1, s1's permutation can't be in s2
        if (sizeOfSecondString < sizeOfFirstString)
            return false;

        // Create an array to count the frequency of each character in s1
        int[] frequencyArrayOfS1 = new int[26];
        for (int i = 0; i < sizeOfFirstString; i++) {
            // Increment the count for the character in s1
            frequencyArrayOfS1[s1.charAt(i) - 'a']++;
        }

        // Iterate through all possible substrings of s2 of the same length as s1
        for (int i = 0; i <= sizeOfSecondString - sizeOfFirstString; i++) {
            // Create a temporary frequency array for the current substring of s2
            int[] tempFrequencyArray = new int[26];
            for (int j = i; j < i + sizeOfFirstString; j++) {
                // Increment the count for the characters in the current window of s2
                tempFrequencyArray[s2.charAt(j) - 'a']++;
            }
            // Check if the current window matches the frequency of s1
            if (isMatch(frequencyArrayOfS1, tempFrequencyArray))
                return true; // A match is found
        }

        // If no matching substring is found, return false
        return false;
    }

    // Helper function to compare two frequency arrays
    public boolean isMatch(int[] frequencyArrayOne, int[] frequencyArrayTwo) {
        for (int i = 0; i < frequencyArrayOne.length; i++) {
            // If any character frequency doesn't match, return false
            if (frequencyArrayOne[i] != frequencyArrayTwo[i])
                return false;
        }
        return true; // All character frequencies match
    }
}