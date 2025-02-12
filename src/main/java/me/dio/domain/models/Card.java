package me.dio.domain.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "tb_card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID cardId;

    private String cardNumber;

    @Column(name = "available_limit", scale = 13, precision = 2)
    private BigDecimal limit;

    public Card() {
    }

    public Card(UUID cardId, String cardNumber, BigDecimal limit) {
        this.cardId = cardId;
        this.cardNumber = cardNumber;
        this.limit = limit;
    }

    public UUID getCardId() {
        return cardId;
    }

    public void setCardId(UUID cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
