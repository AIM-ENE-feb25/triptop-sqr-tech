package aim.ene.solex.prototypeSamen.Repository;

import aim.ene.solex.prototypeSamen.Domain.Activity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {

  List<Activity> findAll();
}