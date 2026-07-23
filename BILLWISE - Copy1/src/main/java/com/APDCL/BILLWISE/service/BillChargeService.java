package com.APDCL.BILLWISE.service;

import com.APDCL.BILLWISE.entity.BillCharge;
import java.util.List;

public interface BillChargeService {

    BillCharge saveCharge(BillCharge charge);

    List<BillCharge> getAllCharges();

    BillCharge getChargeById(Long id);

    void deleteCharge(Long id);
}
