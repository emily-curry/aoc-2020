package puzzles.p04

data class Passport(
    val birthYear: String? = null,
    val issueYear: String? = null,
    val expirationYear: String? = null,
    val height: String? = null,
    val hairColor: String? = null,
    val eyeColor: String? = null,
    val passportId: String? = null,
    val countryId: String? = null
) {
    private val heightRegex = Regex("""(\d+)(in|cm)""")
    private val colorRegex = Regex("""#[0-9a-fA-F]{6}""")
    private val validEyeColors = setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    fun isValid(strict: Boolean = false): Boolean {
        val requiredFieldsPresent = birthYear != null
                && issueYear != null
                && expirationYear != null
                && height != null
                && hairColor != null
                && eyeColor != null
                && passportId != null
        val dataValid = if (strict) isDataValid() else true
        return requiredFieldsPresent && dataValid
    }

    private fun isDataValid(): Boolean {
        return isYearValid(birthYear, 1920, 2002)
                && isYearValid(issueYear, 2010, 2020)
                && isYearValid(expirationYear, 2020, 2030)
                && isHeightValid(height)
                && isColorValid(hairColor)
                && isEyeColorValid(eyeColor)
                && isNumericIdValid(passportId, 9)
    }

    private fun isYearValid(year: String?, min: Int, max: Int): Boolean {
        try {
            if (year == null || year.length != 4) return false
            val range = min..max
            return range.contains(year.toInt())
        } catch (e: Exception) {
            return false
        }
    }

    private fun isHeightValid(height: String?): Boolean {
        if (height == null) return false
        try {
            val matchResult = heightRegex.matchEntire(height) ?: return false
            val num = matchResult.groupValues[1]
            val unit = matchResult.groupValues[2]
            return when (unit) {
                "in" -> (59..76).contains(num.toInt())
                "cm" -> (150..193).contains(num.toInt())
                else -> false
            }
        } catch (e: Exception) {
            return false
        }
    }

    private fun isColorValid(color: String?): Boolean {
        if (color == null || color.length != 7) return false
        return color.matches(colorRegex)
    }

    private fun isEyeColorValid(eyeColor: String?): Boolean {
        return validEyeColors.contains(eyeColor)
    }

    private fun isNumericIdValid(id: String?, length: Int): Boolean {
        return id != null && id.matches(Regex("""^\d{${length}}$"""))
    }

    companion object {
        private val split = Regex("""[\n\s]""")

        fun parse(raw: String): Passport {
            val keyMap = raw.split(split).associateTo(HashMap()) { x ->
                val y = x.split(":")
                Pair(y[0], y[1])
            }
            return Passport(
                birthYear = keyMap.getOrDefault("byr", null),
                issueYear = keyMap.getOrDefault("iyr", null),
                expirationYear = keyMap.getOrDefault("eyr", null),
                height = keyMap.getOrDefault("hgt", null),
                hairColor = keyMap.getOrDefault("hcl", null),
                eyeColor = keyMap.getOrDefault("ecl", null),
                passportId = keyMap.getOrDefault("pid", null),
                countryId = keyMap.getOrDefault("cid", null),
            )
        }
    }
}