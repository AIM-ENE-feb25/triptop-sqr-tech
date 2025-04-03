//// src/main/java/aim/ene/solex/prototypeSafa/Service/FactoryBuildingBlockService.java
//package aim.ene.solex.prototypeSafa.Service;
//
//import aim.ene.solex.prototypeSafa.Dao.FactoryDao;
//import aim.ene.solex.prototypeSafa.Domain.FactoryType;
//import aim.ene.solex.prototypeSafa.Exceptions.InvalidInputException;
//import aim.ene.solex.prototypeSafa.Repository.FactoryRepository;
//import java.util.List;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@AllArgsConstructor
//public class FactoryBuildingBlockService {
//
//  private final FactoryRepository factoryRepository;
//  private final FactoryDao factoryDao;
//
//  @Transactional
//  public void createFactory(String type) {
//    if (!factoryDao.typeExists(type)) {
//      FactoryType factoryType = new FactoryType(type);
//      factoryRepository.save(factoryType);
//    } else {
//      throw new InvalidInputException("Type already exists");
//    }
//  }
//
//  public List<FactoryType> getAllFactoryTypes() {
//    return factoryRepository.findAllFactoryTypes();
//  }
//}