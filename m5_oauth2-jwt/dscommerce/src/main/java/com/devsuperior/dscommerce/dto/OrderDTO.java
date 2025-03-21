package com.devsuperior.dscommerce.dto;

import com.devsuperior.dscommerce.entities.Order;
import com.devsuperior.dscommerce.entities.OrderItem;
import com.devsuperior.dscommerce.entities.OrderStatus;
import jakarta.validation.constraints.NotEmpty;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Instant moment;
    private OrderStatus status;

    private UserMinDTO user;

    private PaymentDTO payment;

    @NotEmpty(message = "Deve ter pelo menos um item")
    private List<OrderItemDTO> items = new ArrayList<>();

    public OrderDTO(Long id, Instant moment, OrderStatus status, UserMinDTO userDTO, PaymentDTO paymentDTO) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.user = userDTO;
        this.payment = paymentDTO;
    }

    public OrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        user = new UserMinDTO(entity.getUser());
        payment = (entity.getPayment() == null) ? null : new PaymentDTO(entity.getPayment());
        for (OrderItem item : entity.getItems()) {
            items.add(new OrderItemDTO(item));
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public UserMinDTO getUser() {
        return user;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }
    
    public Double getTotal() {
        Double total = 0.0;
        for (OrderItemDTO item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
    
}
