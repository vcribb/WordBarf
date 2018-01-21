# WordBarf

<b>What is Word Barf?</b>

Word Barf is a word puzzle where, given two English words of the same length, the player has to get from one word to the other by changing one letter at a time, such that each intermediate series of letters is an actual word.

<b>Example:</b>

To go from love to hate, the following series would be acceptable:

love -> lave -> have -> hate

<b>Instructions</b>

Our program takes two English words of the same length and outputs a string of words, starting with the first inputted word and ending in the last inputted word, where each intermediate word differs from the previous word by one letter.

In order to run the program, the user should enter the two words they would like to create a path between as follows:

java Word startWord endWord

The program will then output a path between the two or, if no such path exists, a user message explaining that there is no such path.
