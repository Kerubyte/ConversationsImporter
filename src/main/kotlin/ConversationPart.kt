import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConversationPart(
    @SerialName("author")
    val author: Author,
    @SerialName("body")
    val body: String?,
    @SerialName("created_at")
    val createdAt: Int,
    @SerialName("id")
    val id: String,
    @SerialName("notified_at")
    val notifiedAt: Int,
    @SerialName("part_type")
    val partType: String,
    @SerialName("type")
    val type: String,
    @SerialName("updated_at")
    val updatedAt: Int
)
