package com.grupolainmaculada.cloud.inventoryservice.demo;

import com.grupolainmaculada.cloud.inventoryservice.product.domain.Fraction;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.Product;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductId;
import com.grupolainmaculada.cloud.inventoryservice.product.domain.ProductRepository;
import com.grupolainmaculada.cloud.inventoryservice.purchaseorder.domain.*;
import com.grupolainmaculada.cloud.inventoryservice.receipt.domain.ReceiptObservationType;
import com.grupolainmaculada.cloud.inventoryservice.receipt.domain.ReceiptObservationTypeId;
import com.grupolainmaculada.cloud.inventoryservice.receipt.domain.ReceiptObservationTypeRepository;
import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.Supplier;
import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.SupplierId;
import com.grupolainmaculada.cloud.inventoryservice.supplier.domain.SupplierRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;

@Component
@Profile("testdata")
public class InventoryDataLoader {


    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ReceiptObservationTypeRepository receiptObservationTypeRepository;

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public InventoryDataLoader(
            ProductRepository productRepository, SupplierRepository supplierRepository,
            ReceiptObservationTypeRepository receiptObservationTypeRepository,
            PurchaseOrderRepository purchaseOrderRepository, PurchaseOrderItemRepository purchaseOrderItemRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.receiptObservationTypeRepository = receiptObservationTypeRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadProductTestData() {
        var id1 = ProductId.of("002", "001", "001", "30028600");
        var id2 = ProductId.of("002", "001", "001", "30026377");
        var p1 = Product.of(id1, "AVENA GRANO DE ORO KIWICH 170G", Fraction.of(1),
                new BigDecimal("1.50"), new BigDecimal("1.1530"));
        var p2 = Product.of(id2, "AVENA GRANO DE ORO MACA 170G", Fraction.of(1),
                new BigDecimal("1.80"), new BigDecimal("1.3419"));

        Optional<Product> optPro1 = productRepository.findById(id1);
        Optional<Product> optPro2 = productRepository.findById(id2);

        if (optPro1.isEmpty()) {
            productRepository.save(p1);
        }

        if (optPro2.isEmpty()) {
            productRepository.save(p2);
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadPurchaseOrderTestData() {
        PurchaseOrderId purchaseOrderId = PurchaseOrderId.of("002", "001", "070800");

        Optional<PurchaseOrder> orderOptional = purchaseOrderRepository.findById(purchaseOrderId);

        if (orderOptional.isPresent()) {
            // Purchase order already exists, no need to create it
            PurchaseOrder order = orderOptional.get();

            PurchaseOrderItem orderDet1 = PurchaseOrderItem
                    .of(order, PurchaseOrderItemId.of(purchaseOrderId, 1), "30021231",
                            "QUESO MOZZARELLA DANE X KG", "1000",
                            1000, 8, 0, 0, 8000);

            PurchaseOrderItem orderDet2 = PurchaseOrderItem
                    .of(order, PurchaseOrderItemId.of(purchaseOrderId, 2), "30021231",
                            "QUESO FRESCO DANE X KG", "1000",
                            1000, 12, 0, 0, 12000);

            Set<PurchaseOrderItem> items = Set.of(orderDet1, orderDet2);

            order.setItems(items); // set the PurchaseOrder on the PurchaseOrderItem objects

            purchaseOrderItemRepository.saveAll(items); // save the PurchaseOrderItem objects
        } else {
            // Purchase order does not exist, create it and the PurchaseOrderItem objects
            PurchaseOrder order = PurchaseOrder.of(purchaseOrderId);

            PurchaseOrderItem orderDet1 = PurchaseOrderItem
                    .of(order, PurchaseOrderItemId.of(purchaseOrderId, 1), "30021231",
                            "QUESO MOZZARELLA DANE X KG", "1000",
                            1000, 8, 0, 0, 8000);

            PurchaseOrderItem orderDet2 = PurchaseOrderItem
                    .of(order, PurchaseOrderItemId.of(purchaseOrderId, 2), "30021231",
                            "QUESO FRESCO DANE X KG", "1000",
                            1000, 12, 0, 0, 12000);

            Set<PurchaseOrderItem> items = Set.of(orderDet1, orderDet2);

            order.setItems(items); // set the PurchaseOrder on the PurchaseOrderItem objects

            purchaseOrderRepository.save(order); // save the PurchaseOrder first
            purchaseOrderItemRepository.saveAll(items); // save the PurchaseOrderItem objects
        }
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadReceiptObservationTypesTestData() {
        var id1 = ReceiptObservationTypeId.of("002", 1);
        var id2 = ReceiptObservationTypeId.of("002", 2);
        var rt1 = ReceiptObservationType.of(id1, "OK", "SIN ACCION", 1);
        var rt2 = ReceiptObservationType
                .of(id2, "PRODUCTO NO SE ENCUENTRA EN LA ORDEN DE COMPRA", "SIN ACCION", 1);

        var optTipObs1 = this.receiptObservationTypeRepository.findById(id1);
        var optTipObs2 = this.receiptObservationTypeRepository.findById(id2);

        if(optTipObs1.isEmpty()) {
            receiptObservationTypeRepository.save(rt1);
        }

        if(optTipObs2.isEmpty()) {
            receiptObservationTypeRepository.save(rt2);
        }

    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadSuppliersTestData() {
        var id1 = SupplierId.of("002", "001481");
        var id2 = SupplierId.of("002", "002550");
        var s1 = Supplier.of(id1, "AGROINDUSTRIAS DANE S. R.L", "20531598009");
        var s2 = Supplier.of(id2, "DON POLLO TROPICAL S.A.C", "20450497950");

        Optional<Supplier> optionalSupplier1 = supplierRepository.findById(id1);
        Optional<Supplier> optionalSupplier2 = supplierRepository.findById(id2);

        if (optionalSupplier1.isEmpty()) {
            supplierRepository.save(s1);
        }

        if (optionalSupplier2.isEmpty()) {
            supplierRepository.save(s2);
        }
    }

}
