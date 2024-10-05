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

        // Create a temporary frequency array for the first window in s2
        int[] tempFrequencyArray = new int[26];
        for (int i = 0; i < sizeOfFirstString; i++) {
            // Increment the count for the character in the initial window of s2
            tempFrequencyArray[s2.charAt(i) - 'a']++;
        }

        // Check if the first window matches the frequency of s1
        if (isMatch(frequencyArrayOfS1, tempFrequencyArray))
            return true;

        // Slide the window over s2
        for (int i = 1; i <= sizeOfSecondString - sizeOfFirstString; i++) {
            // Remove the character going out of the window
            tempFrequencyArray[s2.charAt(i - 1) - 'a']--;
            // Add the new character coming into the window
            tempFrequencyArray[s2.charAt(i + (sizeOfFirstString - 1)) - 'a']++;

            // Check for a match again
            if (isMatch(frequencyArrayOfS1, tempFrequencyArray))
                return true;
        }

        // If no permutation of s1 is found in s2, return false
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
