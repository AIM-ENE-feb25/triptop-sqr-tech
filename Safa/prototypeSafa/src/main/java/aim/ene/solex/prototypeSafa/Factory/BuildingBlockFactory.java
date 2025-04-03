package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
import java.util.HashMap;
import java.util.Map;

public abstract class BuildingBlockFactory {

  private static final Map<String, BuildingBlockFactory> factories = new HashMap<>();

  public static BuildingBlockFactory getFactory(String type) {
    if (!factories.containsKey(type)) {
      switch (type) {
        case "Activity":
          factories.put("Activity", new ActivityFactory());
          break;
        case "Booking":
          factories.put("Booking", new BookingFactory());
          break;
        case "Transport":
          factories.put("Transport", new TransportFactory());
          break;
        default:
          throw new InvalidInputException("This factory type doesn't exist: " + type);
      }
    }
    return factories.get(type);
  }

  public abstract BuildingBlock createBuildingBlock(String type, String name, String description);
}
