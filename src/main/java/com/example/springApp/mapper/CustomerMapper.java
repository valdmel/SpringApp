package com.example.springApp.mapper;

import com.example.springApp.dto.CustomerDTO;
import com.example.springApp.entity.CustomerEntity;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerEntity toCustomerEntity(CustomerDTO customerDTO);
    CustomerDTO toCustomerDTO(CustomerEntity customerEntity);
    List<CustomerDTO> toCustomerDTOList(List<CustomerEntity> customerEntities);
}
