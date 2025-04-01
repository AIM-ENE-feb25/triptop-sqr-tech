package aim.ene.solex.prototypeSafa.Factory;

import aim.ene.solex.prototypeSafa.Domain.Activity;
import aim.ene.solex.prototypeSafa.Domain.BuildingBlock;

public class ActivityFactory extends BuildingBlockFactory {
  @Override
  public BuildingBlock createBuildingBlock() {
    return new Activity();
  }
}