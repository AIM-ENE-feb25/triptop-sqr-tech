package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;

public abstract class BuildingBlockFactory {
  public abstract BuildingBlock createBuildingBlock();

  public static BuildingBlockFactory getFactory(String type) {
    switch (type) {
      case "Activity":
        return new ActivityFactory();
      case "Booking":
        return new BookingFactory();
      case "Transport":
        return new TransportFactory();
      default:
        throw new IllegalArgumentException("Unknown type: " + type);
    }
  }
}