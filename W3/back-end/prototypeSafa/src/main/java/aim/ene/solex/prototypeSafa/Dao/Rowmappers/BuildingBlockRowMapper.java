package aim.ene.solex.prototypeSafa.Dao.Rowmappers;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BuildingBlockRowMapper implements RowMapper<BuildingBlock> {
  @Override
  public BuildingBlock mapRow(ResultSet rs, int rowNum) throws SQLException {
    String type = rs.getString("type");
    String name = rs.getString("name");
    String description = rs.getString("description");
    BuildingBlock buildingBlock = BuildingBlockFactory.getFactory(type).createBuildingBlock(type, name, description);
    buildingBlock.setId(rs.getInt("id"));
    return buildingBlock;
  }
}