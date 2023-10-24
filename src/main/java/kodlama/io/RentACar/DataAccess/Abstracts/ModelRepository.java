package kodlama.io.RentACar.DataAccess.Abstracts;

import kodlama.io.RentACar.Entities.Concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
