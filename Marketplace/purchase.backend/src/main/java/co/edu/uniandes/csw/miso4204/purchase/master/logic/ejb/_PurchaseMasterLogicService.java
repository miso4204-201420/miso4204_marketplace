/* ========================================================================
 * Copyright 2014 miso4204
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 miso4204

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.miso4204.purchase.master.logic.ejb;

import co.edu.uniandes.csw.miso4204.purchaseitem.logic.dto.PurchaseItemDTO;
import co.edu.uniandes.csw.miso4204.purchaseitem.persistence.PurchaseItemPersistence;

import co.edu.uniandes.csw.miso4204.payment.logic.dto.PaymentDTO;
import co.edu.uniandes.csw.miso4204.payment.persistence.PaymentPersistence;

import co.edu.uniandes.csw.miso4204.purchase.logic.dto.PurchaseDTO;
import co.edu.uniandes.csw.miso4204.purchase.master.logic.dto.PurchaseMasterDTO;
import co.edu.uniandes.csw.miso4204.purchase.master.persistence.entity.PurchasepurchaseItemEntity;
import co.edu.uniandes.csw.miso4204.purchase.master.persistence.entity.PurchasepaymentEntity;
import co.edu.uniandes.csw.miso4204.purchase.master.persistence.PurchaseMasterPersistence;


public abstract class _PurchaseMasterLogicService {

 

    protected PurchaseMasterPersistence purchaseMasterPersistance;
   
    protected PurchaseItemPersistence purchaseItemPersistance;
    protected PaymentPersistence paymentPersistance;

    public PurchaseMasterDTO createMasterPurchase(PurchaseMasterDTO purchase) {
        PurchaseDTO persistedPurchaseDTO = purchaseMasterPersistance.createPurchase(purchase.getPurchaseEntity());
        if (purchase.getCreatepurchaseItem() != null) {
            for (PurchaseItemDTO purchaseItemDTO : purchase.getCreatepurchaseItem()) {
                PurchaseItemDTO createdPurchaseItemDTO = purchaseItemPersistance.createPurchaseItem(purchaseItemDTO);
                PurchasepurchaseItemEntity purchasePurchaseItemEntity = new PurchasepurchaseItemEntity(persistedPurchaseDTO.getId(), createdPurchaseItemDTO.getId());
                purchaseMasterPersistance.createPurchasepurchaseItemEntity(purchasePurchaseItemEntity);
            }
        }
        if (purchase.getCreatepayment() != null) {
            for (PaymentDTO paymentDTO : purchase.getCreatepayment()) {
                PaymentDTO createdPaymentDTO = paymentPersistance.createPayment(paymentDTO);
                PurchasepaymentEntity purchasePaymentEntity = new PurchasepaymentEntity(persistedPurchaseDTO.getId(), createdPaymentDTO.getId());
                purchaseMasterPersistance.createPurchasepaymentEntity(purchasePaymentEntity);
            }
        }
        // update purchaseItem
        if (purchase.getUpdatepurchaseItem() != null) {
            for (PurchaseItemDTO purchaseItemDTO : purchase.getUpdatepurchaseItem()) {
                purchaseItemPersistance.updatePurchaseItem(purchaseItemDTO);
                PurchasepurchaseItemEntity purchasePurchaseItemEntity = new PurchasepurchaseItemEntity(persistedPurchaseDTO.getId(), purchaseItemDTO.getId());
                purchaseMasterPersistance.createPurchasepurchaseItemEntity(purchasePurchaseItemEntity);
            }
        }
        // update payment
        if (purchase.getUpdatepayment() != null) {
            for (PaymentDTO paymentDTO : purchase.getUpdatepayment()) {
                paymentPersistance.updatePayment(paymentDTO);
                PurchasepaymentEntity purchasePaymentEntity = new PurchasepaymentEntity(persistedPurchaseDTO.getId(), paymentDTO.getId());
                purchaseMasterPersistance.createPurchasepaymentEntity(purchasePaymentEntity);
            }
        }
        return purchase;
    }

    public PurchaseMasterDTO getMasterPurchase(Long id) {
        return purchaseMasterPersistance.getMasterPurchase(id);
    }

    public void deleteMasterPurchase(Long id) {
        purchaseMasterPersistance.deletePurchase(id);
    }

    public void updateMasterPurchase(PurchaseMasterDTO purchase) {
        purchaseMasterPersistance.updatePurchase(purchase.getPurchaseEntity());

        //---- FOR RELATIONSHIP
        // persist new purchaseItem
        if (purchase.getCreatepurchaseItem() != null) {
            for (PurchaseItemDTO purchaseItemDTO : purchase.getCreatepurchaseItem()) {
                PurchaseItemDTO createdPurchaseItemDTO = purchaseItemPersistance.createPurchaseItem(purchaseItemDTO);
                PurchasepurchaseItemEntity purchasePurchaseItemEntity = new PurchasepurchaseItemEntity(purchase.getPurchaseEntity().getId(), createdPurchaseItemDTO.getId());
                purchaseMasterPersistance.createPurchasepurchaseItemEntity(purchasePurchaseItemEntity);
            }
        }
        // update purchaseItem
        if (purchase.getUpdatepurchaseItem() != null) {
            for (PurchaseItemDTO purchaseItemDTO : purchase.getUpdatepurchaseItem()) {
                purchaseItemPersistance.updatePurchaseItem(purchaseItemDTO);
            }
        }
        // delete purchaseItem
        if (purchase.getDeletepurchaseItem() != null) {
            for (PurchaseItemDTO purchaseItemDTO : purchase.getDeletepurchaseItem()) {
                purchaseMasterPersistance.deletePurchasepurchaseItemEntity(purchase.getPurchaseEntity().getId(), purchaseItemDTO.getId());
                purchaseItemPersistance.deletePurchaseItem(purchaseItemDTO.getId());
            }
        }
        // persist new payment
        if (purchase.getCreatepayment() != null) {
            for (PaymentDTO paymentDTO : purchase.getCreatepayment()) {
                PaymentDTO createdPaymentDTO = paymentPersistance.createPayment(paymentDTO);
                PurchasepaymentEntity purchasePaymentEntity = new PurchasepaymentEntity(purchase.getPurchaseEntity().getId(), createdPaymentDTO.getId());
                purchaseMasterPersistance.createPurchasepaymentEntity(purchasePaymentEntity);
            }
        }
        // update payment
        if (purchase.getUpdatepayment() != null) {
            for (PaymentDTO paymentDTO : purchase.getUpdatepayment()) {
                paymentPersistance.updatePayment(paymentDTO);
            }
        }
        // delete payment
        if (purchase.getDeletepayment() != null) {
            for (PaymentDTO paymentDTO : purchase.getDeletepayment()) {
                purchaseMasterPersistance.deletePurchasepaymentEntity(purchase.getPurchaseEntity().getId(), paymentDTO.getId());
                paymentPersistance.deletePayment(paymentDTO.getId());
            }
        }
    }
}
