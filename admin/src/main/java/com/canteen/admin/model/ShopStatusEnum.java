package com.canteen.admin.model;

import java.util.Objects;

/**
 * The Status for shops
 * When the shop was signed, the status is 0.
 * When the shop was overdue in 1 month, the status is 1.
 * When the shop was overdue more than 1 month, the status changed to be 2.
 * When the status == 1, the function still works, but the user would receive overdue message.
 * When the status == 2, the function will not work.
 */

public enum ShopStatusEnum {
    ALIVE(0), OVERDUE(1), UNSIGNED(2);

    private Integer value;

    private ShopStatusEnum(Integer i) {
        this.value = i;
    }

    public Integer getValue() {
        return value;
    }

    public static ShopStatusEnum fromValue(Integer value) {
        for (ShopStatusEnum statusEnum : ShopStatusEnum.values()) {
            if (Objects.equals(value, statusEnum.getValue())) {
                return statusEnum;
            }
        }
        throw new IllegalArgumentException();
    }
}
