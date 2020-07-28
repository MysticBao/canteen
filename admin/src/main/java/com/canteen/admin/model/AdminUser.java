package com.canteen.admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * The admin user was the role which has the permission to login the provisioning page.
 * The user has the permission to configure the shop.
 */
@Entity
@Table(name = "user_admin")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;
    @UpdateTimestamp
    private Date lastModified;
    private Integer status;
    private Date lastLoginTime;
}
