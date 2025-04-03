package aim.ene.solex.prototypeSamen.Controller;

import aim.ene.solex.prototypeSamen.Service.VluchtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flights")
public class VluchtController {

    private final VluchtService vluchtService;

    @Autowired
    public VluchtController(VluchtService vluchtService) {
        this.vluchtService = vluchtService;
    }


    @GetMapping("/search")
    public String getVluchtDetails(
            @RequestParam String origin,
            @RequestParam String destination,
            @RequestParam String date,
            @RequestParam(required = false) String returnDate,
            @RequestParam(defaultValue = "1") String adults,
            @RequestParam(defaultValue = "0") String children,
            @RequestParam(defaultValue = "0") String infantOnLap,
            @RequestParam(defaultValue = "0") String infantInSeat,
            @RequestParam(defaultValue = "USD") String currency,
            @RequestParam(defaultValue = "en-US") String language,
            @RequestParam(defaultValue = "US") String countryCode) {

        try {
            return vluchtService.getVluchtDetails(origin, destination, date, returnDate, adults, children, infantOnLap, infantInSeat, currency, language, countryCode);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}
