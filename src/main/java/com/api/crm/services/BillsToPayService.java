package com.api.crm.services;

import com.api.crm.model.BillsToPay;
import com.api.crm.repositories.interfaces.IBillsToPayRepository;
import com.api.crm.services.interfaces.IBillsToPayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BillsToPayService implements IBillsToPayService {
   @Autowired
   IBillsToPayRepository billstoPayRepository;

   public List<BillsToPay> getListBillsToPays(String data, int idEmp) {
      return this.billstoPayRepository.getListBillsToPays(data, idEmp);
   }
}
