package logic;

public class FakeSensorImpl implements FakeSensor {

    private SensorType type;
    private String name;
    EmulationStrategy emulationStrategy;
    int emulationValue;

    public FakeSensorImpl(SensorType type, String name) {
        this.type = type;
        this.name = name;
    }

    @Override
    public void setEmulationStrategy(EmulationStrategy emulationStrategy) {
        this.emulationStrategy = emulationStrategy;
    }

    @Override
    public void setEmulationValue(int emulationValue) {
        this.emulationValue = emulationValue;
    }

    @Override
    public void emulate() {
        if (emulationStrategy != null)
            emulationStrategy.doEmulate(this);
    }

    @Override
    public SensorType type() {
        return type;
    }

    @Override
    public int getValue() {
        return emulationValue;
    }

    @Override
    public String getName() {
        return name;
    }


}
