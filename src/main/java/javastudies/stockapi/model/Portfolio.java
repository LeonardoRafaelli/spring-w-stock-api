package javastudies.stockapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Portfolio {

    private double totalInvested;
    private double position;
    
    @OneToMany
    List<Transaction> transactions;
}
