package aim.ene.solex.prototypeSafa.Controller;

import aim.ene.solex.prototypeSafa.Controller.DTO.FactoryRequest;
import aim.ene.solex.prototypeSafa.Domain.FactoryType;
import aim.ene.solex.prototypeSafa.Service.FactoryBuildingBlockService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class FactoryController {

  private final FactoryBuildingBlockService service;

  public FactoryController(FactoryBuildingBlockService service) {
    this.service = service;
  }

  @GetMapping("/factory")
  public ResponseEntity<List<FactoryType>> getAllFactoryTypes() {
    List<FactoryType> factoryTypes = service.getAllFactoryTypes();
    return ResponseEntity.ok(factoryTypes);
  }

  @PostMapping("/factory")
  public ResponseEntity<String> createFactory(@RequestBody FactoryRequest request) {
    service.createFactory(request.getType());
    return ResponseEntity.ok("Factory for " + request.getType() + " created");
  }
}