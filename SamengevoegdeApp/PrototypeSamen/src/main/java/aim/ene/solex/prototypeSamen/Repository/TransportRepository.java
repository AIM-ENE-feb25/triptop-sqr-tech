package aim.ene.solex.prototypeSamen.Repository;

import aim.ene.solex.prototypeSamen.Domain.Transport;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends CrudRepository<Transport, Integer> {

  List<Transport> findAll();
}