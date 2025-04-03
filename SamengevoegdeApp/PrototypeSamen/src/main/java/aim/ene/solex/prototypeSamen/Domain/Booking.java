package aim.ene.solex.prototypeSamen.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Booking extends BuildingBlock {

  @Id
  private Integer id;

  public Booking() {
    super();
  }

  public Booking(String type, String name, String description) {
    super(type, name, description);
  }

  @Override
  public String toString() {
    return "Booking{" +
        "id=" + getId() +
        ", type='" + getType() + '\'' +
        ", name='" + getName() + '\'' +
        ", description='" + getDescription() + '\'' +
        '}';
  }
}