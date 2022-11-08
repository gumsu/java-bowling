package bowling;

public class FinalFrame implements Frame {

    private FinalThrown finalThrown;
    private Pins bonusPins;

    private FinalFrame(FinalThrown finalThrown) {
        this.finalThrown = finalThrown;
    }

    public static FinalFrame of(int countOfPins) {
        return new FinalFrame(new FinalThrown(Pins.from(countOfPins)));
    }

    public Frame bonusBowl(int countOfPins) {
        bonusPins = Pins.from(countOfPins);
        return this;
    }

    @Override
    public boolean isFinished() {
        if (bonusPins != null) {
            return true;
        }

        if (secondPins() != 0 && getScore() != 10) {
            return true;
        }

        return false;
    }

    @Override
    public Frame bowl(int countOfPins) {
        finalThrown.bowl(countOfPins);
        return this;
    }

    @Override
    public boolean isFinalFrame() {
        return true;
    }

    @Override
    public int getScore() {
        if (bonusPins == null) {
            return finalThrown.getScore();
        }
        return finalThrown.getScore() + bonusPins.getFalledPins();
    }

    @Override
    public int firstPins() {
        return finalThrown.firstPins();
    }

    @Override
    public int secondPins() {
        return finalThrown.secondPins();
    }

    @Override
    public boolean hasTurn() {
        return finalThrown.hasTurn();
    }
}
