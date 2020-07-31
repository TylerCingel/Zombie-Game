// Tyler Cingel
// Cingel_NameGenerator
// Holds an array of names for making survivor objects

/* Improvements:
 *  Organize somehow and differ males and females
 */

/* The honorary list of true survivors:
 * Tyler
 * Carol
 * Ed
 * Randy
 * Charnae
 * Brianna
 * Caitlin
 */

import java.util.ArrayList;

public class Cingel_NameGenerator {
    public ArrayList<String> newcomer() {
        String[] nameGenerator = {
                //Top female baby names of 2015
                "Sophia", "Emma", "Olivia", "Ava", "Mia", "Isabella", "Zoe",
                "Lily", "Emily", "Madison", "Amelia", "Riley", "Madelyn",
                "Charlotte", "Chloe", "Aubrey", "Aria", "Layla", "Avery",
                "Abigail", "Harper", "Kaylee", "Aaliyah", "Evelyn", "Adalyn",
                "Ella", "Arianna", "Hailey", "Ellie", "Nora", "Hannah",
                "Addison", "Mackenzie", "Brooklyn", "Scarlett", "Anna", "Mila",
                "Audrey", "Isabelle", "Elizabeth", "Leah", "Sarah", "Lillian",
                "Grace", "Natalie", "Kylie", "Lucy", "Makayla", "Maya",
                "Victoria", "Elena", "Lila", "Maria", "Savannah", "Claire",
                "Penelope", "Alaina", "Violet", "Kennedy", "Gabriella",
                "Eliana", "Skyler", "Paisley", "Camilla", "Annabelle",
                "Adeline", "Stella", "Allison", "Alice", "Alyssa", "Liliana",
                "Reagan", "Charlie", "Callie", "Vivian", "Jocelyn", "Samantha",
                "Caroline", "Eleanor", "Julia", "Sophie", "Sadie", "Peyton",
                "Cora", "Juliana", "Brittney", "Eva", "Keira", "Haze",
                "Kinsley", "Clara", "Katherine", "Alexandra", "Isla", "London",
                "Jordyn", "Kayla", "Bailey", "Emery", "Taylor", "Paige",
                "Lindsey",

                //Top male baby names of 2015
                "Jackson", "Aiden", "Liam", "Lucas", "Noah", "Mason", "Ethan",
                "Caden", "Logan", "Jacob", "Jayden", "Oliver", "Elijah",
                "Alexander", "Michael", "Carter", "James", "Caleb", "Benjamin",
                "Jack", "Luke", "Grayson", "William", "Ryan", "Connor",
                "Daniel", "Gabriel", "Owen", "Henry", "Matthew", "Isaac",
                "Wyatt", "Jayce", "Cameron", "Landon", "Nicholas", "Dylan",
                "Nathan", "Muhammad", "Sebastian", "Eli", "Brayden", "Andrew",
                "Joshua", "Samuel", "Hunter", "Anthony", "Julian", "Dominic",
                "Christian", "Levi", "Joseph", "Colton", "Isaiah", "Max", "Ian",
                "Evan", "Adam", "Thomas", "Gavin", "Aaron", "Jonathan",
                "Lincoln", "Christopher", "Miles", "Leo", "Nolan", "Parker",
                "Hudson", "Adrian", "Josiah", "Austin", "Cooper", "Carson",
                "Chase", "Tyler", "Jason", "Zachary", "Charlie", "Jeremiah",
                "Alex", /* "Jordan", */"Mateo", "Tristan", "Asher", "Camden",
                "Xavier", "Easton", "Micah", "Cole", "Declan", "Nathaniel",
                "Brody", "Marshal", "Blake", "Ezra", "Damian", "Xander",
                "Elliot",

                //The Walking Dead
                "Rick *", "Carl *", "Lori *", "Carol *", "Ed *", "Sophia *",
                "Amy *", "Andrea *", "Dale *", "Daryl *", "Merle *", "Jim *",
                "Jaqui *", "Moralas *", "Glenn *", "T-Dogg *", "Shane *",

                "Hershel *", "Maggie *", "Beth *", "Jimmy *", "Otis *",
                "Patricia *", "Michonne *", "Oscar *", "Axel *", "Andrew *",
                "Big-Tiny *", "Tyreese *", "Sasha *", "Bob *", "Karren *",
                "Caleb *", "Lizzy *", "Mika *", "Judith *", "Gabriel *",
                "Tara *", "Abraham *", "Eugene *", "Rosita *", "Aaron *",
                "Eric *", "Deanna *", "Redge *", "Spencer *", "Jessie *",
                "Pete *", "Ron *", "Sam *", "Nicholas *", "Aiden *", "Enid *",
                "Holly *", "Olivia *", "Carter *", "Heath *", "Denise *",
                "Paul *", "Gregory *", "Carson *", "Earl *", "Eduardo *",
                "Brianna *", "Wesley *", "Mandy *", "Samuel *", "Crystal *",
                "Andy *", "Alex *", "Richard *", "Arnold *", "Marco *",
                "Rolland *", "Dante *", "Larry *", "Kal *", "Ken *", "Louie *",
                "Amber *", "Edwin *", /*
                                       * ,"Brian *","Penny *","Lilly *"
                                       * ,"Martinez *","Gareth *","Negan *"
                                       * ,"Dwight *",
                                       */

                //50 Most common names
                "James", "Christopher", "Ronald", "Mary", "Lisa", "Michelle",
                "Daniel", "Nancy", "Laura", "Robert", "Kevin", "Linda", "Karen",
                "Michael", "Mark", "Jason", "Barbara", "Betty", "Kimberly",
                "William", "Donald", "Jeff", "Elizabeth", "Helen", "Deborah",
                "George", "Jennifer", "Sandra", "Richard", "Kenneth", "Maria",
                "Donna", "Charles", "Steven", "Susan", "Joseph", "Edward",
                "Margaret", "Ruth", "Thomas", "Dorothy", "Sharon", "Andrew",

                //2014-15 Freshman (most of)
                "Machayla", "Joshua", "Kristina", "Timothy", "Jordan", "Anaja",
                "Marika", "Dean", "Taleen", "Lynne", "Donovan", "Gabrielle",
                "Noah", "Devin", "Ryan", "Morgan", "Caitlin", "Dayton",
                "Amanda", "Jason", "Ryan", "Hannah", "Jaret", "Deaunna",
                "Sydney", "McKenna", "Isaiah", "Nathan", "Michelle", "Vinay",
                "Morgan", "Kathrine", "Samuel", "Julian", "Margaret", "Charnae",
                "Ariel", "Lucas", "Carla", "Forrest", "Thalia", "Marni",
                "Danielle", "Nadia", "Sincere", "Joseph", "Nathaniel", "Andy",
                "Nicole", "Carly", "Thomas", "Eshan", "Marquis", "Christina",
                "Elise", "Megan", "Lindsay", "Tyrone", "Amir", "Alessandra",
                "Chancellor", "Jacob", "Alexandra", "Sabatino", "Jessica",
                "Isabel", "Courtney", "Maya", "Alexander", "Jesse", "Jared",
                "Emma", "Jillian", "Hailey", "Alyssa", "Alana", "Jocelyn",
                "Brian", "Michael", "Jenna", "Charles", "Hallie", "Geoffrey",
                "Randy", "Mollie", "Kyleah", "Bradley", "Luisana", "Zara",
                "Taylor", "Mark", "Juliana", "Madison", "Adam", "Alexis",
                "Jamie", "Bailey", "Lisa", "Maxwell", "Darius", "Randolph",
                "Kiley", "Justin", "Peyton", "Emily", "Benjamin", "Katelyn",
                "Erin", "Stephen", "David", "Dianna", "Corey", "Eaton", "Zoe",
                "Brandon", "Mona", "Ali", "Cassidy", "Jasmine", "Maria", "Anna",
                "Joslyn", "Michelle", "Adrienne", "Jasen", "Lauryn", "Rachel",
                "Grace", "Jessica", "Mathew", "Sarah", "Max", "Dylan", "Ashley",
                "Arnold", "Lauren", "Cate", "Casey", "Daniela", "Dwayne",
                "Alfred", "Kyle", "Laurel", "Victor", "Jack", "Bridget",
                "Jonah", "Kaitlyn", "Harrison", "Brennan", "Jennifer", "Chris",
                "Autumn", "Kaylan", "Lainey", "Kendal", "Jay", "Rachel",
                "Felicity", "Elijah", "Pauline", "Luke", "Clara", "Samantha",
                "Alysa", "Lillian", "William", "Grant", "Molly", "James",
                "Ryan", "Marianna", "Connor", "Roni", "Mackenzie", "Matteo",
                "Troy", "Deandre", "Arielle", "Polina", "Lexi", "Dominic",
                "Claudia", "Daniel", "Brianna", "Chiara", "Chantz", "Derek",
                "Brooke", "Jeremiah", "Thomas", "Alice", "Ann", "Cyrus",
                "Vincent", "Kayla", "Lewis", "Alexa", "Selin"

        };
        ArrayList<String> copyNames = new ArrayList<String>();
        for (int generatorCopy = 0; generatorCopy < nameGenerator.length; generatorCopy++) {
            copyNames.add(nameGenerator[generatorCopy]);
        }
        return copyNames;
    }
}