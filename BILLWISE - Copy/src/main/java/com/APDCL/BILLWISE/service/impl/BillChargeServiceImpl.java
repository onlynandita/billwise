package com.APDCL.BILLWISE.service.impl;

import com.APDCL.BILLWISE.entity.BillCharge;
import com.APDCL.BILLWISE.repository.BillChargeRepository;
import com.APDCL.BILLWISE.service.BillChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillChargeServiceImpl implements BillChargeService {

    @Autowired
    private BillChargeRepository billChargeRepository;

    @Override
    public BillCharge saveCharge(BillCharge charge) {
        return billChargeRepository.save(charge);
    }

    @Override
    public List<BillCharge> getAllCharges() {
        return billChargeRepository.findAll();
    }

    @Override
    public BillCharge getChargeById(Long id) {
        return billChargeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCharge(Long id) {
        billChargeRepository.deleteById(id);
    }
}
