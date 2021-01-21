package com.py.agw.sample.tracecenter.query;

import java.io.Serializable;

/**
 * description
 *
 * @author budingxie
 * @version 1.0.0
 * @date 2021/1/21
 */
public class OrderQuery implements Serializable {

    private static final long serialVersionUID = 4648022622867825336L;

    private Long id;

    private String buyerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Override
    public String toString() {
        return "OrderQuery{" +
                "id=" + id +
                ", buyerName='" + buyerName + '\'' +
                '}';
    }
}
