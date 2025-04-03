package aim.ene.solex.prototypeSamen.transport;

import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import aim.ene.solex.prototypeSamen.Service.TreinService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TreinTransport implements TransportOption {

    private final TreinService treinService;

    public TreinTransport(TreinService treinService) {
        this.treinService = treinService;
    }

    @Override
    public List<TransportOptionResultaat> searchOptions(String from, String to) {
        String now = java.time.LocalDateTime.now().toString();
        return treinService.zoekTreinOpties(from, to, now);
    }
}
