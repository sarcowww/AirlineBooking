package domain.usecases

import domain.model.Aircraft
import domain.model.Airport
import domain.model.AirportBooking
import domain.model.Flight
import domain.presentation.Formatter
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Month
import kotlin.reflect.KClass

class GetFlights(
    private val formatter: Formatter<Flight>
) {

    private val flight = Flight(
        number = "Y4 778",
        aircraft = Aircraft("Airbus", "A320"),
        price = BigDecimal(100.0),
        departureArrivalBooking = getAirportPair()

    )

    fun invoke(): String {

        val flights = listOf(
            flight,
            flight,
            flight,
            flight,
        )
        return formatter.format(flights)
        
    }

    fun getFlight(): Flight {
        return flight
    }


    private fun getAirportPair(): Pair<AirportBooking, AirportBooking> {
        return Pair(
            AirportBooking(
                airport = Airport("BOG", "Bogotá"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 13, 0, 0)
            ),
            AirportBooking(
                airport = Airport("CUN", "Cancún"),
                dateTime = LocalDateTime.of(2023, Month.JANUARY, 10, 17, 30, 0)
            )
        )
    }

}