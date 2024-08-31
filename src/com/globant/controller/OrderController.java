package com.globant.controller;

import com.globant.service.OrderService;
import com.globant.view.ConsoleView;

public class OrderController {

    private ConsoleView view;
    private OrderService orderService;

    public OrderController(OrderService orderService, ConsoleView view) {
        this.orderService = orderService;
        this.view = view;
    }

}
