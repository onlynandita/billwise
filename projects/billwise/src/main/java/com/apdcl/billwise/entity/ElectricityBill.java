package com.apdcl.billwise.entity;

import jakarta.persistence.*;

@Entity
@Table(name="electricity_bill")
public class ElectricityBill {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private Long consumer_no;


    private String consumerName; //CamelCasing

}
