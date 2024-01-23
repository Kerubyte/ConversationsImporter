import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationPayload(
    @SerialName("content")
    val content: String,
    @SerialName("user")
    val user: Int,
    @SerialName("source")
    val source: Int  = 3
)
