import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    @SerialName("email")
    val email: String?,
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("type")
    val type: String?
)
