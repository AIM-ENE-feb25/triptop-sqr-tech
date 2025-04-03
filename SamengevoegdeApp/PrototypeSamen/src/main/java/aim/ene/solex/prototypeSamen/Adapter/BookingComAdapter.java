package aim.ene.solex.prototypeSamen.Adapter;

import aim.ene.solex.prototypeSamen.Domain.Boeking;
import aim.ene.solex.prototypeSamen.Service.BookingComService;
import org.springframework.stereotype.Component;

@Component
public class BookingComAdapter implements IBoekingAdapter {
    private final BookingComService bookingComService;

    public BookingComAdapter(BookingComService bookingComService) {
        this.bookingComService = bookingComService;
    }

    @Override
    public String maakBoeking(Boeking boeking) {
        String response = bookingComService.boek(
                boeking.getLocatie(),
                boeking.getAankomstDatum(),
                boeking.getVertrekDatum()
        );
        return response;
    }

    @Override
    public String getNaam() {
        return "BookingCom";
    }
}