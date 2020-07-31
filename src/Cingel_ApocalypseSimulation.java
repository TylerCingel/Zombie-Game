//Tyler Cingel
//ApocalypseSimulation
//It's really just zombies and death

//Enter x amount of names as "friends", like hunger games, slowly kills people off, ends when everyone is dead
// multiple ways to die, keeps track of number of companions, days survived, human/zombie kills (maybe)
//Possible events, horde, intruders, rebellion/rebel, new disease, new group,
//Only displays messages if someone dies or if some major event happens,
//Does NOT keep track of amount of food, water, energy, etc. (too complicated)

// Uses:
//  Survivor
//  Cingel_NameGenerator

/* BUGS:
 * None that I know of :D
 *
 */

/* LEADERBOARD:
 *=====================
 * 1) Tyler - Survived (306 DI)
 * 2) Tyler - 402
 * 3) Tyler - 398
 * 4) Tyler - 273
 * 5) Jonah - 266 (Selin, 247)
 */

/* Survived with:
 *  1) Me
 *  2) Carol
 *  3) Ed
 *  4) Randy
 *  5) Charnae
 *  6) Brianna
 *  7) Caitlin
 *
 * One big horde
 * One bad traitor
 * 2 sanctuaries
 * The Governor
 */

import java.util.ArrayList;

public class Cingel_ApocalypseSimulation {
    public static void main(String[] args) {

        /*
         * Possible ideas for further "updates" and current content
         *
         * Zombie/Human Kills | next In-depth insturctions | next Group breaking
         * away | next Chosing who lives/dies | 100% of target audience says
         * "bad idea" Relationships | possibility Food and water | don't want to
         * but maybe
         *
         * Relationships notes: No idea how to differ genders Objects, just need
         * to take the time to organize it somehow
         *
         *
         * Group breaking away notes: Up to half group leaving Makes ArrayList
         * of people leaving Chance of group rejoining Sort-of "safe" for group
         * Need way of having multiple ArrayLists Maybe make (x) and have max #
         * of groups leaving (x) Try my luck at ArrayList of ArrayLists Screw
         * this whole idea cause I'm lazy and don't want to think about it
         *
         *
         * Chosing who lives/dies notes: Possible methods Notes all deaths and
         * can cancel half Pick x (3-5) people who won't die (tells you if they
         * lived cause of you) if names.size() < 6-10, can't save people/only
         * save 1 Chosing 1-2 people who will most likely survive (general odds)
         */
        KeyboardReader reader = new KeyboardReader();
        ArrayList<Survivor> names = new ArrayList<Survivor>();
        String pause;
        Cingel_NameGenerator nameGenerator = new Cingel_NameGenerator();

        /*
         * char instructions = reader.readChar("Instructions? (Y)es (N)o: ");
         * while (instructions == 'Y' || instructions == 'y') { System.out.
         * println("\nWhich part of the game would you like to learn about?");
         * System.out.println(" 1)  Starting group and Seniority");
         * System.out.println(" 2)  Finding new people");
         * System.out.println(" 3)  Finding a sanctuary");
         * System.out.println(" 4)  Dying"); System.out.println(" 5)  Hordes");
         * System.out.println(" 6)  Rival groups");
         * System.out.println(" 7)  Natural disasters");
         * System.out.println(" 8)  Plagues");
         * System.out.println(" 9)  Traitors");
         * System.out.println(" 10) Do-it-yourself");
         * System.out.println(" 11) About Tyler");
         * System.out.println(" 12) Credits"); System.out.println(" 13) Exit");
         * int learn = reader.readInt("Enter choice here: ");
         * System.out.println(); if (learn ==
         * 1)/////////////////////////Starting group inst {
         * System.out.println("Starting group:"); System.out.
         * println(" To create a save for a starting group, refer to 'Do-it-yourself"
         * ); System.out.
         * println(" To enter a starting group from scratch, just type either 'M' or 'm'"
         * ); System.out.
         * println("  when it asks whether you want to use save or manual");
         * System.out.println("Seniority:"); System.out.
         * println(" Your starting group, or what's left of it, around 100 days in"
         * ); System.out.
         * println(" is going to be a lot stronger than those who join around day 100."
         * ); System.out.
         * println(" The way this works is the longer someone has been part of your group,"
         * ); System.out.
         * println(" the less likely they are to die, and therefor, stronger.");
         * System.out.
         * println(" This means you should probably add your closest family/friends"
         * ); System.out.
         * println(" to your starting group, on the flip-side, they are more likely to"
         * ); System.out.
         * println(" be dead around day 100 than those who join around that time, but stronger."
         * ); pause = reader.readLine("Press enter to continue..."); } else if
         * (learn == 2)/////////////////////////New people/raiders inst {
         * System.out.println("New people:"); System.out.
         * println(" New people is usually a good thing, you are given somewhere"
         * ); System.out.
         * println(" between 1-10 people, and consequently, your group grows!");
         * System.out.
         * println(" another neat thing is strength in numbers, the more people"
         * );
         * System.out.println(" in your group, the less likely anyone will die!"
         * ); System.out.
         * println(" But with most things in this game, there's risks.");
         * System.out.
         * println(" The less people in your group, the more likely that those"
         * ); System.out.
         * println(" new people are going to raid and kill your group, so be weary!"
         * ); System.out.
         * println(" There are other risks as well such as plague, and if you're going"
         * ); System.out.
         * println(" lone-ranger, all alone, they're going to raid you, no getting around that."
         * ); pause = reader.readLine("Press enter to continue..."); } else if
         * (learn == 3)/////////////////////////Sanctuary/ false sanct inst {
         * System.out.println("Sanctuary:"); System.out.
         * println(" A sanctuary is really a great thing when you get down to it."
         * ); System.out.
         * println(" when you find it, you get to name it, and you can find anywhere from"
         * ); System.out.
         * println(" 20-30 people living there garunteed, as well as a much lower chance of dying."
         * ); System.out.
         * println(" Additionaly, you're going to have a steady stream of new people wanting"
         * ); System.out.
         * println(" to join your sanctuary! But let it be known that this, like everything else,"
         * ); System.out.
         * println(" is not permament. Sanctuaries can fall from a bad storm, and will from hordes."
         * ); System.out.
         * println(" And when it does fall, it'll be some 50-100 people out in the open."
         * ); System.out.
         * println(" This is all if it even is a sanctuary. There is always that off chance"
         * ); System.out.
         * println(" that this sanctuary is too good to be true, and if it is, watch out!"
         * ); System.out.
         * println(" A lot of people will get stabbed, shot, and mowed down (kinda like Terminus)."
         * ); System.out.
         * println(" Or your group might be turned away if a plague is sweeping through the group."
         * ); pause = reader.readLine("Press enter to continue..."); } else if
         * (learn == 4)/////////////////////////Dying inst { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 5)/////////////////////////Hordes inst { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 6)/////////////////////////Rival groups inst { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 7)/////////////////////////Natural disasters inst { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 8)/////////////////////////Plague inst { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 9)/////////////////////////Traitors { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 10)/////////////////////////Do-it-yourself { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 11)/////////////////////////About me { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 12)/////////////////////////Credits { pause =
         * reader.readLine("Press enter to continue..."); } else if (learn ==
         * 13)/////////////////////////Exit {
         * System.out.println("Hope you enjoy my game!"); break; }
         * else/////////////////////////Not an option {
         * System.out.println("Not an option."); pause =
         * reader.readLine("Press enter to continue..."); } }
         */
        char again = 'Y';
        while (again == 'Y' || again == 'y') {
            ArrayList<Survivor> objList = new ArrayList<Survivor>();
            ArrayList<String> newPerson = new ArrayList<String>();
            newPerson = nameGenerator.newcomer();

            for (int makeObj = 0; makeObj < newPerson.size(); makeObj++) {
                objList.add(new Survivor(newPerson.get(makeObj)));
            }

            ////////////////////////////////////////////////////////////////////////End of apocalypse
            System.out.println(
                    "Do you want a possibility of surviving the apocalypse (an end):");
            System.out.println(" 1) Yes I want an end");
            System.out.println(" 2) No, no end");
            System.out.println(" 3) Possibility of end");
            String isEnd = reader.readLine("Enter choice here: ");
            int finish;
            if (isEnd.equals("1")) {
                finish = (int) (545 * Math.random()) + 185;
            } else if (isEnd.equals("2")) {
                finish = -1;
            } else if (isEnd.equals("3")) {
                int end = (int) (3 * Math.random());
                if (end == 1) {
                    finish = (int) (545 * Math.random()) + 185;
                } else {
                    finish = -1;
                }
            } else {
                int end = (int) (3 * Math.random());
                if (end == 1) {
                    finish = (int) (545 * Math.random()) + 185;
                } else {
                    finish = -1;
                }
            }

            names.clear();
            int times = 0;
            char correct = 'n';
            char save = reader.readChar(
                    "\n\nDo you want to use a random, save, or manual? (R)andom (S)ave (M)anual: ");
            int addPerson;
            //healthy.clear();

            if (save == 'm' || save == 'M') {
                System.out.println("Type 'stop' to stop");
                String input = "";
                while (!input.equals("stop") && names.size() < 100) {
                    times++;
                    names.add(new Survivor(input, 0));
                    input = reader.readLine("Enter name " + times + ": ");
                }
                if (names.size() > 100) {
                    pause = reader.readLine(
                            "I had to cut you off, I think you have enough people now.");
                }
                names.remove(0);
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Correcting names:
                ////////////////////////////////////////////////////////////////////////////////////////////
                correct = 'n';
                while (correct == 'n' || correct == 'N') {
                    correct = reader.readChar(
                            "Are all these names correct? (Y)es (N)o: ");
                    if (correct == 'N' || correct == 'n') {
                        int fix = reader
                                .readInt("Which number do you want to fix: ");
                        names.remove(fix - 1);
                        names.add(new Survivor(reader.readLine("Enter name: "),
                                0));
                    }
                }
            } else if (save == 'r' || save == 'R') {
                int numStart = 0;
                do {
                    if (numStart > 100) {
                        pause = reader.readLine(
                                "The number must be smaller than 100.");
                    }
                    numStart = reader.readInt(
                            "How big do you want your starting group: ");
                } while (numStart > 100);
                char randChoice = reader.readChar(
                        "Do you want to use all names or random save? (A)ll (S)ave: ");
                if (randChoice == 'a' || randChoice == 'A') {
                    for (int startPeople = 1; startPeople <= numStart; startPeople++) {
                        addPerson = (int) (newPerson.size() * Math.random());
                        pause = reader.readLine("Group member " + startPeople
                                + ": " + newPerson.get(addPerson));
                        names.add(new Survivor(newPerson.get(addPerson), 0));
                        newPerson.remove(addPerson);
                    }
                } else {
                    ArrayList<String> randSave = new ArrayList<String>();
                    /////////////////////////////////////////////////////////////TWD Charscters

                    randSave.add("Rick *");
                    randSave.add("Lori *");
                    randSave.add("Carl *");
                    randSave.add("Andrea *");
                    randSave.add("Amy *");
                    randSave.add("Glenn *");
                    randSave.add("Morales *");
                    randSave.add("Dale *");
                    randSave.add("Shane *");
                    randSave.add("Jim *");
                    randSave.add("Jaqui *");
                    randSave.add("Ed *");
                    randSave.add("Sophia *");
                    randSave.add("Carol *");
                    randSave.add("Daryl *");
                    randSave.add("Merle *");
                    randSave.add("T-Dogg *");
                    randSave.add("Hershel *");
                    randSave.add("Maggie *");
                    randSave.add("Beth *");
                    randSave.add("Jimmy *");
                    randSave.add("Otis *");
                    randSave.add("Patricia *");
                    randSave.add("Michonne *");
                    randSave.add("Oscar *");
                    randSave.add("Andrew *");
                    randSave.add("Axel *");
                    randSave.add("Big-Tiny *");
                    randSave.add("Tyreese *");
                    randSave.add("Sasha *");
                    randSave.add("Bob *");
                    randSave.add("Judith *");
                    randSave.add("Karren *");
                    randSave.add("Caleb *");
                    randSave.add("Lizzy *");
                    randSave.add("Mika *");
                    randSave.add("Gabriel *");
                    randSave.add("Tara *");
                    randSave.add("Abraham *");
                    randSave.add("Rosita *");
                    randSave.add("Eugene *");
                    randSave.add("Aaron *");
                    randSave.add("Eric *");
                    randSave.add("Deanna *");
                    randSave.add("Redge *");
                    randSave.add("Spencer *");
                    randSave.add("Enid *");
                    randSave.add("Nicholas *");
                    randSave.add("Aiden *");
                    randSave.add("Jesse *");
                    randSave.add("Sam *");
                    randSave.add("Ron *");
                    randSave.add("Pete *");
                    randSave.add("Tobin *");
                    randSave.add("Olivia *");
                    randSave.add("Heath *");
                    randSave.add("Denise *");
                    randSave.add("Holly *");
                    randSave.add("Carter *");
                    randSave.add("Paul *");
                    randSave.add("Gregory *");
                    randSave.add("Carson *");
                    randSave.add("Earl *");
                    randSave.add("Eduardo *");
                    randSave.add("Brianna *");
                    randSave.add("Wesley *");
                    randSave.add("Mandy *");
                    randSave.add("Samuel *");
                    randSave.add("Crystal *");
                    randSave.add("Andy *");
                    randSave.add("David *");
                    randSave.add("Alex *");
                    randSave.add("Richard *");
                    randSave.add("Arnold *");
                    randSave.add("Marco *");
                    randSave.add("Rolland *");
                    randSave.add("Dante *");
                    randSave.add("Larry *");
                    randSave.add("Kal *");
                    randSave.add("Ken *");
                    randSave.add("Louie *");
                    randSave.add("Amber *");
                    randSave.add("Edwin *");
                    randSave.add("Brian *");
                    randSave.add("Penny *");
                    randSave.add("Lilly *");
                    randSave.add("Martinez *");
                    randSave.add("Gareth *");
                    randSave.add("Dwight *");
                    randSave.add("Negan *");

                    while (numStart > randSave.size()) {
                        numStart = reader.readInt("You don't have " + numStart
                                + " people in your save, try a lower number: ");
                    }

                    for (int pickRand = 1; pickRand <= numStart; pickRand++) {
                        int namePick = (int) (randSave.size() * Math.random());
                        String nameChose = randSave.get(namePick);
                        randSave.remove(nameChose);
                        pause = reader.readLine(
                                "Group member " + pickRand + ": " + nameChose);
                        names.add(new Survivor(nameChose, 0));
                    }

                    for (int delSave = 0; delSave < newPerson
                            .size(); delSave++) {
                        for (int saveRun = 0; saveRun < names
                                .size(); saveRun++) {
                            if ((names.get(saveRun).getName())
                                    .equals(newPerson.get(delSave))) {
                                newPerson.remove(delSave);
                            }
                        }
                    }

                }
            }

            else {
                //////////////////////////////////////////Make name save here

                names.add(new Survivor("Tyler", 0));
                names.add(new Survivor("Jenny", 0));
                names.add(new Survivor("Rick", 0));
                names.add(new Survivor("Lori", 0));
                names.add(new Survivor("Carl", 0));
                names.add(new Survivor("Andrea", 0));
                names.add(new Survivor("Glenn", 0));
                names.add(new Survivor("Dale", 0));
                names.add(new Survivor("Shane", 0));
                names.add(new Survivor("Carol", 0));
                names.add(new Survivor("Daryl", 0));
                names.add(new Survivor("T-Dog", 0));
                names.add(new Survivor("Hershel", 0));
                names.add(new Survivor("Maggie", 0));
                names.add(new Survivor("Beth", 0));
                names.add(new Survivor("Jimmy", 0));
                names.add(new Survivor("Otis", 0));
                names.add(new Survivor("Patricia", 0));
            }
            String death;
            boolean inSanct = false;

            times = 0;
            int status;
            String sanctName = "Sanctuary";
            int sanctOdds = 0;
            int groupSize = 0;
            boolean isRivals = false;
            boolean isPlague = false;
            ArrayList<Survivor> tempNames = new ArrayList<Survivor>();
            ArrayList<Survivor> contaminated = new ArrayList<Survivor>();
            ArrayList<Survivor> nonCom = new ArrayList<Survivor>();
            int comunicability = 0;
            int lethality = 0;

            int c = 0;
            String rivalLeader = "";
            boolean governor = false;
            boolean find;
            //System.out.println("End of apocalypse: " + finish);                                           Apocalypse End
            /*
             * Boss fights to add: Whisperers Wolves
             */
            ArrayList<Survivor> healthy = new ArrayList<Survivor>();
            for (int addHealthy = 0; addHealthy < names.size(); addHealthy++) {
                healthy.add(names.get(addHealthy));
            }

            while (c < names.size() && times != finish && names.size() < 300) {
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////General information:
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (governor) {
                    int govAddGroup = (int) (5 * Math.random() + 1);
                    if (govAddGroup == 1) {
                        groupSize += (int) (3 * Math.random() + 1);
                    }
                }
                if (isPlague == true) {
                    if (contaminated.size() == 0) {
                        pause = reader
                                .readLine("The plague has run its course.");
                        isPlague = false;
                    }
                }
                if (isRivals == true && groupSize <= 0) {
                    isRivals = false;
                    governor = false;
                }
                times++;
                System.out.println("\n\nDay " + times);
                System.out.println("Group members left: " + names.size());
                if (isPlague == true) {
                    System.out.println(
                            "Current people infected: " + contaminated.size());
                }
                if (isRivals == true && groupSize > 0) {
                    System.out
                            .println("Rival group members left: " + groupSize);
                }
                if (inSanct == true) {
                    System.out.println("Current sanctuary: " + sanctName);
                }
                System.out.println("-------------------------------------");
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Name Check
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (newPerson.size() <= 40) {
                    newPerson = nameGenerator.newcomer();
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Rival group
                ////////////////////////////////////////////////////////////////////////////////////////////
                int rivalGroup = (int) (100 * Math.random()) + 1;
                /// To add: Govenor, Terminus, Dawn (Hospital), Wolves, Whisperers
                if (rivalGroup == 1 && isRivals == false) {
                    int boss = (int) (5 * Math.random()) + 1;
                    if (boss == 1) {
                        groupSize = 150;
                        pause = reader.readLine(
                                "Negan - \n'Hi, I'm Negan. And I do not appreciate you killing my men,\nand when I sent my men to kill your men, you killed more of my men!'");
                    } else if ((boss == 2 || boss == 3) && inSanct == true
                            && !governor) {
                        pause = reader.readLine(
                                "The Governor - \n'In this life now you kill or you die. Or you die and you kill.'");
                        groupSize = 20;
                        governor = true;
                    } else {

                        groupSize = (int) (60 * Math.random()) + 1;
                        pause = reader.readLine(
                                "You found a rival group consisting of "
                                        + groupSize + " people!");
                        addPerson = (int) (newPerson.size() * Math.random());
                        rivalLeader = newPerson.get(addPerson);
                        pause = reader.readLine(
                                "Their leader's name is " + rivalLeader + ".");
                    }
                    isRivals = true;
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Rival war
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (isRivals == true) {
                    int rivalWar = (int) (7 * Math.random()) + 1;
                    if (rivalWar == 1 && healthy.size() > 0) {
                        int warCasualties;
                        int rivalDeaths = 0, teamLoss = 0;

                        if (healthy.size() >= groupSize) {
                            warCasualties = (int) (groupSize * Math.random())
                                    + 1;
                        } else {
                            warCasualties = (int) (healthy.size()
                                    * Math.random()) + 1;
                        }

                        if (warCasualties > 15) {
                            System.out.println("RIVAL WAR!!!");
                        } else if (warCasualties > 5) {
                            System.out.println("Rival Battle!");
                        } else {
                            System.out.println("Rival skirmish.");
                        }
                        for (int rivalClash = 0; rivalClash < warCasualties; rivalClash++) {
                            int teamDeath = (int) (2 * Math.random()) + 1;
                            if (teamDeath == 1) {
                                groupSize--;
                                rivalDeaths++;
                            }
                            if (teamDeath == 2) {
                                teamLoss++;
                            }
                        }
                        pause = reader
                                .readLine("Enemy casualties: " + rivalDeaths);
                        pause = reader.readLine("Our casualties: " + teamLoss);
                        for (int whoDied = 0; whoDied < teamLoss; whoDied++) {
                            int victim = (int) (healthy.size() * Math.random());
                            pause = reader
                                    .readLine(healthy.get(victim).getName());
                            if (isPlague == true) {
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (healthy.get(victim) == nonCom
                                            .get(findSick)) {
                                        nonCom.remove(healthy.get(victim));
                                    }
                                }
                            }
                            names.remove(healthy.get(victim));
                            healthy.remove(victim);

                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Weather
                ////////////////////////////////////////////////////////////////////////////////////////////
                int WD = 0;
                int weather = (int) (1000 * Math.random()) + 1;
                if (weather == 306) {
                    int loseSanct = 0;
                    pause = reader.readLine(
                            "A REALLY bad storm snuck up on your group.");
                    if (inSanct == true) {
                        loseSanct = (int) (2 * Math.random()) + 1;
                        if (loseSanct == 1) {
                            System.out.println(sanctName + " has fallen.");
                            inSanct = false;
                            sanctOdds = 0;
                        }
                    }
                    for (int weatherKills = 0; weatherKills < names
                            .size(); weatherKills++) {
                        int weatherDeath = (int) (6 * Math.random()) + 1;
                        if (weatherDeath == 1) {
                            int weatherSave;
                            WD = (int) (5 * Math.random()) + 1;
                            weatherSave = (int) (10 * Math.random()) + 1;
                            if (WD == 1) {
                                if (weatherSave == 1) {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " was accidentally shot but was saved.");
                                    break;
                                } else {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " was accidentally shot.");
                                }
                            } else if (WD == 2) {
                                if (weatherSave == 1) {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " was bitten in the confusion but was still saved.");
                                    break;
                                } else {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " was bitten in the confusion.");
                                }
                            } else if (WD == 3) {
                                if (weatherSave == 1) {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " got lost during the storm but found their way back.");
                                    break;
                                } else {
                                    pause = reader.readLine(names
                                            .get(weatherKills).getName()
                                            + " got lost during the storm and was never seen again.");
                                }
                            } else if (weatherSave == 1) {
                                pause = reader.readLine(names.get(weatherKills)
                                        .getName()
                                        + " was hit by flying debris but survived.");
                                break;
                            } else {
                                pause = reader.readLine(names.get(weatherKills)
                                        .getName()
                                        + " was killed by flying debris.");
                            }
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(weatherKills) == nonCom
                                            .get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(weatherKills));
                                } else {
                                    contaminated
                                            .remove(names.get(weatherKills));
                                }
                            }
                            healthy.remove(names.get(weatherKills));
                            names.remove(weatherKills);
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Group break-away
                ////////////////////////////////////////////////////////////////////////////////////////////

                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Plague
                ////////////////////////////////////////////////////////////////////////////////////////////
                int plagueStart = (int) ((400 - names.size()) * Math.random())
                        + 1;// 400
                if (plagueStart == 1 && isPlague == false && names.size() > 3) {
                    for (int namesCopy = 0; namesCopy < names
                            .size(); namesCopy++) {
                        nonCom.add(names.get(namesCopy));
                    }
                    //int contract = (int)(100*((names.size()-contaminated.size())/(double)names.size())*Math.random())+1;
                    comunicability = (int) (20 * Math.random()) + 1;

                    lethality = (int) (10 * Math.random()) + 1;

                    double lethalOdds = ((1.0 / (12 - lethality)) * 100);
                    double survivalOdds = ((1.0 / (6 + lethality)) * 100);

                    double lethalPercent = (lethalOdds
                            / (lethalOdds + survivalOdds)) * 100;
                    double survivalPercent = (survivalOdds
                            / (lethalOdds + survivalOdds)) * 100;

                    pause = reader.readLine(
                            "A plague has started to sweep among the group.");
                    System.out.printf("Lethality: %%%.2f rate of death.\n",
                            lethalPercent);
                    System.out.printf("Survival rate: %%%.2f\n",
                            survivalPercent);
                    System.out.printf("Communicability: %%%.2f infectability.",
                            ((1.0 / comunicability) * 100));
                    pause = reader.readLine();
                    System.out.println();
                    for (int point0 = 0; point0 < 3; point0++) {
                        int person0 = (int) (nonCom.size() * Math.random());
                        pause = reader.readLine(nonCom.get(person0).getName()
                                + " has contracted the spreading disease.");
                        contaminated.add(nonCom.get(person0));
                        nonCom.remove(person0);
                        healthy.remove(contaminated.get(point0));

                    }
                    isPlague = true;
                    System.out.println();
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Sanctuary:
                ////////////////////////////////////////////////////////////////////////////////////////////
                int sanct = (int) (150 * Math.random()) + 1; //150
                if (sanct == 80 && inSanct == false) {
                    pause = reader.readLine("You found a sanctuary!!!!");
                    int trap = (int) (5 * Math.random()) + 1;
                    char enter = reader.readChar(
                            "Are you sure you want to enter this sanctuary? (Y)es (N)o: ");
                    if (enter == 'Y' || enter == 'y') {
                        if (trap == 1) {
                            int isGareth = (int) (5 * Math.random() + 1);
                            if (isGareth == 1 && isRivals == false) {
                                isRivals = true;
                                groupSize = 40;
                                pause = reader.readLine(
                                        "'Welcome to Terminus!\nCommunity for all, sanctuary for all.'");
                            } else {
                                System.out.println("IT WAS A TRAP!!!");
                            }

                            for (int e = 0; e < names.size(); e++) {
                                status = (int) (2 * Math.random()) + 1;
                                if (status == 2) {
                                    int hordeDeath = (int) (5 * Math.random())
                                            + 1;
                                    if (hordeDeath == 1 || hordeDeath == 3) {
                                        death = " was mowed down by men with machine guns.";
                                    } else if (hordeDeath == 2
                                            || hordeDeath == 4) {
                                        death = " was sniped by a marksman on the roof.";
                                    } else {
                                        death = " lost a 1v1 fist fight with an enemy.";
                                    }
                                    System.out.println(
                                            names.get(e).getName() + death);
                                    if (isPlague == true) {
                                        find = false;
                                        for (int findSick = 0; findSick < nonCom
                                                .size(); findSick++) {
                                            if (names.get(e) == nonCom
                                                    .get(findSick)) {
                                                find = true;
                                                break;
                                            }
                                        }
                                        if (find == true) {
                                            nonCom.remove(names.get(e));
                                        } else {
                                            contaminated.remove(names.get(e));
                                        }
                                    }
                                    healthy.remove(names.get(e));
                                    names.remove(e);
                                }
                            }
                        } else {
                            if (isPlague == true) {
                                pause = reader.readLine(
                                        "Your, currently sick, group was turned away.");
                            } else {
                                inSanct = true;
                                sanctOdds = (int) (30 * Math.random()) + 20;
                                System.out.println("SUCCESS!!!");
                                sanctName = reader.readLine(
                                        "What do you want to name this newfound sanctuary: ");
                                int sanctCitizens = (int) (10 * Math.random())
                                        + 20;
                                pause = reader
                                        .readLine("You found " + sanctCitizens
                                                + " living in the town.");
                                for (int addCit = 1; addCit <= sanctCitizens; addCit++) {
                                    addPerson = (int) (newPerson.size()
                                            * Math.random());
                                    pause = reader.readLine("Newcomer " + addCit
                                            + ": " + newPerson.get(addPerson));
                                    names.add(new Survivor(
                                            newPerson.get(addPerson), times));
                                    healthy.add(names.get(names.size() - 1));
                                    newPerson.remove(addPerson);
                                }
                            }
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////New people:
                ////////////////////////////////////////////////////////////////////////////////////////////
                int strangers = (int) (((2 * times) - (2 * sanctOdds))
                        * Math.random()) + 1;
                if (strangers == 1) {
                    int numStrangers;
                    if (names.size() >= 4) {
                        numStrangers = (int) ((names.size() / 4)
                                * Math.random()) + 1;
                    } else {
                        numStrangers = (int) (10 * Math.random()) + 1;
                    }

                    pause = reader.readLine("\nYou found " + numStrangers
                            + " new people who want to join your group!");

                    for (int d = 1; d <= numStrangers; d++) {
                        addPerson = (int) (newPerson.size() * Math.random());
                        pause = reader.readLine("Newcomer " + d + ": "
                                + newPerson.get(addPerson));
                        tempNames.add(
                                new Survivor(newPerson.get(addPerson), times));
                    }
                    char accept = reader.readChar(
                            "Do you want to accept these new members into your group? (Y)es (N)o: ");
                    if (accept == 'N' || accept == 'n') {
                        System.out.println("You turned away the travelers.");
                    } else {
                        int raiders;
                        if (names.size() >= 4) {
                            raiders = (int) (Math
                                    .abs((names.size() / 2.0) - numStrangers)
                                    * Math.random()) + 1;
                        } else {
                            raiders = (int) ((7 - (numStrangers / 2.0))
                                    * Math.random()) + 1;
                        }
                        //
                        if (raiders == 1) {
                            System.out.println(
                                    "They turned out to be raiders and attacked your group!!!");
                            for (int e = 0; e < names.size(); e++) {
                                status = (int) (3 * Math.random()) + 1;
                                if (status == 2) {
                                    int hordeDeath = (int) (5 * Math.random())
                                            + 1;
                                    if (hordeDeath == 1 || hordeDeath == 3) {
                                        death = " was stabbed by one of the raiders.";
                                    } else if (hordeDeath == 2
                                            || hordeDeath == 4) {
                                        death = " was shot by a raider.";
                                    } else {
                                        death = " was taken captive by the raiders and was never heard from again.";
                                    }
                                    System.out.println(
                                            names.get(e).getName() + death);
                                    if (isPlague == true) {
                                        find = false;
                                        for (int findSick = 0; findSick < nonCom
                                                .size(); findSick++) {
                                            if (names.get(e) == nonCom
                                                    .get(findSick)) {
                                                find = true;
                                                break;
                                            }
                                        }
                                        if (find == true) {
                                            nonCom.remove(names.get(e));
                                        } else {
                                            contaminated.remove(names.get(e));
                                        }
                                    }
                                    healthy.remove(names.get(e));
                                    names.remove(e);
                                }
                            }
                        } else {
                            System.out.println(
                                    "They were nice people and easily joined your ranks.");
                            for (int d = 0; d < numStrangers; d++) {
                                names.add(tempNames.get(d));
                                healthy.add(names.get(names.size() - 1));
                                if (isPlague == true) {
                                    nonCom.add(tempNames.get(d));
                                }
                                newPerson.remove(tempNames.get(d).getName());

                            }
                        }
                    }
                    tempNames.clear();
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Traitor:
                ////////////////////////////////////////////////////////////////////////////////////////////

                int traitor = (int) (250 * Math.random()) + 1;
                if (traitor == 1) {
                    int culprit = (int) (names.size() * Math.random());
                    String t = names.get(culprit).getName();
                    int traitorKills = 0;
                    pause = reader.readLine(
                            t + " has gone on a traitorous rampage!!!");
                    boolean killingSpree = true;
                    while (killingSpree == true && names.size() > 1) {
                        int rampage = (int) (names.size() * Math.random());
                        while (rampage == (culprit - traitorKills)) {
                            rampage = (int) (names.size() * Math.random());
                        }

                        int defense = (int) (4 * Math.random()) + 1;
                        if (defense == 1) {
                            pause = reader.readLine(t
                                    + "'s traitorous rampage came to an end when "
                                    + names.get(rampage).getName()
                                    + " killed them.");
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(culprit) == nonCom
                                            .get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(culprit));
                                } else {
                                    contaminated.remove(names.get(culprit));
                                }
                            }
                            healthy.remove(names.get(culprit));
                            names.remove(culprit);
                            killingSpree = false;
                        }

                        else {
                            pause = reader.readLine(names.get(rampage).getName()
                                    + " was killed by " + t + ".");
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(rampage) == nonCom
                                            .get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(rampage));
                                } else {
                                    contaminated.remove(names.get(rampage));
                                }
                            }
                            healthy.remove(names.get(rampage));
                            names.remove(rampage);
                        }
                        if (rampage < culprit) {
                            culprit--;
                        }
                    }

                }

                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Horde:
                ////////////////////////////////////////////////////////////////////////////////////////////
                int horde = (int) ((200 + sanctOdds) * Math.random()) + 1;
                if (horde == 30) {
                    pause = reader.readLine("HORDE!!!!");
                    if (inSanct == true) {
                        System.out.println(sanctName + " has fallen.");
                        inSanct = false;
                        sanctOdds = 0;
                    }
                    for (int e = 0; e < names.size(); e++) {
                        status = (int) (2 * Math.random()) + 1;
                        if (status == 2) {
                            int hordeDeath = (int) (5 * Math.random()) + 1;
                            if (hordeDeath == 1 || hordeDeath == 3) {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " was bitten by a walker.";
                                } else {
                                    pause = reader.readLine(names.get(e)
                                            .getName()
                                            + " was bitten but had their limb severed and survived.");
                                    break;
                                }
                            } else if (hordeDeath == 2 || hordeDeath == 4) {
                                death = " was surrounded and devoured by walkers.";
                            } else {
                                death = " was accidentally killed in the confusion.";
                            }
                            pause = reader
                                    .readLine(names.get(e).getName() + death);
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(e) == nonCom.get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(e));
                                } else {
                                    contaminated.remove(names.get(e));
                                }
                            }
                            healthy.remove(names.get(e));
                            names.remove(e);
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Plague deaths/infections
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (isPlague == true) {
                    if (nonCom.size() > 0) {
                        for (int spread = 0; spread < nonCom.size(); spread++) {
                            int contract = (int) (comunicability
                                    * Math.random()) + 1;
                            if (contract == 1) {
                                pause = reader.readLine(nonCom.get(spread)
                                        .getName()
                                        + " has contracted the spreading disease.");
                                healthy.remove(nonCom.get(spread));
                                contaminated.add(nonCom.get(spread));
                                nonCom.remove(spread);
                            }
                        }
                    }
                    System.out.println();
                    for (int plagueDeaths = 0; plagueDeaths < contaminated
                            .size(); plagueDeaths++) {
                        int plagueHeal = (int) ((6 + lethality) * Math.random())
                                + 1;
                        if (plagueHeal == 1) {
                            pause = reader.readLine(contaminated
                                    .get(plagueDeaths).getName()
                                    + " has healed from the spreading disease.");
                            healthy.add(contaminated.get(plagueDeaths));
                            contaminated.remove(plagueDeaths);
                            comunicability--;
                            continue;
                        }
                        int plagueKill = (int) ((12 - lethality)
                                * Math.random()) + 1;
                        if (plagueKill == 1) {
                            pause = reader.readLine(contaminated
                                    .get(plagueDeaths).getName()
                                    + " was killed by the spreading disease.");
                            names.remove(contaminated.get(plagueDeaths));
                            contaminated.remove(plagueDeaths);
                            comunicability--;
                        }
                    }
                    System.out.println("Current people contaminated:\n");
                    for (int showCon = 0; showCon < contaminated
                            .size(); showCon++) {
                        System.out.println(contaminated.get(showCon).getName());
                    }
                    System.out.println();
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Rivals deaths
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (isRivals == true) {
                    //int rivalsDead = 0;
                    for (int rivalDeaths = 0; rivalDeaths < groupSize; rivalDeaths++) {
                        int indiRival = (int) (30 * Math.random()) + 1;
                        if (indiRival == 1) {
                            groupSize--;
                            //rivalsDead++;
                        }
                    }
                    for (int e = 0; e < names.size(); e++) {

                        status = (int) ((20 + (times - (names.get(e).joined()))
                                + (2 * names.size()) + (5 * sanctOdds))
                                * Math.random()) + 1;

                        if (status == 100) {
                            int killed = (int) (10 * Math.random()) + 1;

                            if (killed == 1) {
                                death = " commited suicide.";
                            }
                            if (killed == 2) {
                                death = " ran away to save their life.";
                            }
                            if (killed == 3 || killed == 4 || killed == 5) {
                                int sever = (int) (30 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 30) {
                                    death = " was bitten by a walker.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " was bitten but had their limb severed and survived.");
                                    break;
                                }
                            }
                            if (killed == 6 || killed == 7) {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " was taken hostage and killed by the enemy.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " was taken hostage by the enemy but released.");
                                    break;
                                }
                            }
                            if (killed == 8 || killed == 9 || killed == 10) {
                                death = " was killed by an enemy trap.";
                            } else {
                                death = " was shot by the enemy.";
                            }

                            System.out.println(names.get(e).getName() + death);
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(e) == nonCom.get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(e));
                                } else {
                                    contaminated.remove(names.get(e));
                                }
                            }
                            healthy.remove(names.get(e));
                            names.remove(e);
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////Normal deaths
                ////////////////////////////////////////////////////////////////////////////////////////////
                else {
                    for (int e = 0; e < names.size(); e++) {

                        status = (int) ((50
                                + (2 * times - names.get(e).joined())
                                + (3 * names.size()) + (5 * sanctOdds))
                                * Math.random()) + 1;

                        if (status == 100) {
                            int killed = (int) (20 * Math.random()) + 1;

                            if (killed == 1) {
                                int sever = (int) (30 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 30) {
                                    death = " was killed by a crazy man.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " was attacked by a crazy man but fended him off.");
                                    break;
                                }
                            } else if (killed == 2) {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " was murdered by a group of people.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " was attacked by a group of people but escaped.");
                                    break;
                                }
                            } else if (killed == 3) {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " died from an unknown disease.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " contracted an unknown disease but healed.");
                                    break;
                                }
                            } else if (killed == 4) {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " died from an infected cut.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " got an infected cut but some antibiotics did the trick.");
                                    break;
                                }
                            } else if (killed == 5) {
                                death = " died of starvation.";
                            } else if (killed == 6) {
                                death = " died from dehydration.";
                            } else if (killed == 7) {
                                death = " got lost and was never seen again.";
                            } else if (killed == 8) {
                                death = " commited suicide.";
                            } else if (killed == 9) {
                                death = " commited suicide.";
                            } else if (killed == 10) {
                                death = " commited suicide.";
                            } else {
                                int sever = (int) (10 * Math.random()) + 1;
                                if (sever >= 2 && sever <= 10) {
                                    death = " was bitten by a walker.";
                                } else {
                                    System.out.println(names.get(e).getName()
                                            + " was bitten but had their limb severed and survived.");
                                    break;
                                }
                            }
                            System.out.println(names.get(e).getName() + death);
                            if (isPlague == true) {
                                find = false;
                                for (int findSick = 0; findSick < nonCom
                                        .size(); findSick++) {
                                    if (names.get(e) == nonCom.get(findSick)) {
                                        find = true;
                                        break;
                                    }
                                }
                                if (find == true) {
                                    nonCom.remove(names.get(e));
                                } else {
                                    contaminated.remove(names.get(e));
                                }
                            }
                            healthy.remove(names.get(e));
                            names.remove(e);
                        }
                    }
                }
                ////////////////////////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////////////////////////End of day:
                ////////////////////////////////////////////////////////////////////////////////////////////
                if (isPlague) {
                    pause = reader.readLine(
                            "\nPress enter, info, stop, healthy, or execute to kill all diseased...");
                } else {
                    pause = reader.readLine(
                            "\nPress enter, info, stop, or healthy...");
                }
                if (pause.equals("execute")) {
                    for (int lr = 0; lr < contaminated.size(); lr++) {
                        pause = reader.readLine(
                                "Executed " + contaminated.get(lr).getName());
                        names.remove(contaminated.get(lr));
                    }
                    contaminated.clear();

                    int didEx = (int) (3 * Math.random()) + 1;
                    if (didEx == 1) {
                        pause = reader.readLine("\nBut it didn't work.");
                        System.out.println();
                        for (int point0 = 0; point0 < 3; point0++) {
                            int person0 = (int) (nonCom.size() * Math.random());
                            pause = reader.readLine(nonCom.get(person0)
                                    .getName()
                                    + " has contracted the spreading disease.");
                            contaminated.add(nonCom.get(person0));
                            nonCom.remove(person0);
                            healthy.remove(contaminated.get(point0));

                        }
                    }
                }
                if (pause.equals("stop") || pause.equals("Stop")) {
                    break;
                }
                if (pause.equals("Info") || pause.equals("info")) {
                    for (int listNames = 0; listNames < names
                            .size(); listNames++) {
                        System.out.println((listNames + 1) + ") "
                                + names.get(listNames).getName());
                        if (names.get(listNames).joined() == 0) {
                            System.out.println("Day Joined: Core Group");
                        } else {
                            System.out.println("Day Joined: "
                                    + names.get(listNames).joined());
                        }
                        System.out.println("===========================");
                    }
                    pause = reader.readLine("Press enter to continue...");
                }

                if (pause.equals("Healthy") || pause.equals("healthy")) {
                    for (int listNames = 0; listNames < healthy
                            .size(); listNames++) {
                        System.out.println((listNames + 1) + ") "
                                + healthy.get(listNames).getName());
                    }
                    pause = reader.readLine("Press enter to continue...");
                }
            } //For repeating days
            if (names.size() >= 300) {
                System.out.println(
                        "Congratulations! You have gathered enough survivors together to start a new civilization.");
                System.out.println(
                        "You are now able to rebuild, with YOU as their leader, to bring humanity back from");
                System.out.println(
                        "the edge of extinction. Now you can create a whole new world, in your own image.");
                System.out.println(
                        "Stories will be told about your perils, your journey, your struggles, and your rise to power.");
            }
            if (times == finish) {
                System.out.println(
                        "You hear the sound of helicopter blades overhead and the sound of a radio a couple yards away.");
                System.out.println(
                        "You turn around and see a foreign army approaching your group telling you to 'remain calm'.");
                System.out.println(
                        "Tears fill your eyes as you relize you've survived the apparent apocalypse, you're finally free.");
                System.out.println("The survivors:");
                for (int listNames = 0; listNames < names.size(); listNames++) {
                    System.out.println((listNames + 1) + ") "
                            + names.get(listNames).getName());
                }
            }
            healthy.clear();
            pause = reader.readLine("Press enter to start over...");
            continue;
        } //For repeating game

    } //Original curly bracket
} //Original curly bracket