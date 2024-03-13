package com.example;

import org.junit.jupiter.api.Test;

import static com.example.Switches.INTEGRATION_TEST_FAILS;
import static org.assertj.core.api.Assertions.fail;

public class ExampleIT {

    @Test
    public void test() {
        if (INTEGRATION_TEST_FAILS) {
            fail("Integration test fail");
        }
    }
}
