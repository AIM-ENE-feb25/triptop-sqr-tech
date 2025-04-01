package aim.ene.solex.prototypeSafa.Domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class BuildingBlock {

  private Integer id;
  private String type;
  private String name;
  private String description;


  public BuildingBlock(String type, String name, String description) {
    this.type = type;
    this.name = name;
    this.description = description;
  }

  public abstract String getDetails();
}
