package aim.ene.solex.prototypeSafa.Dao;

import aim.ene.solex.prototypeSafa.Domain.Booking;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BookingDao {

  private final JdbcTemplate jdbc;

  public boolean typeExists(String type) {
    String sql = "SELECT COUNT(*) FROM FactoryBuildingBlock WHERE type = ?";
    return jdbc.queryForObject(sql, Integer.class, type) > 0;
  }

  public Booking save(Booking booking) {
    String sql = "INSERT INTO Booking (type, name, description) VALUES (?, ?, ?)";
    jdbc.update(sql, booking.getType(), booking.getName(), booking.getDescription());
    return booking;
  }
}