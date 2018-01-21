# WordBarf

<b>What is Word Barf?</b>

Word Barf is a word puzzle where, given two English words of the same length, the player has to go from one word to the other by changing one letter at a time such that all the intermediate words also belong to the English language.

<b>Example</b>

One such path between the words <i>love</i> and <i>hate</i> would be:

love -> lave -> have -> hate

<b>Instructions</b>

Our program takes two English words of the same length and outputs a string of words, starting with the first word and ending with the last word, such that each of the intermediate words belong to the English language and are exactly one letter away from the previous word.

The user inputs two words as follows:

java Word startWord endWord

The program will then output a path between the two words or, if there is no such path, it will output a user message saying so.  If the user inputs two English words that aren't the same length or two strings that do not belong to the English language, the program will output the instructions.
