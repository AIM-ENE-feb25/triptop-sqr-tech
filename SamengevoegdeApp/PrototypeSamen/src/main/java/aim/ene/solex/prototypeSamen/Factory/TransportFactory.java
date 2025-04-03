package aim.ene.solex.prototypeSamen.Factory;

import aim.ene.solex.prototypeSamen.Domain.BuildingBlock;
import aim.ene.solex.prototypeSamen.Domain.Transport;

public class TransportFactory extends BuildingBlockFactory {

  @Override
  public BuildingBlock createBuildingBlock(String type, String name, String description) {
    return new Transport(type, name, description);
  }
}