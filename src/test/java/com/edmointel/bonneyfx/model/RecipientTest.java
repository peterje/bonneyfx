package com.edmointel.bonneyfx.model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class RecipientTest {
    Recipient deceasedOneYear;
    Recipient deceasedPreYear;
    Recipient alive;

    @Before
    public void setUp() {

        deceasedOneYear = new Recipient("John Doe", true, LocalDate.of(1935, 5, 23), LocalDate.of(2017, 5, 20));
        deceasedPreYear = new Recipient("John Doe", true, LocalDate.of(1935, 5, 23), LocalDate.of(2019, 5, 20));
        alive = new Recipient("John Doe", false, LocalDate.of(1935, 5, 23), LocalDate.of(2019, 5, 20));

    }

    @Test
    public void diedOverOneYearAgo1() {
        assertTrue(deceasedOneYear.diedOverOneYearAgo());
    }

    @Test
    public void diedOverOneYearAgo2() {
        assertFalse(deceasedPreYear.diedOverOneYearAgo());
    }

    @Test
    public void diedOverOneYearAgo3() {
        assertFalse(alive.diedOverOneYearAgo());
    }

    @Test
    public void isDeceased1() {
        assertTrue(deceasedOneYear.isDeceased());
    }

    @Test
    public void isDeceased2() {
        assertTrue(deceasedPreYear.isDeceased());
    }
    @Test
    public void isDeceased3() {
        assertFalse(alive.isDeceased());
    }

    @Test
    public void getAge1() {
        assertEquals(81, deceasedOneYear.getAge());
    }

    @Test
    public void getAge2() {
        assertEquals(83, deceasedPreYear.getAge());
    }

    @Test
    public void getAge3() {
        assertEquals(83, alive.getAge());
    }
}