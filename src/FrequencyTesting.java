
public class FrequencyTesting {
    public static void main(String[] args) {
        KeyboardReader reader = new KeyboardReader();
        int numTests = 1000000;
        int sum = 0;
        int numRolls = 4;
        int[] rolls = new int[3];
        int numTotal = 9;
        int[] stats = new int[6];
        boolean takeLow = false;
        boolean print = false;

        do {
            System.out.print("Number of dice per stat: ");
            numRolls = reader.readInt();
            System.out.print("Number of stats: ");
            numTotal = reader.readInt();
            sum = 0;
            rolls = new int[3];
            stats = new int[6];
            for (int i = 0; i < numTests; i++) {
                for (int x = 0; x < numTotal; x++) {
                    for (int y = 0; y < numRolls; y++) {
                        if (y < rolls.length) {
                            rolls[y] = (int) (Math.random() * 6) + 1;
                            if (print) {
                                System.out.println("Dice Roll: " + rolls[y]);
                                System.out.println("Does not need to replace");
                            }
                        } else {
                            int temp = (int) (Math.random() * 6) + 1;
                            if (print) {
                                System.out.println("Dice Roll: " + temp);
                            }
                            int index = indexFind(rolls, takeLow);
                            if (takeLow && rolls[index] < temp) {
                                if (print) {
                                    System.out.println(
                                            "Replaces " + rolls[index]);
                                }
                                rolls[index] = temp;
                            }
                            if (!takeLow && rolls[index] > temp) {
                                if (print) {
                                    System.out.println(
                                            "Replaces " + rolls[index]);
                                }
                                rolls[index] = temp;
                            }
                        }
                    }

                    if (x < 6) {
                        stats[x] = sumList(rolls);
                        if (print) {
                            System.out.println("Stat: " + stats[x]);
                            System.out.println("Does not need to replace");
                        }
                    } else {
                        int stat = sumList(rolls);
                        if (print) {
                            System.out.println("Stat: " + stat);
                        }
                        int index = indexFind(stats, takeLow);
                        if (takeLow && stats[index] < stat) {
                            if (print) {
                                System.out.println("Replaces " + stats[index]);
                            }
                            stats[index] = stat;
                        }
                        if (!takeLow && stats[index] > stat) {
                            if (print) {
                                System.out.println("Replaces " + stats[index]);
                            }
                            stats[index] = stat;
                        }
                    }
                    if (print) {
                        System.out.println();
                    }
                }
                if (print) {
                    System.out.println("===========================");
                    for (int j = 0; j < stats.length; j++) {
                        System.out.println(stats[j]);
                    }
                    System.out.println("===========================");
                }
                int avg = sumList(stats);
                sum += avg;
                if (print) {
                    System.out.println("Average: " + (avg / 6.0));
                }
            }
            System.out.println("Total Average: " + sum / (6.0 * numTests));

        } while (numRolls != -1);
    }

    public static int indexFind(int[] list, boolean low) {
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (low) {
                if (list[i] < list[index]) {
                    index = i;
                }
            } else {
                if (list[i] > list[index]) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static int sumList(int[] list) {
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        return sum;
    }
}
