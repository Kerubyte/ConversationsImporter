
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FindUserResponse(
    @SerialName("count")
    val count: Int,
    @SerialName("results")
    val results: List<Result?>
)