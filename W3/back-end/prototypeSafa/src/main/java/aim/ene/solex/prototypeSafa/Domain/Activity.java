package aim.ene.solex.prototypeSafa.Domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Activity extends BuildingBlock {

  @Id
  private Integer id;

  public Activity() {
    super();
  }

  public Activity(String type, String name, String description) {
    super(type, name, description);
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