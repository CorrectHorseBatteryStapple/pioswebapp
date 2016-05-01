package hr.tvz.car.parts.shop.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hr.tvz.car.parts.shop.model.CartOrder;
import hr.tvz.car.parts.shop.model.OrderProduct;
import hr.tvz.car.parts.shop.model.enums.CartUpdateType;
import hr.tvz.car.parts.shop.repository.CartOrderRepository;
import hr.tvz.car.parts.shop.repository.UserRepository;
import hr.tvz.car.parts.shop.repository.codebook.OrderStatusRepository;

@Service
@Transactional
public class CartOrderServiceImpl implements CartOrderService {

    @Autowired
    private CartOrderRepository   cartOrderRepository;

    @Autowired
    private UserRepository        userRepository;

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private ProductService        productService;

    @Override
    public CartOrder findUserCartDetails(Long userId) {

        // Only 1 active cart per user - where status is IN_CART
        return cartOrderRepository.findByUserIdAndOrderStatusStatus(userId, "IN_CART");
    }

    @Override
    public void updateCart(Long userId, Long productId, CartUpdateType cartUpdateType) {
        CartOrder cartOrder = cartOrderRepository.findByUserId(userId);

        if (cartOrder == null) {
            // new cart order
            CartOrder newCartOrder = new CartOrder();
            newCartOrder.setUser(userRepository.findOne(userId));
            newCartOrder.setTimestamp(LocalDateTime.now());
            newCartOrder.setOrderStatus(orderStatusRepository.findByStatus("IN_CART"));
            cartOrderRepository.save(newCartOrder);

            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(newCartOrder);
            orderProduct.setProduct(productService.findProduct(productId));
            // save

            List<OrderProduct> orderProductList = new ArrayList<>();
            orderProductList.add(orderProduct);

            newCartOrder.setOrderProductList(orderProductList);
            cartOrderRepository.save(newCartOrder);
        } else {
            if (cartUpdateType.equals(CartUpdateType.ADD)) {
                OrderProduct orderProductAdd = new OrderProduct();
                orderProductAdd.setOrder(cartOrder);

                cartOrder.getOrderProductList().add(orderProductAdd);
            } else if (cartUpdateType.equals(CartUpdateType.DELETE)) {
                Iterator<OrderProduct> iterator = cartOrder.getOrderProductList().iterator();
                while (iterator.hasNext()) {
                    OrderProduct orderProductToDelete = iterator.next();
                    if (orderProductToDelete.getId().equals(productId)) {
                        iterator.remove();
                        break;
                    }
                }
                cartOrderRepository.save(cartOrder);
            }
        }
    }

}
