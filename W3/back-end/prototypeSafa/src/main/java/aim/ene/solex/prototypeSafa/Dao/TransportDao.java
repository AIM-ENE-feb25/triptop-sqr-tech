package aim.ene.solex.prototypeSafa.Dao;

import aim.ene.solex.prototypeSafa.Domain.Transport;
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

  public Transport save(Transport transport) {
    String sql = "INSERT INTO Transport (type, name, description) VALUES (?, ?, ?)";
    jdbc.update(sql, transport.getType(), transport.getName(), transport.getDescription());
    return transport;
  }
}