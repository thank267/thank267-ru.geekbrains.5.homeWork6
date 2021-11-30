package ru.geekbrains.homework6.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderId implements Serializable {

	@Column(name = "buyer_id")
	private Long buyerId;

	@Column(name = "product_id")
	private Long productId;

}
