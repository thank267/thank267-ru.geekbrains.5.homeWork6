package ru.geekbrains.homework6.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.geekbrains.homework6.entities.Buyer;
import ru.geekbrains.homework6.entities.Order;
import ru.geekbrains.homework6.entities.Product;
import ru.geekbrains.homework6.repositories.OrderRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderService {

	private OrderRepository orderRepository;

	public List<Order> getOrdersByProductIdAndBuyerId(Long buyerId, Long productId) {
		return orderRepository.getOrdersByProductIdAndBuyerId(buyerId,productId);
	}

	public List<Product> getProductsByBuyerId(Long buyerId) {
		return orderRepository.getProductsByBuyerId(buyerId);
	}

	public List<Buyer> getBuyersByProductId(Long productId) {
		return orderRepository.getBuyersByProductId(productId);
	}

}
