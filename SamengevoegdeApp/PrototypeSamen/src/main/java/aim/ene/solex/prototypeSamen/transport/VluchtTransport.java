package aim.ene.solex.prototypeSamen.transport;

import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import aim.ene.solex.prototypeSamen.Service.VluchtService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VluchtTransport implements TransportOption {

    private final VluchtService vluchtService;

    public VluchtTransport(VluchtService vluchtService) {
        this.vluchtService = vluchtService;
    }

    @Override
    public List<TransportOptionResultaat> searchOptions(String from, String to) {
        String date = java.time.LocalDate.now().toString();

        return vluchtService.zoekVluchten(
                from,
                to,
                date,
                null,
                "1",
                "0",
                "0",
                "0",
                "EUR",
                "nl-NL",
                "NL"
        );
    }
}
