package ru.job4j.mapstruct;

import org.mapstruct.factory.Mappers;
import ru.job4j.mapstruct.dto.DeliveryAddressDto;
import ru.job4j.mapstruct.mappers.DeliveryAddressMapper;
import ru.job4j.mapstruct.model.AddressEntity;
import ru.job4j.mapstruct.model.StudentEntity;

public class Main {

    public static void main(String[] args) {
        DeliveryAddressMapper deliveryAddressMapper = Mappers
                .getMapper(DeliveryAddressMapper.class);
        StudentEntity sEntity = new StudentEntity(0, "Ivan", "junior");
        AddressEntity address = new AddressEntity(100, "cityGood", "stateNew");
        DeliveryAddressDto deliveryAddressDTO = deliveryAddressMapper
                .getDeliveryAddress(sEntity, address);
        System.out.println("deliveryAddressDTO = " + deliveryAddressDTO);
    }

}