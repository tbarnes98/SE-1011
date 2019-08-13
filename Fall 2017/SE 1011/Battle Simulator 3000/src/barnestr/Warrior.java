package barnestr;

public class Warrior {
    private int hitPoints;
    private Die d20;
    private Die d10;
    private Die d8;
    private Die d4;

    public Warrior() {
        d20 = new Die(20);
        d10 = new Die(10);
        d8 = new Die(8);
        d4 = new Die(4);
        rollHitPoints();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    private int rollHitPoints() {
        for (int i = 6; i > 0; i--) {
            d10.roll();
            hitPoints = hitPoints + d10.getCurrentValue();
        }
        return hitPoints;
    }

    public void takeDamage(int hp) {
        hitPoints = hitPoints - hp;
    }

    public int attack(int type) {
        int damage = 0;
        d20.roll(); // roll for attack chance
        if (type == 1) {
            if (d20.getCurrentValue() >= 12) {
                for (int i = 2; i > 0; i--) {
                    d8.roll();
                    damage = damage + d8.getCurrentValue();
                }
            }
        } else if (type == 2) {
            if (d20.getCurrentValue() >= 8) {
                d4.roll();
                damage = damage + d4.getCurrentValue();

            }
        }
        // roll attack die

        // determine results of attack

        // return the damage
        return damage;
    }
}
