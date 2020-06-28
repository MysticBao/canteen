package com.canteen.stall.model.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductBrand {
    private Long id;
    private String name;
    private String label;
    private String description;
    private Date createTime;
    private Date lastUpdateTime;
}
