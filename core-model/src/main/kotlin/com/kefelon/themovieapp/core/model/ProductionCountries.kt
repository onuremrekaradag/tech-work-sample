import com.google.gson.annotations.SerializedName


data class ProductionCountries(
    @SerializedName("iso_3166_1")
    var iso: String,
    @SerializedName("name")
    var name: String
)
