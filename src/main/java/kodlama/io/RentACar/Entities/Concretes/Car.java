package kodlama.io.RentACar.Entities.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="cars")
@Getter // getter blokları oluşması için
@Setter  // setter blokları oluşması için
@AllArgsConstructor // constructor oluşması için
@NoArgsConstructor
@Entity
public class Car {
    @Id // veritabaninda primary key olmasi icin
    @GeneratedValue(strategy= GenerationType.IDENTITY)  // id'si otomatik artmasi icin
    @Column(name="id")
    private int id;
    @Column(name="plate", unique = true) // plaka alani unique(tekil) olsun
    private String plate;  // plaka

    @Column(name="dailyPrice")
    private double dailyPrice;

    @Column(name="modelYear")
    private int modelYear;

    @Column(name="state")
    private String state;  // 1-Available, 2-Rented, 3-Maintenance

    @ManyToOne
    @JoinColumn(name="model_id") // Car tablosuna model_id adinda kolon ekle ve fiziksel iliski kur(bire çok)
    private Model model;
}
