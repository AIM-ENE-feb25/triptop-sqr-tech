package aim.ene.solex.prototypeSamen.Service;

import aim.ene.solex.prototypeSamen.Dao.BookingDao;
import aim.ene.solex.prototypeSamen.Domain.Booking;
import aim.ene.solex.prototypeSamen.Exceptions.InvalidInputException;
import aim.ene.solex.prototypeSamen.Factory.BuildingBlockFactory;
import aim.ene.solex.prototypeSamen.Repository.BookingRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

  private final BookingRepository bookingRepository;
  private final BookingDao bookingDao;

  public Booking createBooking(String type, String name, String description) {
    if (!bookingDao.typeExists(type)) {
      throw new InvalidInputException("Type does not exist");
    }
    Booking booking = (Booking) BuildingBlockFactory.getFactory(type)
        .createBuildingBlock(type, name, description);
    return bookingRepository.save(booking);
  }

  public List<Booking> getAllBookings() {
    return bookingRepository.findAll();
  }
}