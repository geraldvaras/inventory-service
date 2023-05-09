package com.grupolainmaculada.cloud.inventoryservice.receipt.service;

import com.grupolainmaculada.cloud.inventoryservice.receipt.domain.ReceiptItemRepository;
import com.grupolainmaculada.cloud.inventoryservice.receipt.domain.ReceiptRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReceiptService {

    private final ReceiptRepository receiptRepository;
    private final ReceiptItemRepository receiptItemRepository;

    public ReceiptService(
            ReceiptRepository receiptRepository,
            ReceiptItemRepository receiptItemRepository) {
        this.receiptRepository = receiptRepository;
        this.receiptItemRepository = receiptItemRepository;
    }


}
