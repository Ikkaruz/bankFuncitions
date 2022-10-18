import com.banco.models.createInvestment
import com.banco.models.getInvestments
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.investmentsRouting() {
    route("/investments"){
        get{
            call.respond(getInvestments())
        }
        post {
            var parameters = call.receiveParameters()
            call.respond(createInvestment(parameters["name"], parameters["min_value"], parameters["description"],parameters["owner"], parameters["investors"]))
        }
    }
}