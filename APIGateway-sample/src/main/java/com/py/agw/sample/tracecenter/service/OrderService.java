package com.py.agw.sample.tracecenter.service;

import com.py.agw.sample.tracecenter.model.OrderDTO;
import com.py.agw.sample.tracecenter.query.OrderQuery;
import com.py.agw.sample.tracecenter.result.Result;

import java.util.List;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/21
 */
public interface OrderService {

    Result<List<OrderDTO>> queryOrders(OrderQuery query);
}
