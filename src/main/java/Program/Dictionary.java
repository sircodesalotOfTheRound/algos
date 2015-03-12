package Program;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sircodesalot on 14/12/16.
 */
public class Dictionary {
  public static final Dictionary INSTANCE = new Dictionary();
  private final Set<String> entries;

  private Dictionary() {
    this.entries = loadEntries();
  }

  public boolean containsKey(String key) {
    return this.entries.contains(key);
  }

  private Set<String> loadEntries() {
    try {
      Set<String> entries = new HashSet<>();
      FileInputStream inputStream = new FileInputStream("/usr/share/dict/words");
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader reader = new BufferedReader(inputStreamReader);

      String entry;
      while ((entry = reader.readLine()) != null) {
        entries.add(entry);
      }

      return entries;

    } catch (IOException ex) {
      throw new RuntimeException("Nope");
    }

  }
}
