package romantointeger

//reimplemented it because I did not like this solution
fun romanToIntegerOld(romanNumber: String): Int {
    var total = 0

    var i = 0
    while (i < romanNumber.length) {
        when (romanNumber[i]) {
            'M' -> total += 1000
            'D' -> total += 500
            'C' -> {
                var hundreds = checkHundred(i, romanNumber)
                total += hundreds
                if (hundreds != 100) i++
            }
            'L' -> total += 50
            'X' -> {
                var tens = checkTen(i, romanNumber)
                total += tens
                if (tens != 10) i++
            }
            'V' -> total += 5
            'I' -> {
                var ones = checkOne(i, romanNumber)
                total += ones
                if (ones != 1) i++
            }
        }
        i++
    }
    return total
}

private fun checkOne(i: Int, romanNumber: String): Int {
    return checkNumber(i, romanNumber,'V', 'X', 1)
}

private fun checkTen(i: Int, romanNumber: String): Int {
    return checkNumber(i, romanNumber,'L', 'C', 10)
}

private fun checkHundred(i: Int, romanNumber: String): Int {
    return checkNumber(i, romanNumber,'D', 'M', 100)
}

private fun checkNumber(i: Int, romanNumber: String, five : Char, ten : Char, base : Int): Int {
    if ((i + 1) < romanNumber.length) {
        if (romanNumber[i + 1] == five) {
            return 4 * base
        } else if (romanNumber[i + 1] == ten) {
            return 9 * base
        }
    }
    return base
}

fun romanToInteger(roman : String) : Int {
    var total = 0
    var i = 0
    while (i < roman.length) {
        if (i+1 < roman.length && getIntFromRomanDigit(roman[i]) < getIntFromRomanDigit(roman[i+1])) {
            total -= getIntFromRomanDigit(roman[i])
        } else {
            total += getIntFromRomanDigit(roman[i])
        }
        i++
    }
    return total
}

private fun getIntFromRomanDigit(digit: Char) : Int {
    when (digit) {
        'M' -> return 1000
        'D' -> return 500
        'C' -> return 100
        'L' -> return 50
        'X' -> return 10
        'V' -> return 5
        'I' -> return 1
    }
    return 0
}