package com.grupolainmaculada.cloud.inventoryservice.product.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

public interface BarCodeRepository extends CrudRepository<BarCode, BarCodeId> {

}
