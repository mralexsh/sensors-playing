package logic;

public interface Sensor {
    SensorType type();
    int getValue();
    String getName();
}
