package logic;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnalogStrategyTest {

    private static final int SKIPPING_TICKS = 13;
    private static final int REPEAT_AMOUNT = 17137;
    private static final int MIN_TEST_VALUE = 0;
    private static final int MAX_TEST_VALUE = 100;

    private static AnalogStrategy analogStrategy;
    private static FakeSensor fakeSensor;

    @BeforeClass
    public static void initObj() {
        analogStrategy = new AnalogStrategy();
        analogStrategy.setSkippingTicks(SKIPPING_TICKS);
        analogStrategy.setMinValue(MIN_TEST_VALUE);
        analogStrategy.setMaxValue(MAX_TEST_VALUE);
        fakeSensor = new FakeSensorImpl(SensorType.ANALOG, "sensor2");
        fakeSensor.setEmulationStrategy(analogStrategy);
    }

    @Test
    public void emulate_n_times_with_skipping_ticks_and_check_result() {
        for(int i = 0; i < (MAX_TEST_VALUE - MIN_TEST_VALUE) * SKIPPING_TICKS; i++) {
            analogStrategy.doEmulate(fakeSensor);
            int t = MIN_TEST_VALUE + (i + 1) / SKIPPING_TICKS;
            assertEquals(fakeSensor.getValue(), t);
        }
        assertEquals(fakeSensor.getValue(), MAX_TEST_VALUE);
        for(int i = 0; i < (MAX_TEST_VALUE - MIN_TEST_VALUE) * SKIPPING_TICKS; i++) {
            analogStrategy.doEmulate(fakeSensor);
            int t = MAX_TEST_VALUE - (i + 1) / SKIPPING_TICKS;
            assertEquals(fakeSensor.getValue(), t);
        }
        assertEquals(fakeSensor.getValue(), MIN_TEST_VALUE);
    }

    private int switchEmulationValue(int emulationValue) {
        return emulationValue == 0 ? 1 : 0;
    }
}