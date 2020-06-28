package com.canteen.stall.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductInfo {
    private Long id;
    private String name;
    private String icon;
    private String description;
    private int status;
    private Money price;
    private Long category_id;
    private Long brand_id;
    private Date createTime;
    private Date lastUpdateTime;
}
