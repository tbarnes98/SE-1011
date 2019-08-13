package barnestr;

import java.util.Scanner;

public class Lab07 {

    public static void main(String[] args) {
        String result = "";
        Scanner in = new Scanner(System.in);
        // TODO
        // game loop
        do {
            // print the introduction and rules
            intro();
            // initialize game
            Mugwump mugwump = new Mugwump();
            Warrior warrior = new Warrior();
            // while neither combatant has lost all of their hit points, battle!
            while (mugwump.getHitPoints() > 0 && warrior.getHitPoints() > 0) {
                result = battle(warrior, mugwump, in);
                report(warrior, mugwump);
            }
            victory(result);
            // declare the winner
            // ask to play again
        } while (playAgain(in));
        // Thank the user for playing your game
        System.out.println("Thank you for playing Battle Simulator 3000!");
    }

    /**
     * This method displays the introduction to the game and gives a description of the rules.
     */
    private static void intro() {
        // TODO
        System.out.println("Welcome to Battle Simulator 3000! " +
                "The world's more low tech battle simulator!\n" +
                "You are a Valiant Warrior defending your humble village from an evil Mugwump! " +
                "Fight bravely, \n" +
                "or the citizens of your town will be the Mugwump's dinner!\n");
        System.out.println("You have your Trusty Sword, which deals decent damage, " +
                "but can be tough to hit with sometimes. \n" +
                "You also have your Shield of Light, which is not as strong as your sword, " +
                "but is easier to deal \n" +
                "damage with.\n" +
                "Let the epic battle begin!");
    }

    /**
     * This method handles the battle logic for the game.
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     * @return The name of the victor, or "none", if the battle is still raging on
     */
    private static String battle(Warrior warrior, Mugwump mugwump, Scanner in) {
        // determine who attacks first
        int initiative = initiative();
        int warriorDamage = warrior.attack(attackChoice(in));
        int mugwumpDamage = mugwump.attack();
        // attack!
        if (initiative == 1) {
            mugwump.takeDamage(warriorDamage);
            System.out.println("The Mugwump took " + warriorDamage + " point(s) of damage");
            if (mugwump.getHitPoints() >= 0) {
                warrior.takeDamage(mugwumpDamage);
                System.out.println("The Warrior took " + mugwumpDamage + " point(s) of damage");
            }
        } else if (initiative == 2) {
            warrior.takeDamage(mugwumpDamage);
            System.out.println("The Warrior took " + mugwumpDamage + " point(s) of damage");
            if (warrior.getHitPoints() >= 0) {
                mugwump.takeDamage(warriorDamage);
                System.out.println("The Mugwump took " + warriorDamage + " point(s) of damage");

            }
        }
        if (warrior.getHitPoints() <= 0) {
            return "mugwump";
        } else if (mugwump.getHitPoints() <= 0) {
            return "warrior";
        } else {
            return "none";
        }
    }

    /**
     * This method reports the status of the combatants before each new round
     *
     * @param warrior The Warrior of Light!
     * @param mugwump The Evil Mugwump!
     */
    private static void report(Warrior warrior, Mugwump mugwump) {
        // TODO
        System.out.println("Warrior HP: " + warrior.getHitPoints());
        System.out.println("Mugwump HP: " + mugwump.getHitPoints());
    }

    /**
     * This method asks the user what attack type they want to use and returns the result
     *
     * @return 1 for sword, 2 for shield
     */
    private static int attackChoice(Scanner in) {
        while (true) {
            System.out.println("How would you like to attack? " +
                    "('1' for Trusty Sword or '2' for Shield of Light!)");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                return 1;
            } else if (choice == 2) {
                return 2;
            }
        }
    }

    /**
     * Determines which combatant attacks first, displays and returns the result.
     *
     * @return 1 if the warrior goes first, 2 if the mugwump goes first
     */
    private static int initiative() {
        Die d10 = new Die(10);
        int warriorRoll;
        int mugwumpRoll;
        d10.roll();
        warriorRoll = d10.getCurrentValue();
        d10.roll();
        mugwumpRoll = d10.getCurrentValue();
        do {
            if (warriorRoll > mugwumpRoll) {
                return 1;
            } else if (mugwumpRoll > warriorRoll) {
                return 2;
            }
        } while (true);
    }

    /**
     * This method declares the winner of the epic battle
     *
     * @param winner the name of the winner of the epic battle
     */
    private static void victory(String winner) {
        // TODO
        if (winner.equals("warrior")) {
            System.out.println("The citizens cheer and invite you back to town " +
                    "for a feast as thanks for saving their lives (again)!\n");
        } else {
            System.out.println("You lost! The Mugwump has defeated you and feasted " +
                    "on the village people!");
        }
    }

    /**
     * This method asks the user if they would like to play again
     *
     * @param in Scanner
     * @return true if yes, false otherwise
     */
    private static boolean playAgain(Scanner in) {
        System.out.println("Would you like to play again?");
        String choice = in.nextLine();
        if (choice.equals("yes") || choice.equals("Yes") ||
                choice.equals("y") || choice.equals("Y")) {
            return true;
        }
        return false;
    }
}