import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        //Variables for Galvanized Crosshairs
        char galvChoice;
        double galvCross = 0;

        //Variable for the weapon's base crit chance
        double baseCrit;

        //Variables to determine the main crit chance mod
        int critMod;
        double modCritChance = 0;

        //Variables for Archon Shards
        char archonChoice;
        int archonShards = 0;
        int tauforged = 0;

        //Variables for Arcane Avenger
        char arcaneChoice;
        int arcaneAvenger = 0;

        //Variables for the riven
        char rivenChoice;
        double riven = 0;

        //Program starts
        System.out.println("Input the following:");
        System.out.println(" ");

        System.out.println("Base weapon crit chance:");
        baseCrit = read.nextDouble();
        System.out.println(" ");

        System.out.println("Crit chance mod (Use numbers):");
        System.out.println("1. Pistol Gambit | 2. Primed Pistol Gambit | 3. Critical delay | 4. None");
        critMod = read.nextInt();
        System.out.println(" ");

        switch (critMod){

            case 1 -> modCritChance = 1.2;

            case 2 -> modCritChance = 1.87;

            case 3 -> modCritChance = 2;

            case 4 -> modCritChance = 0;

        }

        System.out.println("Using Galvanized Crosshairs? (Y / N):");
        galvChoice = read.next().charAt(0);
        System.out.println(" ");

        if (galvChoice == 'Y' || galvChoice == 'y') galvCross = 3.2;

        System.out.println("Using a crit chance Riven? (Y / N):");
        rivenChoice = read.next().charAt(0);
        System.out.println(" ");

        if (rivenChoice == 'Y' || rivenChoice == 'y') {

            System.out.println("Input the riven crit chance (if it's 123%, write it as 1.23):");
            riven = read.nextDouble();
            System.out.println(" ");
        }

        System.out.println("Using Secondary Crit Chance Archon Shards? (Y / N):");
        archonChoice = read.next().charAt(0);
        System.out.println(" ");

        if (archonChoice == 'Y' || archonChoice == 'y'){

            while (archonShards == 0 || archonShards > 5) {

                System.out.println("How many?");
                archonShards = read.nextInt();
                System.out.println(" ");

                if (archonShards <= 0 || archonShards > 5) System.out.println("Please input a valid number of Archon Shards (Max.5)");
            }

            do {

                System.out.println("How many of them are Tauforged?");
                tauforged = read.nextInt();
                System.out.println(" ");

                if (tauforged > archonShards) System.out.println("Number of Tauforged shards can't exceed number of Archon Shards.");

            } while (tauforged > archonShards);

            archonShards -= tauforged;
        }

        System.out.println("Using Arcane Avenger? (Y / N):");
        arcaneChoice = read.next().charAt(0);
        System.out.println(" ");

        if (arcaneChoice == 'Y' || arcaneChoice == 'y') arcaneAvenger = 45;

        //Results
        System.out.println("Your final crit chance (with all stacks maxed) will be:");
        System.out.println((baseCrit) * (1 + modCritChance + galvCross + 2 + (0.25 * archonShards) + (0.375 * tauforged) + riven) + arcaneAvenger);
        System.out.println(" ");
        System.out.println("If not using Yareli:");
        System.out.println((baseCrit) * (1 + modCritChance + galvCross + (0.25 * archonShards) + (0.375 * tauforged) + riven) + arcaneAvenger);

    }
}