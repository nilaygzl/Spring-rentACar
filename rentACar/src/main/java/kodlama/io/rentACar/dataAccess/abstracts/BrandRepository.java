package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.Entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {
   // List<Brand> getAll();
    boolean existsByName(String name); //spring jpa keywords
}
