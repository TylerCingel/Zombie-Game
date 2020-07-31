import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("hiding")
public class Group<T extends Survivor> implements Iterable<Survivor> {
    private ArrayList<Survivor> group;

    /*
     * Make sub-classes for: Rival group Diseased group (maybe)
     */

    public Group() {
        this.group = new ArrayList<Survivor>();
    }

    public Group(ArrayList<Survivor> s) {
        this.group = s;
    }

    public void add(Survivor s) {
        this.group.add(this.group.size(), s);
    }

    public Survivor removeAny() {
        assert this.group.size() > 0 : "Violation of: |group| > 0";
        int index = (int) (Math.random() * this.group.size());
        return this.group.remove(index);
    }

    public Group<Survivor> split(int n) {
        Group<Survivor> ret = new Group<Survivor>();
        int remove = this.group.size() - n;
        for (int i = 0; i < remove; i++) {
            ret.add(this.removeAny());
        }
        return ret;
    }

    public void append(Group<Survivor> g) {
        for (Survivor s : g) {
            this.add(s);
        }
        g.clear();
    }

    public int size() {
        return this.group.size();
    }

    public Group<Survivor> copy() {
        Group<Survivor> ret = new Group<Survivor>();
        for (Survivor s : this.group) {
            ret.add(s.copy());
        }
        return ret;
    }

    public void clear() {
        this.group.clear();
    }

    @Override
    public String toString() {
        String ret = "=========================";
        for (Survivor person : this.group) {
            ret += person.toString();
            ret += "=========================";
        }
        return ret;
    }

    @Override
    public Iterator<Survivor> iterator() {
        return this.group.iterator();
    }
}
