package barnestr;

public class Die {
    private int numSides;
    private int currentValue;

    public Die(int sides) {
        this.numSides = sides; // Number of sides on die
        roll(); // Rolls die to decide currentValue
    }

    public int getNumSides() {
        return numSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public void roll() {
        currentValue = ((int) (Math.random() * numSides)) + 1;
    }

}
