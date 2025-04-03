package aim.ene.solex.prototypeSafa.Service;

import aim.ene.solex.prototypeSafa.Dao.ActivityDao;
import aim.ene.solex.prototypeSafa.Domain.Activity;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import aim.ene.solex.prototypeSafa.Repository.ActivityRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ActivityService {

  private final ActivityRepository activityRepository;
  private final ActivityDao activityDao;

  public Activity createActivity(String type, String name, String description) {
    if (!activityDao.typeExists(type)) {
      throw new InvalidInputException("Type does not exist");
    }
    Activity activity = (Activity) BuildingBlockFactory.getFactory(type)
        .createBuildingBlock(type, name, description);
    return activityRepository.save(activity);
  }

  public List<Activity> getAllActivities() {
    return activityRepository.findAll();
  }
}