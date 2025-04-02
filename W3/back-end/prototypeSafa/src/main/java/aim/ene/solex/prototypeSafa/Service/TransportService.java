package aim.ene.solex.prototypeSafa.Service;

import aim.ene.solex.prototypeSafa.Dao.TransportDao;
import aim.ene.solex.prototypeSafa.Domain.Transport;
import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
import aim.ene.solex.prototypeSafa.Repository.TransportRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class TransportService {

  private final TransportRepository transportRepository;
  private final TransportDao transportDao;

  @Transactional
  public Transport createTransport(String type, String name, String description) {
    if (!transportDao.typeExists(type)) {
      throw new InvalidInputException("Type does not exist");
    }
    Transport transport = new Transport(type, name, description);
    return transportRepository.save(transport);
  }

  public List<Transport> getAllTransports() {
    return transportRepository.findAll();
  }
}