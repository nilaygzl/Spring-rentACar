package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.Entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
