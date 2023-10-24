package kodlama.io.RentACar.DataAccess.Abstracts;

import kodlama.io.RentACar.Entities.Concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

// repository, dao => veritabani islerini yapacak olan classlar

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    // spring Jpa bize findAll, id'ye göre getirme, saveAll, deleteAll vb gibi operasyonlari sagliyor

    boolean existsByName(String name); // spring jpa keywords
}
