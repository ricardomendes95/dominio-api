package com.api.crm.repositories.interfaces;

import com.api.crm.model.BillsToPay;
import java.util.List;

public interface IBillsToPayRepository {
   List<BillsToPay> getListBillsToPays(String data, int idEmp);
}
