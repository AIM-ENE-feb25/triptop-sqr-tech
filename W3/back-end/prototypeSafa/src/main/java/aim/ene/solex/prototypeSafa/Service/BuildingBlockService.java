//package aim.ene.solex.prototypeSafa.Service;
//
//import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
//import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
//import aim.ene.solex.prototypeSafa.Repository.BuildingBlockRepository;
//import java.util.List;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class BuildingBlockService {
//
//  private final BuildingBlockRepository buildingBlockRepository;
//
//  public List<BuildingBlock> getAllBuildingBlocks() {
//    return buildingBlockRepository.findAll();
//  }
//
//  public BuildingBlock createBuildingBlock(String type, String name, String description) {
//    BuildingBlock buildingBlock = BuildingBlockFactory.getFactory(type).createBuildingBlock(type, name, description);
//    return buildingBlockRepository.save(buildingBlock);
//  }
//}