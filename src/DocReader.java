
// Credit to Mark Kantowitz for name text files

import java.util.ArrayList;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class DocReader {
    private SimpleReader reader;

    public DocReader() {
        this.reader = new SimpleReader1L();
    }

    public ArrayList<String> readDoc(String docName) {
        this.reader = new SimpleReader1L(docName);
        ArrayList<String> lines = new ArrayList<String>();
        while (!this.reader.atEOS()) {
            String word = this.reader.nextLine();
            if (!lines.contains(word)) {
                lines.add(word);
            }
        }
        // TODO update method (and probably class) for new text documents
        return lines;
    }

    public Map<String, Set<String>> readDaily() {
        Map<String, Set<String>> ret = new Map1L<String, Set<String>>();
        //TODO finish
        return ret;
    }
}
