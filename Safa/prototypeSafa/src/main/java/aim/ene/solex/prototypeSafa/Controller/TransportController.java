package aim.ene.solex.prototypeSafa.Controller;

import aim.ene.solex.prototypeSafa.Controller.DTO.BuildingBlockRequest;
import aim.ene.solex.prototypeSafa.Domain.Transport;
import aim.ene.solex.prototypeSafa.Service.TransportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

  private final TransportService transportService;

  @Autowired
  public TransportController(TransportService transportService) {
    this.transportService = transportService;
  }

  @PostMapping
  public ResponseEntity<Transport> createTransport(@RequestBody BuildingBlockRequest request) {
    Transport transport = transportService.createTransport(request.getType(), request.getName(),
        request.getDescription());
    return ResponseEntity.ok(transport);
  }

  @GetMapping
  public ResponseEntity<List<Transport>> getAllTransports() {
    List<Transport> transports = transportService.getAllTransports();
    return ResponseEntity.ok(transports);
  }
}