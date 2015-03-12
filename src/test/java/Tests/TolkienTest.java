package Tests;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sircodesalot on 15/2/24.
 */
public class TolkienTest {

  public class Token {
    private final int startPosition;
    private int endPosition;

    public Token(int startPosition) {
      this.startPosition = startPosition;
    }

    public int startPosition() { return this.startPosition; }

    public void setEndPosition(int value){ this.endPosition = value; }
    public int endPosition() { return this.endPosition; }

    public int distance() { return this.endPosition - this.startPosition; }
  }

  public class NetworkNode {
    public final String name;
    private final NetworkNode next;
    private List<Token> tokens = new ArrayList<>();

    public NetworkNode(String name, NetworkNode next) {
      this.name = name;
      this.next = next;
    }

    public void addToken(Token token) {
      this.tokens.add(token);
    }

    public void addTokens(Iterable<Token> tokens) {
      for (Token token : tokens) {
        this.tokens.add(token);
      }
    }

    public Iterable<Token> releaseTokens() {
      List<Token> tokenList = this.tokens;
      this.tokens = new ArrayList<>();

      return tokenList;
    }

    public String name() { return this.name; }
    public NetworkNode next() { return this.next; }
    public boolean hasNext() { return this.next != null; }
  }

  public class NodeSet {
    private NetworkNode startingNode = null;
    private final Map<String, List<NetworkNode>> nodes = new HashMap<>();

    public void addNode(NetworkNode node) {
      String name = node.name();
      if (nodes.containsKey(name)) {
        nodes.get(name).add(node);
      } else {
        List<NetworkNode> list = new ArrayList<>();
        list.add(node);
        nodes.put(name, list);
      }
    }

    public boolean containsKey(String name) {
      return nodes.containsKey(name);
    }

    public void setStartingNode(NetworkNode node) {
      this.startingNode = node;
    }

    public NetworkNode getStartingNode() {
      return this.startingNode;
    }

    public Iterable<Token> advance(String name) {
      Iterable<Token> result = null;
      if (containsKey(name)) {
        for (NetworkNode node : this.nodes.get(name)) {
          if (node.hasNext()) {
            node.next().addTokens(node.tokens);
          } else {
            result = node.tokens;
          }
        }
      }

      return result;
    }

  }

  public class Network {
    private String startingWord;
    private NodeSet nodeset;
    private Token shortestPath = null;

    public Network(String ... entries) {
      this.startingWord = entries[0];
      this.nodeset = generateNodeSet(entries);
    }

    public NodeSet generateNodeSet(String ... entries) {
      NodeSet nodeset = new NodeSet();
      NetworkNode node = null;
      for (int index = entries.length - 1; index >= 0; index--) {
        node = new NetworkNode(entries[index], node);
        nodeset.addNode(node);
      }

      nodeset.setStartingNode(node);
      return nodeset;
    }

    public boolean containsKey(String word) {
      return nodeset.containsKey(word);
    }

    public void advance(String word, int index) {
      if (word.equals(startingWord)) {
        nodeset.getStartingNode().addToken(new Token(index));
      }

      // Capture the tokens that have made it through the network.
      this.shortestPath = processTokens(nodeset.advance(word), index);
    }

    private Token processTokens(Iterable<Token> tokens, int index) {
      Token shortestPath = this.shortestPath;
      if (tokens == null) {
        return shortestPath;
      }

      for (Token token : tokens) {
        token.setEndPosition(index);
        if (shortestPath == null || (token.distance() < shortestPath.distance())) {
          shortestPath = token;
        }
      }

      return shortestPath;
    }

  }

  private String buildSubString(String[] parent, Token token) {
    StringBuilder builder = new StringBuilder();
    for (int index = token.startPosition; index <= token.endPosition; index++) {
      String word = parent[index];
      builder.append(word).append(" ");
    }

    return builder.toString().trim();
  }

  private String process(String parent, String ... children) {
    Network network = new Network(children);
    String[] parentList = parent.split(" ");
    for (int index = 0; index < parentList.length; index++) {
      String word = parentList[index];
      if (network.containsKey(word.toLowerCase())) {
        network.advance(parentList[index], index);
      }
    }

    Token shortestPath = network.shortestPath;
    if (shortestPath != null) {
      return buildSubString(parentList, shortestPath);
    } else {
      return null;
    }
  }

  @Test
  public void run() {
    String first = process("One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them",
      "find", "them", "all");

    assert(first.equals("find them, One Ring to bring them all"));

    String second = process("One Ring to rule them all, One Ring to find them, One Ring to find them all and in the darkness bind them",
      "find", "them", "all");

    assert(second.equals("find them all"));
  }

}
