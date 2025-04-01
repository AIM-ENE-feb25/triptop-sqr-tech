package com.example.booking;

import com.example.booking.API.BookingComService;
import com.example.booking.API.TripadvisorService;
import com.example.booking.Adapter.BookingComAdapter;
import com.example.booking.Adapter.TripadvisorAdapter;
import com.example.booking.Controller.BoekingController;
import com.example.booking.Repository.BoekingRepository;
import com.example.booking.Service.BoekingService;
import com.example.booking.Service.IBoekingAdapter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookingApplication {

	public static void main(String[] args) {

		BoekingRepository repository = new BoekingRepository();
		List<IBoekingAdapter> adapters = new ArrayList<>();
		adapters.add(new BookingComAdapter(new BookingComService()));
		adapters.add(new TripadvisorAdapter(new TripadvisorService()));

		BoekingService service = new BoekingService(repository, adapters);
		BoekingController controller = new BoekingController(service);

		Boeking boeking1 = new Boeking(1, "Jan Janssen");
		BookingComAdapter boekingTest = new BookingComAdapter(new BookingComService());
		Boeking boeking = "?dest_id=-2092174&search_type=CITY&arrival_date=2025-04-02&departure_date=2025-04-10&adults=1&children_age=0%2C17&room_qty=1&page_number=1&units=metric&temperature_unit=c&languagecode=en-us&currency_code=AED&location=US";
		boekingTest.maakBoeking(boeking);
		controller.nieuweBoeking(boeking1);
		controller.toonAlleBoekingen();
	}
}
