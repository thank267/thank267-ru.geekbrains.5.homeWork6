package ru.geekbrains.homework6.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
@Table(name = "buyers")
public class Buyer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", length = 250, nullable = false, unique = false)
	private String name;

	@OneToMany(mappedBy = "product",  fetch = FetchType.EAGER)
	private Set<Order> orders = new HashSet<>();

}
