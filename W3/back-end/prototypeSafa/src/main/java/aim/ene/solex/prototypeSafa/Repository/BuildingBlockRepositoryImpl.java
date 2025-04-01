//package aim.ene.solex.prototypeSafa.Repository;
//
//import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
//import aim.ene.solex.prototypeSafa.Repository.Rowmappers.BuildingBlockRowMapper;
//import java.util.List;
//import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class BuildingBlockRepositoryImpl implements BuildingBlockRepository {
//
//  private final JdbcTemplate jdbcTemplate;
//
//  @Autowired
//  public BuildingBlockRepositoryImpl(DataSource dataSource) {
//    this.jdbcTemplate = new JdbcTemplate(dataSource);
//  }
//
//  @Override
//  public List<BuildingBlock> findAll() {
//    String sql = "SELECT * FROM BuildingBlock";
//    return jdbcTemplate.query(sql, new BuildingBlockRowMapper());
//  }
//}
