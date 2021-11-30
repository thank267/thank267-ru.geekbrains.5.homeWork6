package ru.geekbrains.homework6.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

	@EmbeddedId
	private OrderId id = new OrderId();

	@ManyToOne
	@MapsId("buyerId")
	@JoinColumn(name = "buyer_id")
	private Buyer buyer;

	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "product_id")
	private Product product;

	@Column(name = "cost", nullable = false, unique = false)
	private int cost;

}
