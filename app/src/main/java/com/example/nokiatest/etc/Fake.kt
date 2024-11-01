package com.example.nokiatest.etc

import androidx.annotation.VisibleForTesting

class Fake{
    @VisibleForTesting
    internal fun totTipCalculator(totalAmount: Double, tipPercent: Int ): Double{
        return if (totalAmount > 1 && totalAmount.toString().isNotEmpty())
            totalAmount.times(tipPercent).div(100)
        else 7.7
    }
}
