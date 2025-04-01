package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Repository.Rowmappers.BuildingBlockRowMapper;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BuildingBlockRepositoryImpl implements BuildingBlockRepository {

  private final JdbcTemplate jdbcTemplate;

  @Autowired
  public BuildingBlockRepositoryImpl(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  @Override
  public <S extends BuildingBlock> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<BuildingBlock> findById(Integer integer) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(Integer integer) {
    return false;
  }

  @Override
  public List<BuildingBlock> findAll() {
    String sql = "SELECT * FROM BuildingBlock";
    return jdbcTemplate.query(sql, new BuildingBlockRowMapper());
  }

  @Override
  public Iterable<BuildingBlock> findAllById(Iterable<Integer> integers) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(Integer integer) {

  }

  @Override
  public void delete(BuildingBlock entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends Integer> integers) {

  }

  @Override
  public void deleteAll(Iterable<? extends BuildingBlock> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public BuildingBlock save(BuildingBlock buildingBlock) {
    return null;
  }

  @Override
  public BuildingBlock findById(int id) {
    return null;
  }
}
