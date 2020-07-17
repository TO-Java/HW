package HW20200713;

import java.util.Scanner;

public class LeagueStanding {

    // Scanner
    private static Scanner in = new Scanner(System.in);

    // Data structure of the standing
    // Names
    private static String[] names;
    // Points
    private static int[] points;
    // Goals for
    private static int[] gf;
    // Goals against
    private static int[] ga;

    public static void main(String[] args) {

        // Create the standing
        createStanding();

        // Operate on the table
        int choice = getChoice();

        while (choice != 0) {

            // HW 1 - to if
            switch (choice) {
                // Insert new result
                case 1:
                    insertNewResult();
                    break;
                // Display table
                case 2:
                    displayTable();
                    break;
            }
            choice = getChoice();
        }
    }

    private static void insertNewResult() {
        System.out.print("Enter HomeTeam AwayTeam HomeGoals AwayGoals >> ");
        String homeTeamName = in.next();
        String awayTeamName = in.next();
        int homeGoals = in.nextInt();
        int awayGoals = in.nextInt();

        // HW 2 - to if
        int homePoints = (homeGoals > awayGoals) ? 3 : (homeGoals == awayGoals) ? 1 : 0;

        // HW 3 - to short
        int awayPoints;
        if (homePoints == 1) {
            awayPoints = 1;
        } else {
            awayPoints = 3 - homePoints;
        }

        // update home team tables
        doChange(homeTeamName, homePoints, homeGoals, awayGoals);
        doChange(awayTeamName, awayPoints, awayGoals, homeGoals);
    }

    private static int getIndexByName(String name) {
        for (int i = 0; i < names.length; ++i) {
            if (names[i].equals(name)) {
                // found
                return i;
            }
        }
        // not found
        return -1;
    }

    private static void doChange(String name, int pts, int gfor, int gagainst) {
        int idx = getIndexByName(name);
        points[idx] += pts;
        gf[idx] += gfor;
        ga[idx] += gagainst;

    }

    private static void displayTable() {
        // HW 3 - use print
        System.out.format("name\tpoints\tgf\tga\n");
        for (int i = 0; i < names.length; ++i) {
            System.out.format("%s\t\t%d\t\t%d\t%d\n", names[i], points[i], gf[i], ga[i]);
        }
    }

    private static void createStanding() {
        // read standings size
        System.out.print("How many noOfTeams do you want >> ");
        int noOfTeams = in.nextInt();

        // create tables
        names = new String[noOfTeams];
        points = new int[noOfTeams];
        gf = new int[noOfTeams];
        ga = new int[noOfTeams];

        // HW 4 - use i = 1 to noOfTeams
        // read team names
        for (int i = 0; i < noOfTeams; ++i) {
            System.out.print("Enter team[" + (i + 1) + "] name >> ");
            names[i] = in.next();
        }
    }

    private static int getChoice() {
        System.out.println("0. Exit");
        System.out.println("1. New result");
        System.out.println("2. Display standings");
        System.out.print("Enter option >> ");
        int choice = in.nextInt();
        return choice;
    }
}
