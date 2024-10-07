package com.example.nokiatest.jetTipApp

fun totalTipCalculator(totalAmount: Double, tipPercent: Int ): Double{
    return if (totalAmount > 1 && totalAmount.toString().isNotEmpty())
        totalAmount.times(tipPercent).div(100)
    else 7.7
}

fun calculateTotalPerPerson(
    totalBill: Double,
    splitBy: Int,
    tipPercentage: Int): Double {

    val bill = totalBill + totalTipCalculator(
        totalBill,
        tipPercentage)

    return (bill.div(splitBy))
}