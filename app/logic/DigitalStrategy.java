package logic;

public class DigitalStrategy implements EmulationStrategy {

    private int skippingTicks;
    private int counter = 0;
    private int value = 0;

    @Override
    public void setSkippingTicks(int skippingTicks) {
        this.skippingTicks = skippingTicks;
    }

    @Override
    public void doEmulate(FakeSensor fakeSensor) {
        counter ++;
        if (counter == skippingTicks) {
            counter = 0;
            value = switchEmulationValue(value);
        }
        fakeSensor.setEmulationValue(value);
    }

    private int switchEmulationValue(int emulationValue) {
        return emulationValue == 0 ? 1 : 0;
    }

}
