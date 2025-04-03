package aim.ene.solex.prototypeSafa.Controller;

import aim.ene.solex.prototypeSafa.Controller.DTO.BuildingBlockRequest;
import aim.ene.solex.prototypeSafa.Domain.Activity;
import aim.ene.solex.prototypeSafa.Service.ActivityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

  private final ActivityService activityService;

  @Autowired
  public ActivityController(ActivityService activityService) {
    this.activityService = activityService;
  }

  @PostMapping
  public ResponseEntity<Activity> createActivity(@RequestBody BuildingBlockRequest request) {
    Activity activity = activityService.createActivity(request.getType(), request.getName(),
        request.getDescription());
    return ResponseEntity.ok(activity);
  }

  @GetMapping
  public ResponseEntity<List<Activity>> getAllActivities() {
    List<Activity> activities = activityService.getAllActivities();
    return ResponseEntity.ok(activities);
  }
}