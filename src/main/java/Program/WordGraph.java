package Program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by sircodesalot on 14/12/18.
 */
public class WordGraph {
  private static final Map<String, Set<String>> graph = new HashMap<>();

  public WordGraph() {
    this.loadDictionary();
  }

  private void loadDictionary() {
    try {
      FileInputStream inputStream = new FileInputStream("/usr/share/dict/words");
      InputStreamReader streamReader = new InputStreamReader(inputStream);
      BufferedReader reader = new BufferedReader(streamReader);

      String word;
      while ((word = reader.readLine()) != null) {
        for (String permutation : this.getPermutations(word.toLowerCase())) {
          this.getNode(permutation).add(word.toLowerCase());
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public boolean containsKey(String key) {
    return !this.getRelatedWords(key).isEmpty();
  }

  public Set<String> getRelatedWords(String key) {
    Set<String> relatedWords = new HashSet<>();

    if (this.graph.containsKey(key)) {
      relatedWords.addAll(this.graph.get(key));
    }

    for (String permutation : this.getPermutations(key)) {
      if (this.graph.containsKey(permutation)) {
        relatedWords.addAll(this.graph.get(permutation));
      }
    }

    return relatedWords;
  }

  private Set<String> getNode(String key) {
    if (graph.containsKey(key)) {
      return graph.get(key);
    }

    Set<String> set = new HashSet<>();
    this.graph.put(key, set);

    return set;
  }

  private List<String> getPermutations(String word) {
    List<String> permutations = new ArrayList<>();

    int length = word.length();
    for (int index = 0; index < length; index++) {
      String permutation = String.format("%s%s", word.substring(0, index), word.substring(index + 1));
      permutations.add(permutation);
    }

    return permutations;
  }



}
