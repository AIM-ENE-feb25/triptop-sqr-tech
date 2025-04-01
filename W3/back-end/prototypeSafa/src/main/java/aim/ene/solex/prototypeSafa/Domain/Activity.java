package aim.ene.solex.prototypeSafa.Domain;

public class Activity extends BuildingBlock {
  public Activity() {
    super();
  }

  public Activity(String type, String name, String description) {
    super(type, name, description);
  }

  @Override
  public String getDetails() {
    return "Activity details";
  }
}