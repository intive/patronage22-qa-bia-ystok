package com.gradle.tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testowoTest {
    @Test
    public void FizzBuzzNormalNumbers() {

        testowo fb = new testowo();
        Assertions.assertEquals("1", fb.convert(1));
        Assertions.assertEquals("2", fb.convert(2));
    }

    @Test
    public void FizzBuzzThreeNumbers() {

        testowo fb = new testowo();
        Assertions.assertEquals("Fizz", fb.convert(3));
    }

    @Test
    public void FizzBuzzFiveNumbers() {

        testowo fb = new testowo();
        Assertions.assertEquals("Buzz", fb.convert(5));
    }

    @Test
    public void FizzBuzzThreeAndFiveNumbers() {

        testowo fb = new testowo();
        Assertions.assertEquals("Buzz", fb.convert(5));
    }
}