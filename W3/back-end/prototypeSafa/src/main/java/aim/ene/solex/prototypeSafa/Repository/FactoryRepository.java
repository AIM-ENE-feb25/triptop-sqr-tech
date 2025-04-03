//package aim.ene.solex.prototypeSafa.Repository;
//
//import aim.ene.solex.prototypeSafa.Domain.FactoryType;
//import org.springframework.data.jdbc.repository.query.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@Repository
//public interface FactoryRepository extends CrudRepository<FactoryType, String> {
//
//  @Query("SELECT * FROM FactoryBuildingBlock")
//  List<FactoryType> findAllFactoryTypes();
//}