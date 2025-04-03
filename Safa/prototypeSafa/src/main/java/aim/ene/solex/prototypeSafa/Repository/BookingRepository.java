package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.Booking;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

  List<Booking> findAll();
}