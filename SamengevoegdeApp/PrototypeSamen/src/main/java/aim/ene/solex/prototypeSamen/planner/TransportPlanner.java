package aim.ene.solex.prototypeSamen.planner;


import aim.ene.solex.prototypeSamen.Domain.TransportOptionResultaat;
import aim.ene.solex.prototypeSamen.transport.TransportOption;
import java.util.List;

public class TransportPlanner {

    private final TransportOption option;

    public TransportPlanner(TransportOption option) {
        this.option = option;
    }

    public List<TransportOptionResultaat> search(String from, String to) {
        return option.searchOptions(from, to);
    }
}
