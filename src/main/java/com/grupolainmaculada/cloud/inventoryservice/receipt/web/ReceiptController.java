package com.grupolainmaculada.cloud.inventoryservice.receipt.web;

import com.grupolainmaculada.cloud.inventoryservice.receipt.service.ReceiptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    public ReceiptController(ReceiptService receiptService) {
        this.receiptService = receiptService;
    }


}
