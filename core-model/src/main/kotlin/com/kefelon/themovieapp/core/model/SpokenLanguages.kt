import com.google.gson.annotations.SerializedName


data class SpokenLanguages(
    @SerializedName("iso_639_1")
    var iso: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("english_name")
    var englishName: String
)
