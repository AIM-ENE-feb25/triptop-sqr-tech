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

  @Override
  public String toString() {
    return "Activity{" +
        "id=" + getId() +
        ", type='" + getType() + '\'' +
        ", name='" + getName() + '\'' +
        ", description='" + getDescription() + '\'' +
        '}';
  }
}