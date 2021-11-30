package ru.geekbrains.homework6;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import ru.geekbrains.homework6.services.OrderService;

@Slf4j
@SpringBootApplication
public class Homework6Application implements CommandLineRunner {

	private ApplicationContext context;

	@Autowired
	public void context(ApplicationContext context) { this.context = context; }

	public static void main(String[] args) {
		new SpringApplicationBuilder(Homework6Application.class)
				.web(WebApplicationType.NONE)
				.run(args);

	}

	@Override
	public void run(String... args) throws Exception {

		OrderService orderService = context.getBean(OrderService.class);

		orderService.getOrdersByProductIdAndBuyerId(1L,1L)
				.forEach(o->log.info("order -> buyer: {}, product: {}, cost: {}",o.getBuyer().getName(), o.getProduct().getTitle(), o.getCost()));

		orderService.getProductsByBuyerId(1L)
				.forEach(p->log.info("product -> {}",p));

		orderService.getBuyersByProductId(2L)
				.forEach(b->log.info("buyer -> {}",b));
	}
}
