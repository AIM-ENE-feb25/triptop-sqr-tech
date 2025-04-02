package aim.ene.solex.prototypeSafa.Dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class FactoryDao {

  private final JdbcTemplate jdbc;

  public boolean typeExists(String type) {
    String sql = "SELECT COUNT(*) FROM FactoryBuildingBlock WHERE type = ?";

    return jdbc.queryForObject(sql, Integer.class, type) > 0;
  }
}
