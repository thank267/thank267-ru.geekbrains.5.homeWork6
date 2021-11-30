package ru.geekbrains.homework6.repositories;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework6.config.SessionFactoryConfig;
import ru.geekbrains.homework6.entities.Buyer;
import ru.geekbrains.homework6.entities.Order;
import ru.geekbrains.homework6.entities.Product;

import java.util.List;

@Repository
@Slf4j
@AllArgsConstructor
public class OrderRepository {

	private SessionFactoryConfig sessionFactoryConfig;

	public List<Order> getOrdersByProductIdAndBuyerId(Long buyerId, Long productId) {
		try (Session session = sessionFactoryConfig.getSession()) {
			session.beginTransaction();
			List<Order> orders = session.createQuery("select o from Order o where o.buyer=:buyer and o.product=:product")
					.setParameter("buyer",session.get(Buyer.class, buyerId))
					.setParameter("product",session.get(Product.class, productId))
					.getResultList();

			session.getTransaction().commit();
			return orders;
		}
	}

	public List<Product> getProductsByBuyerId(Long buyerId) {
		try (Session session = sessionFactoryConfig.getSession()) {
			session.beginTransaction();
			List<Product> products = session.createQuery("select p from Product p inner join Order o on o.product=p where o.buyer=:buyer")
					.setParameter("buyer",session.get(Buyer.class, buyerId))
					.getResultList();
			session.getTransaction().commit();
			return products;
		}
	}

	public List<Buyer> getBuyersByProductId(Long productId) {
		try (Session session = sessionFactoryConfig.getSession()) {
			session.beginTransaction();
			List<Buyer> buyers = session.createQuery("select b from Buyer b inner join Order o on o.buyer=b where o.product=:product")
					.setParameter("product",session.get(Product.class, productId))
					.getResultList();
			session.getTransaction().commit();
			return buyers;
		}
	}




}
