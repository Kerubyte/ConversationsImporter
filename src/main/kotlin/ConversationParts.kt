import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationParts(
    @SerialName("conversation_parts")
    val conversationParts: List<ConversationPart>,
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("type")
    val type: String
)
