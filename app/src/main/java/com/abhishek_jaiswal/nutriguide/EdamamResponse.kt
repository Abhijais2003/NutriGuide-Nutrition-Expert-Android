data class EdamamResponse(
    val calories: Int,
    val totalWeight: Double,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val totalNutrients: TotalNutrients
) {
    val totalFat: String
        get() = totalNutrients.FAT.quantity.toString() + totalNutrients.FAT.unit
    val saturatedFat: String
        get() = totalNutrients.FASAT.quantity.toString() + totalNutrients.FASAT.unit
    val fiber: String
        get() = totalNutrients.FIBTG.quantity.toString() + totalNutrients.FIBTG.unit
    val protein: String
        get() = totalNutrients.PROCNT.quantity.toString() + totalNutrients.PROCNT.unit
    val carbs: String
        get() = totalNutrients.CHOCDF.quantity.toString() + totalNutrients.CHOCDF.unit
    val sugar: String
        get() = totalNutrients.SUGAR.quantity.toString() + totalNutrients.SUGAR.unit
    val cholesterol: String
        get() = totalNutrients.CHOLE.quantity.toString() + totalNutrients.CHOLE.unit
    val sodium: String
        get() = totalNutrients.NA.quantity.toString() + totalNutrients.NA.unit
    // Add other nutrients here...
}
data class TotalNutrients(
    val ENERC_KCAL: NutrientInfo,
    val FAT: NutrientInfo,
    val FASAT: NutrientInfo,
    val FATRN: NutrientInfo,
    val CHOLE: NutrientInfo,
    val NA: NutrientInfo,
    val CHOCDF: NutrientInfo,
    val FIBTG: NutrientInfo,
    val SUGAR: NutrientInfo,
    val PROCNT: NutrientInfo,
    val VITA_RAE: NutrientInfo,
    val CA: NutrientInfo,
    val VITC: NutrientInfo,
    val FE: NutrientInfo
    // Add other nutrients here...
)

data class NutrientInfo(
    val label: String,
    val quantity: Double,
    val unit: String
)
