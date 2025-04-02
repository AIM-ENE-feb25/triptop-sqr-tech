package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {
  List<Booking> findAll();
}