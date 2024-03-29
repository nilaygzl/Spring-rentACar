package kodlama.io.rentACar.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Table(name = "brands")
@Data // Burası getter,setter ve diğer gerekli metodları getirir. (toString gibi) Ve parametresiz constructor oluşturur.
@AllArgsConstructor //parametreli constructor oluşturur.
@NoArgsConstructor //parametresiz constructor oluşturur.
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id otomatik artan olsun demek.
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;


}
