package com.example.nokiatest.jettipapp

import com.example.nokiatest.etc.Fake
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilKtTest {

    @Test
    fun `testTotalTipCalculator with 60 and 80c bill with two person`() {
        val obj = Fake()
        val expected = 30.4
        assertEquals(expected, obj.totTipCalculator(100.0, 30), 0.5)
    }


    @Test
    fun `testCalculateTotalPerPerson with 100bill 2person and 24 percent tip`() {
        val expected = 62.0
        val bill = 100.0
        val person = 2
        val tipPerc = 24
        assertEquals(expected, calculateTotalPerPerson(bill, person, tipPerc), 0.1)
    }
}