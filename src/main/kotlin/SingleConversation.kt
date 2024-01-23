import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SingleConversation(
    @SerialName("contacts")
    val contacts: Contacts,
    @SerialName("conversation_parts")
    val conversationParts: ConversationParts,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("id")
    val id: String,
    @SerialName("open")
    val `open`: Boolean,
    @SerialName("priority")
    val priority: String,
    @SerialName("read")
    val read: Boolean,
    @SerialName("title")
    val title: String?,
    @SerialName("type")
    val type: String
)
