import java.util.*
fun main(args: Array<String>) {
    val solution = Solution()
    val beginWord = "hit"
    val endWord = "cog"
    val wordList = listOf("hot", "dot", "dog", "lot", "log", "cog")
    val result = solution.ladderLength(beginWord, endWord, wordList)
    println(result) // Output: 5
}
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {

        // Create a set to store the words in the word list
        val wordSet = wordList.toHashSet()

        // Create a queue to perform BFS
        val queue: Queue<String> = LinkedList()
        queue.offer(beginWord)

        // Create a set to store the visited words
        val visited = mutableSetOf<String>()
        visited.add(beginWord)

        // Create a map to store the distance from the beginWord
        val distance = mutableMapOf<String, Int>()
        distance[beginWord] = 1

        // Perform BFS
        while (queue.isNotEmpty()) {
            val word = queue.poll()

            // Check if we have reached the endWord
            if (word == endWord) {
                return distance[word]!!
            }

            // Generate all possible transformations of the current word
            for (i in 0 until word.length) {
                val sb = StringBuilder(word)
                for (j in 'a'..'z') {
                    sb.setCharAt(i, j)
                    val newWord = sb.toString()

                    // Check if the new word is in the word set and not visited
                    if (wordSet.contains(newWord) && newWord !in visited) {
                        queue.offer(newWord)
                        visited.add(newWord)
                        distance[newWord] = distance[word]!! + 1
                    }
                }
            }
        }

        // No transformation sequence exists
        return 0
    }
}