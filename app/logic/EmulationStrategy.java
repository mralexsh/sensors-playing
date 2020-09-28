package logic;

public interface EmulationStrategy {
    void setSkippingTicks(int skippingTicks);
    void doEmulate(FakeSensor fakeSensor);
}
