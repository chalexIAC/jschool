package tshop.back.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

/**
 * Created by Роднуля on 30.03.2017.
 */
@Table(name = "ESHOP.ORDERS")
@Entity
public class Order {


    @Id
    @Column
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    long id;

    @Column(name = "PAYMENT_METHOD")
    String paymentMethod;

    @Column(name="DELIVERY_METHOD")
    String deliveryMethod;

    @Column(name="PAYMENT_STATUS")
    String paymentStatus;

    @Column(name="STATUS")
    String status;

    @Column(name = "CREATED_AT")
    Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENT")
    Client client;

//    @OneToMany
//    @JoinColumn(name="ORDER_ID", referencedColumnName="ID")
//    private List<OrdersGoodsPrice> goodsprices;

    @ManyToMany
    @JoinTable(name="ESHOP.ORDERS_GOODS",
            joinColumns = {@JoinColumn(name="ID_ORDER")},
            inverseJoinColumns = {@JoinColumn(name="ID_GOODS")})
    List<Goods> goods;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant created_at) {
        this.createdAt = created_at;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
