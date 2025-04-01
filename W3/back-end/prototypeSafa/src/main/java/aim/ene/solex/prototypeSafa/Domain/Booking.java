package aim.ene.solex.prototypeSafa.Domain;

public class Booking extends BuildingBlock {
  public Booking() {
    super();
  }

  public Booking(String type, String name, String description) {
    super(type, name, description);
  }

  @Override
  public String getDetails() {
    return "Booking details";
  }
}