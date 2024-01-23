
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AssignedTo(
    @SerialName("email")
    val email: String?,
    @SerialName("id")
    val id: Int,
    @SerialName("key")
    val key: String,
    @SerialName("name")
    val name: String?
)