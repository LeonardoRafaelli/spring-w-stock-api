package javastudies.stockapi.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Transaction {

    private String stockSymbol;
    private boolean isBuying;
    private double stockPrice;
    private int stockQuantity;
    private double totalPrice;

    public Transaction(String stockSymbol, boolean isBuying, double stockPrice, int stockQuantity) {
        this.stockSymbol = stockSymbol;
        this.isBuying = isBuying;
        this.stockPrice = stockPrice;
        this.stockQuantity = stockQuantity;
        this.totalPrice = calculateTotalPrice(stockQuantity, stockPrice);
    }

    private double calculateTotalPrice(int stockQuantity, double stockPrice) {
        return stockQuantity * stockPrice;
    }
}
