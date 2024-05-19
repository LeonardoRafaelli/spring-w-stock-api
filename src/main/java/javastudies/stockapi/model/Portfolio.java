package javastudies.stockapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalInvested;
    private double position;

    @OneToMany
    List<Transaction> transactions;
}
