import com.example.models.checkLogin
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*


fun Route.loginRouting() {
    route("/login"){
        post {
            var parameters = call.receiveParameters()
            var res = checkLogin(parameters["nick"], parameters["password"])
            if (res != ""){
                call.respond(res.toString())
            } else {
                call.respond("")
            }
        }
    }
}

