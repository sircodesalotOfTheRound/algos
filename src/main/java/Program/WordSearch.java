package Program;

import java.util.*;

/**
 * Created by sircodesalot on 14/12/18.
 */
public class WordSearch {
  private final WordGraph graph;

  public WordSearch(WordGraph graph) {
    this.graph = graph;
  }

  public Iterable<String> searchFor(String startWord, String endWord) {
    System.out.println("search start: " + new Date().getSeconds());

    if (!graph.containsKey(startWord) || !graph.containsKey(endWord)) {
      throw new RuntimeException("Nope!");
    }

    Set<String> seen = new HashSet<>();
    Queue<String> nodeQueue = new ArrayDeque<>();
    Map<String, String> path = new HashMap<>();

    seen.add(startWord);
    nodeQueue.add(startWord);

    String previousWord = startWord;
    String currentWord = previousWord;
    while (!nodeQueue.isEmpty()) {
      previousWord = currentWord;
      currentWord = nodeQueue.remove();

      path.put(currentWord, previousWord);

      if (currentWord.equals(endWord)) {
        return getBacktrack(path, endWord, startWord);
      }

      if (graph.getRelatedWords(currentWord).contains(endWord)) {
        path.put(endWord, currentWord);
        return getBacktrack(path, endWord, startWord);
      }

      for (String entry : graph.getRelatedWords(currentWord)) {
        if (seen.add(entry)) {
          nodeQueue.add(entry);
        }
      }
    }

    System.out.println("search end: " + new Date().getSeconds());
    return null;
  }

  private Iterable<String> getBacktrack(Map<String, String> path, String endWord, String startWord) {
    Stack<String> returnPath = new Stack<>();

    String currentWord = endWord;
    while (!currentWord.equals(startWord)) {
      returnPath.push(currentWord);
      currentWord = path.get(currentWord);
    }

    returnPath.push(startWord);

    List<String> items = new ArrayList<>();
    while (!returnPath.empty()) {
      items.add(returnPath.pop());
    }

    System.out.println("Search stop: " + new Date().getSeconds());
    return items;
  }

}
