package com.canteen.admin.support.converter;

import com.canteen.admin.model.ShopStatusEnum;

import javax.persistence.AttributeConverter;

public class IntegerEnumConverter implements AttributeConverter<ShopStatusEnum,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ShopStatusEnum shopStatusEnum) {
        return shopStatusEnum.getValue();
    }

    @Override
    public ShopStatusEnum convertToEntityAttribute(Integer value) {
        return ShopStatusEnum.fromValue(value);
    }
}
