package logic;

public class AnalogStrategy implements EmulationStrategy {

    private int skippingTicks;
    private int counter = 0;
    private int value = 0;
    private int minValue;
    private int maxValue;
    private int direction = 1;

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.value = minValue;
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void setSkippingTicks(int skippingTicks) {
        this.skippingTicks = skippingTicks;
    }

    @Override
    public void doEmulate(FakeSensor fakeSensor) {
        counter++;
        if (counter == skippingTicks) {
            counter = 0;
            value += calcDirection(value, minValue, maxValue);
        }
        fakeSensor.setEmulationValue(value);
    }

    private int calcDirection(int val, int min, int max) {
        if (val >= max) direction = -1;
        if (val <= min) direction = 1;
        return direction;
    }

}
