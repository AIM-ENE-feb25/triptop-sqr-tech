package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Domain.Transport;

public class TransportFactory extends BuildingBlockFactory {

  @Override
  public BuildingBlock createBuildingBlock(String type, String name, String description) {
    return new Transport(type, name, description);
  }
}