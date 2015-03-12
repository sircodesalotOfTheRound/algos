package Program.structures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sircodesalot on 14/12/26.
 */
public class AlphabetTrie {
  public class TrieNode {
    private Character letter;
    private Map<Character, TrieNode> nodes;
    private boolean isWord = false;

    TrieNode(Character letter) {
      this.letter = letter;
      this.nodes = new HashMap<>();
    }

    public boolean contains(char letter) {
      return this.nodes.containsKey(letter);
    }

    public TrieNode get(char letter) {
      return this.nodes.get(letter);
    }

    public boolean isWord() { return this.isWord; }
    public void setIsWord() { this.isWord = true; }

    public TrieNode addNode(char letter) {
      TrieNode node = new TrieNode(letter);
      this.nodes.put(letter, node);

      return node;
    }
  }

  private TrieNode head = new TrieNode(null);
  public void insert(String word) {
    insert(word.toCharArray());
  }

  private void insert(char[] word) {
    TrieNode current = this.head;
    for (char letter : word) {
      if (current.contains(letter)) {
        current = current.get(letter);
      } else {
        current = current.addNode(letter);
      }
    }

    current.setIsWord();
  }

  public boolean isWord(String word) {
    TrieNode node = this.head;
    for (char letter : word.toCharArray()) {
      if (node.contains(letter)) {
        node = node.get(letter);
      } else {
        return false;
      }
    }

    return node.isWord();
  }
}
