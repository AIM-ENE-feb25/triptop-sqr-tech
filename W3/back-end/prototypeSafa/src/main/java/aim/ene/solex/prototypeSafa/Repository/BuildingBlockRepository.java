package aim.ene.solex.prototypeSafa.Repository;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BuildingBlockRepository extends CrudRepository<BuildingBlock, Integer> {
  List<BuildingBlock> findAll();
  BuildingBlock save(BuildingBlock buildingBlock);
  BuildingBlock findById(int id);
}