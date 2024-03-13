package com.example;

import org.junit.jupiter.api.Test;

import static com.example.Switches.UNIT_TEST_FAILS;
import static org.assertj.core.api.Assertions.fail;

public class ExampleTest {

    @Test
    public void test() {
        if (UNIT_TEST_FAILS) {
            fail("Unit test fail");
        }
    }
}
