package com.api.crm.controller;

import com.api.crm.model.BillsToPay;
import com.api.crm.services.interfaces.IBillsToPayService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/billstopay"})
public class BillstToPayController {
   @Autowired
   IBillsToPayService billsToPayService;

   @GetMapping
   public List<BillsToPay> listBillsToPays(@RequestParam("date") String data, @RequestParam("idEmp") int idEmp) {
      return this.billsToPayService.getListBillsToPays(data, idEmp);
   }
}
