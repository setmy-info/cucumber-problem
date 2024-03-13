package com.example;

import org.junit.Test;

import static com.example.Switches.VINTAGE_UNIT_TEST_FAILS;
import static org.assertj.core.api.Assertions.fail;

public class VintageExampleTest {

    @Test
    public void test() {
        if (VINTAGE_UNIT_TEST_FAILS) {
            fail("Vintage unit test fail");
        }
    }
}
