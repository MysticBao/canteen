package com.canteen.stall.model;

import lombok.*;

import java.util.Date;

/**
 * Stall details
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stall {
    private Long id;
    private String name;
    private String label;
    private Date createTime;
    private String description;
    private int status;
}
