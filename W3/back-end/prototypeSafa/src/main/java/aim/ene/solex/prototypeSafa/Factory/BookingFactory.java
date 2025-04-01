package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.Booking;
import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;

public class BookingFactory extends BuildingBlockFactory {
  @Override
  public BuildingBlock createBuildingBlock() {
    return new Booking();
  }
}