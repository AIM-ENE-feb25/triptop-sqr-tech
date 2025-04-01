package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;
import aim.ene.solex.prototypeSafa.Domain.Transport;

public class TransportFactory extends BuildingBlockFactory {
  @Override
  public BuildingBlock createBuildingBlock() {
    return new Transport();
  }
}