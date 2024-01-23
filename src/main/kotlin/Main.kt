import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonArray
import java.io.File

fun main(args: Array<String>) {

    val usercomToken = "smOBqWlME7a17bkGvVflVx2HX4yGh5TjgXe5cLYPzVbqEMDOWt529cyjbuf22aTb"
    val FIND_USER_BY_ATTRIBUTE_URL = "https://the-prancing-pony.user.com/api/public/users/search/"
    val CREATE_CONVERSATION_URL = "https://the-prancing-pony.user.com/api/public/users/"
    val CREATE_MESSAGE_AS_AGENT_URL = "https://the-prancing-pony.user.com/api/public/message/"
    val CREATE_MESSAGE_AS_USER_URL = "https://the-prancing-pony.user.com/api/public/message/send_message_as_user/"

    val jsonData = readFromFile("conversations1.json")
    println(jsonData)

    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    jsonData.forEach { data ->

    }

    suspend fun findUserByCustomAttr(value: String, client: HttpClient): Int? {
        var retryCount = 0
        val maxRetries = 3
        var waitTime = 2000L
        var userId: Int? = 1

        while (retryCount < maxRetries) {
            try {
                val response: HttpResponse = client.get(FIND_USER_BY_ATTRIBUTE_URL) {
                    url {
                        parameters.append("uuid_intercom__icontains", value)
                    }
                    headers {
                        append(HttpHeaders.Authorization, usercomToken)
                        append("Accept", "*/*;version=2")
                    }
                }

                val parsedResponse: FindUserResponse = response.body()
                userId = parsedResponse.results[0]?.id
                break
            } catch (e: Exception) {
                retryCount++
                Thread.sleep(waitTime)
                waitTime *= 2
                println("EXCEPTION: $e")
            }
        }
        return userId
    }

    suspend fun createConversation(client: HttpClient, data: SingleConversation) {
        var retryCount = 0
        val maxRetries = 3
        var waitTime = 2000L

        while (retryCount < maxRetries) {
            try {
                val agentId = "1"
                val userId = findUserByCustomAttr(data.contacts.contacts[0].id, client)
                val payload = ConversationPayload(
                    content = "Intercom Import", user = 1
                )
                client.post(CREATE_CONVERSATION_URL) {
                    url {
                        appendPathSegments()
                    }
                    headers {
                        append(HttpHeaders.Authorization, usercomToken)
                        append("Accept", "*/*;version=2")
                    }
                    contentType(ContentType.Application.Json)
                    setBody(data)
                }



                break
            } catch (e: Exception) {
                retryCount++
                Thread.sleep(waitTime)
                waitTime *= 2
                println("EXCEPTION: $e")
            }

        }

    }
}

fun readFromFile(filePath: String): List<SingleConversation> {
    val fileContent = File(filePath).readText(Charsets.UTF_8)
    val jsonArray = Json.parseToJsonElement(fileContent).jsonArray

    return jsonArray.map {
        Json.decodeFromJsonElement(SingleConversation.serializer(), it)

    }
}