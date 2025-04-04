package aim.ene.solex.prototypeSamen.Dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class TransportDao {

  private final JdbcTemplate jdbc;

  public boolean typeExists(String type) {
    String sql = "SELECT COUNT(*) FROM FactoryBuildingBlock WHERE type = ?";
    return jdbc.queryForObject(sql, Integer.class, type) > 0;
  }
}