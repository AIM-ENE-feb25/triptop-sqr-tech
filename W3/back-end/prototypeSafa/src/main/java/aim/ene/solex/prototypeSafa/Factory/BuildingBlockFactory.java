package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;

public abstract class BuildingBlockFactory {
  public abstract BuildingBlock createBuildingBlock(String type, String name, String description);

  public static BuildingBlockFactory getFactory(String type) {
    switch (type) {
      case "Activity":
        return new ActivityFactory();
      case "Booking":
        return new BookingFactory();
      case "Transport":
        return new TransportFactory();
      default:
        throw new InvalidInputException("This factorytype doesn't exist: " + type);
    }
  }
}