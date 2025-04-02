package aim.ene.solex.prototypeSafa.Domain;

public class Transport extends BuildingBlock {
  public Transport() {
    super();
  }

  public Transport(String type, String name, String description) {
    super(type, name, description);
  }

  @Override
  public String getDetails() {
    return "Transport details";
  }

  @Override
  public String toString() {
    return "Transport{" +
        "id=" + getId() +
        ", type='" + getType() + '\'' +
        ", name='" + getName() + '\'' +
        ", description='" + getDescription() + '\'' +
        '}';
  }
}