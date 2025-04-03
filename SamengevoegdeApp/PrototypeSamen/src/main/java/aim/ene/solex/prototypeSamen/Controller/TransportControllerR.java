package aim.ene.solex.prototypeSamen.Controller;

import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import aim.ene.solex.prototypeSamen.planner.TransportPlanner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class TransportControllerR {

    private final TransportPlanner planner;

    public TransportControllerR(TransportPlanner planner) {
        this.planner = planner;
    }

    @GetMapping
    public ResponseEntity<List<TransportOptionResultaat>> plan(
            @RequestParam String from,
            @RequestParam String to) {

        List<TransportOptionResultaat> results = planner.search(from, to);
        return ResponseEntity.ok(results);
    }
}
