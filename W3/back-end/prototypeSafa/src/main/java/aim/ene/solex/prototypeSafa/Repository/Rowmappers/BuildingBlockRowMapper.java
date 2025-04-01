package aim.ene.solex.prototypeSafa.Repository.Rowmappers;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class BuildingBlockRowMapper implements RowMapper<BuildingBlock> {
  @Override
  public BuildingBlock mapRow(ResultSet rs, int rowNum) throws SQLException {
    String type = rs.getString("type");
    BuildingBlock buildingBlock = BuildingBlockFactory.getFactory(type).createBuildingBlock();
    buildingBlock.setId(rs.getInt("id"));
    buildingBlock.setName(rs.getString("name"));
    buildingBlock.setDescription(rs.getString("description"));
    buildingBlock.setType(type);
    return buildingBlock;
  }
}