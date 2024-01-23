
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CreateConversationResponse(
    @SerialName("active")
    val active: Boolean,
    @SerialName("agent")
    val agent: Agent,
    @SerialName("assigned_to")
    val assignedTo: AssignedTo,
    @SerialName("id")
    val id: Int,
    @SerialName("messages")
    val messages: Int
)