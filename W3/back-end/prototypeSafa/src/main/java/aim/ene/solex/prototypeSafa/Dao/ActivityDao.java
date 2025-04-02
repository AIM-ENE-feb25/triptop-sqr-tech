package aim.ene.solex.prototypeSafa.Dao;

import aim.ene.solex.prototypeSafa.Domain.Activity;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ActivityDao {

  private final JdbcTemplate jdbc;

  public boolean typeExists(String type) {
    String sql = "SELECT COUNT(*) FROM FactoryBuildingBlock WHERE type = ?";
    return jdbc.queryForObject(sql, Integer.class, type) > 0;
  }

  public Activity save(Activity activity) {
    String sql = "INSERT INTO Activity (type, name, description) VALUES (?, ?, ?)";
    jdbc.update(sql, activity.getType(), activity.getName(), activity.getDescription());
    return activity;
  }
}