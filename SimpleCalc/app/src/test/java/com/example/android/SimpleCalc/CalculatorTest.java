/*
 * Copyright 2018, Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.SimpleCalc;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * JUnit4 unit tests for the calculator logic. These are local unit tests; no device needed
 */
@RunWith(JUnit4.class)
@SmallTest
public class CalculatorTest {

    private Calculator mCalculator;

    /**
     * Set up the environment for testing
     */
    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * Test for simple addition
     */
    @Test
    public void addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
    }

    @Test
    public void addTwoNumbersNegative() {
        double resultAdd = mCalculator.add(-1d, 2d);
        assertThat(resultAdd, is(equalTo(1d)));
    }

    @Test
    public void addTwoNumbersFloats() {
        double resultAdd = mCalculator.add(1.111f, 1.111d);
//        assertThat(resultAdd, is(equalTo(2.222d))); //this fails
        assertThat(resultAdd, is(closeTo(2.222, 0.01)));
    }

    @Test
    public void subTwoNumbers() {
        double result = mCalculator.sub(2d, 1d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void subWorksWithNegativeResults() {
        double result = mCalculator.sub(1d, 3d);
        assertThat(result, is(equalTo(-2d)));
    }

    @Test
    public void mulTwoNumbers() {
        double result = mCalculator.mul(3d, 5d);
        assertThat(result, is(equalTo(15d)));
    }

    @Test
    public void mulTwoNumbersZero() {
        double result = mCalculator.mul(0d, 4d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public void divTwoNumbers() {
        double result = mCalculator.div(15d, 3d);
        assertThat(result, is(equalTo(5d)));
    }

//    @Test
//    public void divTwoNumbersZero() {
//        double result = mCalculator.div(15d, 0d);
//        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
//    }

    @Test(expected = IllegalArgumentException.class)
    public void divByZeroThrows() {
        double result = mCalculator.div(45d, 0);
    }

    @Test
    public void powTwoNumbers() {
        double result = mCalculator.pow(5d, 4d);
        assertThat(result, is(equalTo(625d)));
    }

    @Test
    public void poTwoNumbersFirstNegative() {
        double result = mCalculator.pow(-5d, 3d);
        assertThat(result, is(equalTo(-125d)));
    }

    @Test
    public void poTwoNumbersSecondNegative() {
        double result = mCalculator.pow(5d, -2d);
        assertThat(result, is(equalTo(0.04d)));
    }

    @Test
    public void poTwoNumbersFirstZero() {
        double result = mCalculator.pow(0d, 2d);
        assertThat(result, is(equalTo(0d)));
    }

    @Test
    public void poTwoNumbersSecondZero() {
        double result = mCalculator.pow(5d, 0d);
        assertThat(result, is(equalTo(1d)));
    }

    @Test
    public void poTwoNumbersZeroAndMinus() {
        double result = mCalculator.pow(0d, -1d);
        assertThat(result, is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void poTwoNumbersMinusZeroAndNegative() {
        double result = mCalculator.pow(-0d, -1d);
        assertThat(result, is(equalTo(Double.NEGATIVE_INFINITY)));
    }
}