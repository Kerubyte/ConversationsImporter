import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contact(
    @SerialName("id")
    val id: String,
    @SerialName("type")
    val type: String
)
