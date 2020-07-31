// Tyler Cingel
// Survivor
// My class that will be used for an array of people in
//   my apocalypse game, used to keep track of their name,
//   the day they joined, and eventually, their gender.

public class Survivor extends Object {

    private String myName; // Name of person (first and last)
    private String myGender; // Gender of person
    private int dayJoin; // Day they joined group
    private double survivability; // How likely a survivor is to survive a given day (0-1)
    private String myOrigin = ""; // If applicable, what person is from (show)
    private Survivor partner = null;

    //  Potential Variables
    //      boolean injured
    //          If person is injured
    //      boolean sick
    //          If person is sick (might make separate group class)
    //      Survivor significant other
    //          Romantic companion
    //      int happiness
    //          How happy they are (may influence actions)

    ////////////////////////////////////////////////Constructors

    public Survivor(String name, String gender, int joined, double s,
            String origin) {
        assert !name.equals("") : "Violation of: !name.equals(\"\")";
        assert gender.toLowerCase().equals("male") || gender.toLowerCase()
                .contentEquals("female") : "Error: Gender of " + name
                        + " unknown.";
        assert joined >= 0 : "Violation of: joined (" + name + ") >= 0";
        assert s >= 0 && s <= 1 : "Violation of: s (" + name + ") >= 0 && <= 1";

        this.myName = name;
        this.myGender = gender.toLowerCase();
        this.dayJoin = joined;
        this.survivability = s;
        this.myOrigin = origin;
    }

    ///////////////////////////////////////Added so old version will work, avoid using in new version
    public Survivor(String name) {
        this.myName = name;
        this.dayJoin = 0;
    }

    public Survivor(String name, int joined) {
        this.myName = name;
        this.dayJoin = joined;
    }

    ///////////////////////////////////////////////Access methods
    public int joined() {
        return this.dayJoin;
    }

    public String getName() {
        return this.myName;
    }

    public String getGender() {
        return this.myGender;
    }

    public String getOrigin() {
        return this.myOrigin;
    }

    public Survivor getPartner() {
        return this.partner;
    }

    /////////////////////////////////////////////Editors
    public void newName(String name) {
        assert !name.equals("") : "Violation of: !name.equals(\"\")";
        this.myName = name;
    }

    public void newJoin(int day) {
        assert day >= 0 : "Violation of: day (" + this.myName + ") >= 0";
        this.dayJoin = day;
    }

    public void genderChange(String newGen) {
        assert newGen.toLowerCase().equals("male") || newGen.toLowerCase()
                .contentEquals("female") : "Error: Gender of " + this.myName
                        + " unknown.";
        this.myGender = newGen;
    }

    public void editSurvivability(double multiplier) {
        assert multiplier >= 0 : "Violation of: multiplier >= 0";
        assert multiplier <= 1 : "Violation of: multiplier <= 1";
        this.survivability = (this.survivability + multiplier) / 2.0;
    }

    public void changeOrigin(String origin) {
        this.myOrigin = origin;
    }

    public void changePartner(Survivor newPartner) {
        this.partner = newPartner;
    }

    public void makeSingle() {
        this.partner = null;
    }

    /////////////////////////////////////////////Miscellaneous
    public Survivor copy() {
        return new Survivor(this.myName, this.myGender, this.dayJoin,
                this.survivability, this.myOrigin);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "\nName: " + this.myName;
        ret += "\nGender: " + this.myGender;
        if (this.partner != null) {
            ret += "\nRelationship: " + this.partner.getName();
        } else {
            ret += "\nRelationship: Single";
        }
        ret += "\nJoined: " + this.dayJoin;
        ret += "\nSurvivability: " + this.survivability;
        ret += "\nOrigin: " + this.myOrigin;
        ret += "\n";
        return ret;
    }
}
