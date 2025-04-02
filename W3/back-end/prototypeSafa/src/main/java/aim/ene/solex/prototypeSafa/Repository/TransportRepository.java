package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.Transport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Integer> {
  List<Transport> findAll();
}