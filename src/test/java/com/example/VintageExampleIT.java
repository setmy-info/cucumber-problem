package com.example;


import org.junit.Test;

import static com.example.Switches.VINTAGE_INTEGRATION_TEST_FAILS;
import static org.assertj.core.api.Assertions.fail;

public class VintageExampleIT {

    @Test
    public void test() {
        if (VINTAGE_INTEGRATION_TEST_FAILS) {
            fail("Integration test fail");
        }
    }
}
