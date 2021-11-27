package com.api.crm.services.interfaces;

import com.api.crm.model.BillsToPay;
import java.util.List;

public interface IBillsToPayService {
   List<BillsToPay> getListBillsToPays(String data, int idEmp);
}
