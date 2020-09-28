package logic;

public interface FakeSensor extends Sensor {
    void setEmulationStrategy(EmulationStrategy emulationStrategy);
    void setEmulationValue(int emulationValue);
    void emulate();
}
