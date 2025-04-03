package aim.ene.solex.prototypeSamen.Factory;

import aim.ene.solex.prototypeSamen.Domain.Booking;
import aim.ene.solex.prototypeSamen.Domain.BuildingBlock;

public class BookingFactory extends BuildingBlockFactory {

  @Override
  public BuildingBlock createBuildingBlock(String type, String name, String description) {
    return new Booking(type, name, description);
  }
}