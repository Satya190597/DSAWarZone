### Summary
The Solution class defines a method checkInclusion that checks if any permutation of string s1 is a substring of string s2. The method starts by comparing the lengths of the two strings, returning false if s2 is shorter. It constructs a frequency array for s1 to count the occurrences of each character.

The method then iterates through all possible substrings of s2 that have the same length as s1, creating a temporary frequency array for each substring. After constructing the frequency array for a substring, it compares this array to the frequency array of s1 using the isMatch helper method. If a match is found, the method returns true. If no matching substring is found after checking all possibilities, it returns false.
### Time Complexity: 
O(n * m), where n is the length of s2 and m is the length of s1, as each substring of s2 is checked against s1.
**Note comparison between two array will take constant time of 26.** 
### Space Complexity: 
O(1) since the frequency arrays are of fixed size (26).