package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Integer> {
  List<Activity> findAll();
}