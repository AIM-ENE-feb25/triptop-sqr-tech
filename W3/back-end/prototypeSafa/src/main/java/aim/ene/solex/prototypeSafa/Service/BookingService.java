package aim.ene.solex.prototypeSafa.Service;

import aim.ene.solex.prototypeSafa.Dao.BookingDao;
import aim.ene.solex.prototypeSafa.Domain.Activity;
import aim.ene.solex.prototypeSafa.Domain.Booking;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import aim.ene.solex.prototypeSafa.Repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

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