import java.util.ArrayList;

import components.map.Map;
import components.map.Map1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
// Relevant Classes:
//  DocReader
//  Group
//  Survivor

// Relevant Files:
//  male.txt
//  female.txt
//  family.txt

// How to edit the old game to make it more "edit friendly"
//  Make events a class/object that can be defined and then used
//  Make regular events easily add-able in a text file

// How to edit the old game to make it better
//  GRAPHICS MAYBE?
//  Less buggy
//  More events
//  More text
//  More intricate

public class ApocalypseNew {
    public static KeyboardReader reader = new KeyboardReader();
    public static ArrayList<String> maleNames;
    public static ArrayList<String> femaleNames;
    public static ArrayList<String> sirnames;
    public static Map<String, ArrayList<String>> eventText;
    public static int day = 0;
    public static double hordeOdds = .3;
    public static double rivalGroupOdds = .05;
    public static double weatherOdds = .15;
    public static double plagueOdds = .1;
    public static double traitorOdds = .2;

    public static void main(String[] args) {
        /////////////////////////////////////////////DOC READING
        DocReader read = new DocReader();
        maleNames = read.readDoc("doc/names/male.txt");
        femaleNames = read.readDoc("doc/names/female.txt");
        sirnames = read.readDoc("doc/names/family.txt");
        SimpleWriter write = new SimpleWriter1L();
        write.print("Done reading names.\n");
        String[] eventList = { "daily", "plague", "horde", "sanctuary",
                "weather", "rival", "traitor" };
        eventText = new Map1L<String, ArrayList<String>>();
        for (String event : eventList) {
            eventText.add(event + "Live",
                    read.readDoc("doc/events/" + event + "Live.txt"));
            eventText.add(event + "Die",
                    read.readDoc("doc/events/" + event + "Die.txt"));
            eventText.add(event + "Injured",
                    read.readDoc("doc/events/" + event + "Injured.txt"));
        }
        write.print("Done reading events.\n");
        /////////////////////////////////////////////SETUP
        ArrayList<Group<Survivor>> groups = new ArrayList<Group<Survivor>>();
        groups.add(newGroup());
        groups.get(0)
                .add(new Survivor("Tyler Cingel", "male", day, .95, "N/A"));
        System.out.println(groups.get(0).toString());
        /////////////////////////////////////////////DAILY UPDATES
        while (groups.size() > 0) {
            day++;
            System.out.println("Day " + day);
            for (int i = 0; i < groups.size(); i++) {
                System.out.println("Group " + (i + 1) + ": "
                        + groups.get(i).size() + " people alive");
            }
            ////////////////////////////////Daily Standard Events
            //////////////////Daily Actions
            //////////////////Daily New People
            //////////////////Daily Discoveries
            ////////////////////////////////Daily Special Events
            //////////////////Horde
            //////////////////Rival Group
            //////////////////Weather
            //////////////////Plague
            //////////////////Traitor
            String endDay = reader.readLine("Press <Enter> to continue...");
            ////////////////////////////////End-of-day info viewing
        }
        /////////////////////////////////////////////CLOSING
    }

    public static Group<Survivor> newGroup() {
        Group<Survivor> ret = new Group<Survivor>();
        int numFamilies = (int) (Math.random() * 5);
        int numLoners = (int) (Math.random() * 5);
        for (int i = 0; i < numFamilies; i++) {
            String lastName = getAny(sirnames);
            Survivor dad = new Survivor(getAny(maleNames) + " " + lastName,
                    "male", day, .8, "N/A");
            Survivor mom = new Survivor(getAny(femaleNames) + " " + lastName,
                    "female", day, .8, "N/A");
            int numKids = (int) (Math.random() * Math.random() * Math.random()
                    * 10);
            dad.changePartner(mom);
            mom.changePartner(dad);
            ret.add(dad);
            ret.add(mom);
            for (int j = 0; j < numKids; j++) {
                boolean male = Math.random() > .5;
                if (male) {
                    ret.add(new Survivor(getAny(maleNames) + " " + lastName,
                            "male", day, .75, "N/A"));
                } else {
                    ret.add(new Survivor(getAny(femaleNames) + " " + lastName,
                            "female", day, .75, "N/A"));
                }
            }
        }
        for (int i = 0; i < numLoners; i++) {
            boolean male = Math.random() > .5;
            if (male) {
                ret.add(new Survivor(getAny(maleNames) + " " + getAny(sirnames),
                        "male", day, .85, "N/A"));
            } else {
                ret.add(new Survivor(
                        getAny(femaleNames) + " " + getAny(sirnames), "female",
                        day, .9, "N/A"));
            }
        }
        return ret;
    }

    /**
     * [Gets a String from s without it being removed]
     *
     * @param s
     *            set from which a String will be returned
     * @return random String from s
     */
    public static String getAny(ArrayList<String> s) {
        int randomNum = (int) (Math.random() * s.size());
        String ret = s.get(randomNum);
        return ret;
    }

    /**
     * [Takes a String and swaps appropriate place-holders]
     *
     * @param s
     *            Survivor from which we get name and gender
     * @param line
     *            String that we are editing
     * @return Reformatted String
     */
    public static String assembleString(Survivor s, String line) {

        String[] pronounFind = { "pStart", "pEnd" };
        String[] randomFind = { "rStart", "rEnd" };
        String nameFind = "[name]";
        while (line.indexOf(nameFind) != -1) {
            int index = line.indexOf(nameFind);
            line = line.substring(0, index) + s.getName()
                    + line.substring(index + nameFind.length());
        }
        while (line.indexOf(pronounFind[0]) != -1) {
            int start = line.indexOf(pronounFind[0]);
            int end = line.indexOf(pronounFind[1]) + pronounFind[1].length();
            String parse = line.substring(start, end);
            parse = parse.substring(0, end - pronounFind[1].length());
            parse = parse.substring(start + pronounFind[0].length());
            String[] pronouns = breakParse(parse);
            if (s.getGender().equals("male")) {
                line = line.substring(0, start) + pronouns[0]
                        + line.substring(end);
            } else {
                line = line.substring(0, start) + pronouns[1]
                        + line.substring(end);
            }
        }
        while (line.indexOf(randomFind[0]) != -1) {
            int start = line.indexOf(randomFind[0]);
            int end = line.indexOf(randomFind[1]) + randomFind[1].length();
            String parse = line.substring(start, end);
            parse = parse.substring(0, end - randomFind[1].length());
            parse = parse.substring(start + randomFind[0].length());
            String[] numbers = breakParse(parse);
            int low = (Integer.valueOf(numbers[0])).intValue();
            int high = (Integer.valueOf(numbers[1])).intValue();
            int random = (int) (Math.random() * (high - low)) + low;
            line = line.substring(0, start) + random + line.substring(end);
        }
        return line;
    }

    public static String[] breakParse(String toParse) {
        toParse = toParse.substring(1, toParse.length() - 1);
        int comma = toParse.indexOf(",");
        String part1 = toParse.substring(0, comma);
        String part2 = toParse.substring(comma + 1);
        String[] ret = new String[2];
        ret[0] = part1;
        ret[1] = part2;
        return ret;
    }
}
