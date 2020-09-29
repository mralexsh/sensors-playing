package logic;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DigitalStrategyTest {
    private static final int SKIPPING_TICKS = 7;
    private static final int REPEAT_AMOUNT = 17137;

    private static DigitalStrategy digitalStrategy;
    private static FakeSensor fakeSensor;

    @BeforeClass
    public static void initObj() {
        digitalStrategy = new DigitalStrategy();
        digitalStrategy.setSkippingTicks(SKIPPING_TICKS);
        fakeSensor = new FakeSensorImpl(SensorType.DIGITAL, "sensor1");
        fakeSensor.setEmulationStrategy(digitalStrategy);
    }

    @Test
    public void emulate_n_times_with_skipping_ticks_and_check_result() {
        int expectedValue = 0;
        for (int i = 1; i < REPEAT_AMOUNT; i++) {
            fakeSensor.emulate();
            if (i % SKIPPING_TICKS == 0) {
               expectedValue = switchEmulationValue(expectedValue);
            }
            assertEquals(fakeSensor.getValue(), expectedValue);
        }
    }

    private int switchEmulationValue(int emulationValue) {
        return emulationValue == 0 ? 1 : 0;
    }

}