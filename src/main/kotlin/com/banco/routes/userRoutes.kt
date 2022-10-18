import com.example.models.addUser
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting() {
    route("/user"){
        post{
            var params = call.receiveParameters()
            call.respond(addUser(params["nick"].toString(), params["password"].toString(), Integer.parseInt(params["money"]), params["role"].toString()))
        }
    }
}