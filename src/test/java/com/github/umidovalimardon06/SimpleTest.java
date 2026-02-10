package com.github.umidovalimardon06;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class SimpleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }

    @DisplayName("Simple display-name-test")
    @Test
    void simpleDisplayTest() {
        assertEquals(1,1);
    }

    @Disabled("Simple disabled-test")
    @Test
    void simpleDisabledTest() {
    }


    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }

    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }

    @Test
    void lambdaExpressions() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        assertTrue(
                numbers.stream().mapToInt(Integer::intValue).sum() > 5,
                () -> "Sum should be greater than 5"
        );
    }

    @Test
    void groupAssertions() {
        int[] numbers = {0, 1, 2, 3, 4};
        assertAll("numbers",
                () -> assertEquals(numbers[0], 1),
                () -> assertEquals(numbers[3], 3),
                () -> assertEquals(numbers[4], 1)
        );
    }

    @Test
    void trueAssumption() {
        assumeTrue(5 < 1);
        assertEquals(5 + 2, 7);
    }


    @Test
    public void simpleTest1() {
        fail();
    }
    @Test
    public void simpleTest2() {
        fail();
    }

}
