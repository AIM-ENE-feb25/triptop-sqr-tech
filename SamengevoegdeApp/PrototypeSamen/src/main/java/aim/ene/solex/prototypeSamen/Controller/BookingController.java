package aim.ene.solex.prototypeSamen.Controller;

import aim.ene.solex.prototypeSamen.Controller.DTO.BuildingBlockRequest;
import aim.ene.solex.prototypeSamen.Domain.Booking;
import aim.ene.solex.prototypeSamen.Service.BookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

  private final BookingService bookingService;

  @Autowired
  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @PostMapping
  public ResponseEntity<Booking> createBooking(@RequestBody BuildingBlockRequest request) {
    Booking booking = bookingService.createBooking(request.getType(), request.getName(),
        request.getDescription());
    return ResponseEntity.ok(booking);
  }

  @GetMapping
  public ResponseEntity<List<Booking>> getAllBookings() {
    List<Booking> bookings = bookingService.getAllBookings();
    return ResponseEntity.ok(bookings);
  }
}