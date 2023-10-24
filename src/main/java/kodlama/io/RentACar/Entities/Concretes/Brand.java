package kodlama.io.RentACar.Entities.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


// lombok sayesinde getter ve setter bloklarından kurtulduk
@Table(name="brands")  // postgre sql'de tablo adinin brands olarak olusmasi icin
@Getter // getter blokları oluşması için
@Setter  // setter blokları oluşması için
@AllArgsConstructor // constructor oluşması için
@NoArgsConstructor
@Entity
public class Brand {
    @Id // veritabaninda primary key olmasi icin
    @GeneratedValue(strategy=GenerationType.IDENTITY)  // id'si otomatik artmasi icin
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "brand")  // brand nesnesi ile bire cok iliski
    private List<Model> models;

    // Encapsulation
   /* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
