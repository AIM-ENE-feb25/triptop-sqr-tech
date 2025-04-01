package aim.ene.solex.prototypeSafa.Controller;

import aim.ene.solex.prototypeSafa.Controller.DTO.BuildingBlockRequest;
import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Service.BuildingBlockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class BuildingBlockController {

  private final BuildingBlockService buildingBlockService;

  @Autowired
  public BuildingBlockController(BuildingBlockService buildingBlockService) {
    this.buildingBlockService = buildingBlockService;
  }

  @GetMapping("/building-blocks")
  public List<BuildingBlock> getAllBuildingBlocks() {
    return buildingBlockService.getAllBuildingBlocks();
  }

  @GetMapping("/building-blocks/{id}")
  public ResponseEntity<BuildingBlock> getBuildingBlockById(@PathVariable int id) {
    BuildingBlock buildingBlock = buildingBlockService.getBuildingBlockById(id);
    if (buildingBlock == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(buildingBlock);
  }

  @PostMapping("/building-blocks")
  public ResponseEntity<BuildingBlock> createBuildingBlock(@RequestBody BuildingBlockRequest request) {
    BuildingBlock buildingBlock = buildingBlockService.createBuildingBlock(
        request.getType(),
        request.getName(),
        request.getDescription()
    );
    return ResponseEntity.status(HttpStatus.CREATED).body(buildingBlock);
  }
}