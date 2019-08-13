package barnestr;

public class Mugwump {
    // add methods here
    private int hitPoints;
    private int maxHitPoints;
    private Die d100;
    private Die d20;
    private Die d10;
    private Die d6;

    public Mugwump() {
        d100 = new Die(100);
        d20 = new Die(20);
        d10 = new Die(10);
        d6 = new Die(6);
        hitPoints = rollHitPoints();
        maxHitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void takeDamage(int hp) {
        hitPoints = hitPoints - hp;
    }

    /**
     * This method handles the attack logic
     *
     * @return the amount of damage an attack has caused, 0 if the attack misses or the Mugwump heals
     */
    public int attack() {
        int damage = 0;
        // get attack type from ai
        d20.roll(); // roll for attack chance
        if (ai() == 1) {
            if (d20.getCurrentValue() >= 12) {
                for (int i = 2; i > 0; i--) {
                    d6.roll();
                    damage = damage + d6.getCurrentValue();
                }
            }
        } else if (ai() == 2) {

            if (d20.getCurrentValue() >= 16) {
                for (int i = 3; i > 0; i--) {
                    d6.roll();
                    damage = damage + d6.getCurrentValue();
                }
            }
        } else if (ai() == 3) {
            d6.roll();
            if (hitPoints + d6.getCurrentValue() >= maxHitPoints) {
                hitPoints = maxHitPoints;
            } else {
                hitPoints = hitPoints + d6.getCurrentValue();
            }
        }
        // roll attack die

        // determine results of attack

        // return the damage
        return damage;
    }

    private int rollHitPoints() {
        for (int i = 10; i > 0; i--) {
            d10.roll();
            hitPoints = hitPoints + d10.getCurrentValue();
        }
        return hitPoints;
    }

    /**
     * This method determines what action the Mugwump performs
     *
     * @return 1 for a Claw attack, 2 for a Bite, and 3 if the Mugwump licks its wounds, instead
     */
    private int ai() {
        d100.roll();
        if (d100.getCurrentValue() < 75) {
            // 75% Chance of a claw attack
            return 1;
        } else if (75 < d100.getCurrentValue() && d100.getCurrentValue() < 91) {
            // 15% Chance of a fang attack
            return 2;
        } else {
            // 10% Chance of Mugwump heal
            return 3;
        }

    }
}
