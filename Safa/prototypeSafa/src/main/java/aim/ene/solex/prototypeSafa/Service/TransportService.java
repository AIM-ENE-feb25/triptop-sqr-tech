package aim.ene.solex.prototypeSafa.Service;

import aim.ene.solex.prototypeSafa.Dao.TransportDao;
import aim.ene.solex.prototypeSafa.Domain.Transport;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
import aim.ene.solex.prototypeSafa.Factory.BuildingBlockFactory;
import aim.ene.solex.prototypeSafa.Repository.TransportRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransportService {

  private final TransportRepository transportRepository;
  private final TransportDao transportDao;

  public Transport createTransport(String type, String name, String description) {
    if (!transportDao.typeExists(type)) {
      throw new InvalidInputException("Type does not exist");
    }
    Transport transport = (Transport) BuildingBlockFactory.getFactory(type)
        .createBuildingBlock(type, name, description);
    return transportRepository.save(transport);
  }

  public List<Transport> getAllTransports() {
    return transportRepository.findAll();
  }
}