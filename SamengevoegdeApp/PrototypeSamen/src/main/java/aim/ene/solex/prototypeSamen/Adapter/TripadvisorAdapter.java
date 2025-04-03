package aim.ene.solex.prototypeSamen.Adapter;

import aim.ene.solex.prototypeSamen.Domain.Boeking;
import aim.ene.solex.prototypeSamen.Service.TripadvisorService;
import org.springframework.stereotype.Component;

@Component
public class TripadvisorAdapter implements IBoekingAdapter {
    private TripadvisorService tripadvisor;

    public TripadvisorAdapter(TripadvisorService tripadvisor) {
        this.tripadvisor = tripadvisor;
    }

    @Override
    public String maakBoeking(Boeking boeking) {
        String response = tripadvisor.boek(
                boeking.getLocatie(),
                boeking.getAankomstDatum(),
                boeking.getVertrekDatum()
        );
        return response;
    }

    @Override
    public String getNaam() {
        return "TripAdvisor";
    }
}
