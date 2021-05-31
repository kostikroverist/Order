package com.example.order;

import com.example.order.domain.Items;
import com.example.order.domain.Orders;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrdersService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;


@SpringBootTest
@RunWith(SpringRunner.class)
class OrdersApplicationTests {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrdersService ordersService;



	@Test
	void saveOrderTest(){
		List<Orders> list = orderRepository.findAll();
		assertThat(list, hasSize(0));
		Orders orders = new Orders();
		Items  items = new Items();
		items.setName("pen");
		items.setPrice(12.00);
		items.setQuantity(2);
		orders.setItems(List.of(items));;

		ordersService.saveOrder(orders);

		list = orderRepository.findAll();
		assertThat(list, hasSize(1));
	}

	@Test
	void deleteAllWhereValidityOrdersFalseTest(){
		Orders orders2 = new Orders();
		Items  items2 = new Items();
		items2.setName("pen");
		items2.setPrice(12.00);
		items2.setQuantity(2);
		orders2.setItems(List.of(items2));;
		orders2.setValidityOrders(false);
			ordersService.saveOrder(orders2);
		ordersService.deleteAllWhereValidityOrdersFalse();
		List<Orders> list = orderRepository.findAll();
		assertThat(list, hasSize(0));

	}
}
