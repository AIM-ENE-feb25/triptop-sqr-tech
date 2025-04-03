package aim.ene.solex.prototypeSamen.transport;

import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import java.util.List;

public interface TransportOption {
    List<TransportOptionResultaat> searchOptions(String from, String to);
}

