package com.canteen.admin.model;

import com.canteen.admin.support.converter.IntegerEnumConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "shop")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date lastModified;
    private Date expiration;
    @Convert(converter = IntegerEnumConverter.class)
    @Column(name = "status")
    private ShopStatusEnum status;
}
