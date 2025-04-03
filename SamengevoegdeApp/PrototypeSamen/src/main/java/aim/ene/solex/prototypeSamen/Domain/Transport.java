package aim.ene.solex.prototypeSamen.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Transport extends BuildingBlock {

  @Id
  private Integer id;

  public Transport() {
    super();
  }

  public Transport(String type, String name, String description) {
    super(type, name, description);
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