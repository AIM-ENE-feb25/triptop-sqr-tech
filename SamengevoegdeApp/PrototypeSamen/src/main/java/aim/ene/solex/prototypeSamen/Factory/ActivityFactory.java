package aim.ene.solex.prototypeSamen.Factory;

import aim.ene.solex.prototypeSamen.Domain.Activity;
import aim.ene.solex.prototypeSamen.Domain.BuildingBlock;

public class ActivityFactory extends BuildingBlockFactory {

  @Override
  public BuildingBlock createBuildingBlock(String type, String name, String description) {
    return new Activity(type, name, description);
  }

}