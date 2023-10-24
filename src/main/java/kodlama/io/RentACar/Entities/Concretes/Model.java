package kodlama.io.RentACar.Entities.Concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="models")
@Getter // getter blokları oluşması için
@Setter  // setter blokları oluşması için
@AllArgsConstructor // constructor oluşması için
@NoArgsConstructor
@Entity
public class Model { // code first yapisi ile Postgre SQL'e tablolari yansitma
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)  // id'si otomatik artmasi icin
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @ManyToOne
    @JoinColumn(name= "brand_id") // Model tablosuna gidip brand_id alani koyacak ve Brand ile Model nesnesi arasinda fiziksel iliski kuracak
    private Brand brand;

    @OneToMany(mappedBy="model")
    private List<Car> cars;



}
