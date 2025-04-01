package aim.ene.solex.prototypeSafa.Service;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import aim.ene.solex.prototypeSafa.Repository.BuildingBlockRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuildingBlockService {

  private final BuildingBlockRepository buildingBlockRepository;

  @Autowired
  public BuildingBlockService(BuildingBlockRepository buildingBlockRepository) {
    this.buildingBlockRepository = buildingBlockRepository;
  }

  public List<BuildingBlock> getAllBuildingBlocks() {
    return buildingBlockRepository.findAll();
  }

  public BuildingBlock createBuildingBlock(String type, String name, String description) {
    BuildingBlock buildingBlock = BuildingBlockFactory.getFactory(type).createBuildingBlock();
    buildingBlock.setType(type);
    buildingBlock.setName(name);
    buildingBlock.setDescription(description);
    return buildingBlockRepository.save(buildingBlock);
  }

  public BuildingBlock getBuildingBlockById(int id) {
    return buildingBlockRepository.findById(id);
  }
}