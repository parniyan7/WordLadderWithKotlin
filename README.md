# Word Ladder Problem

This is a solution for the Word Ladder problem implemented in Kotlin. The problem statement is as follows:

Given two words, `beginWord` and `endWord`, and a dictionary `wordList`, find the length of the shortest transformation sequence from `beginWord` to `endWord`, where:

- Only one letter can be changed at a time.
- Each transformed word must exist in the word list.

If there is no such transformation sequence, return 0.

## Solution

The solution uses the Breadth First Search (BFS) algorithm to traverse the graph of possible word transformations, starting from `beginWord` and exploring all the possible transformations that can be made from it. The solution maintains a queue of words to be explored, a set of visited words, and a map of distances from the `beginWord`. 

To generate all possible transformations of a word, we iterate through all the characters of the word and replace each character with the 26 alphabets. We then check if the resulting word is in the `wordList` and has not been visited before. If so, we add it to the queue, mark it as visited, and update its distance from the `beginWord`.

When we encounter the `endWord`, we return its distance from the `beginWord`. If we have explored all possible transformations and have not reached the `endWord`, we return 0.

## Usage

To use this solution, create an instance of the `Solution` class and call the `ladderLength` method, passing in the `beginWord`, `endWord`, and `wordList` as parameters. The `wordList` should be a `List` of `String`s.

```kotlin
val solution = Solution()
val beginWord = "hit"
val endWord = "cog"
val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
val result = solution.ladderLength(beginWord, endWord, wordList)
println(result) // Output: 5
```

In this example, the shortest transformation sequence from "hit" to "cog" is "hit" -> "hot" -> "dot" -> "dog" -> "cog", which has a length of 5.
