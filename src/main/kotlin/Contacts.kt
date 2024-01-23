import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Contacts(
    @SerialName("contacts")
    val contacts: List<Contact>,
    @SerialName("type")
    val type: String
)
