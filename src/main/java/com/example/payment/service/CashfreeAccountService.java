package com.example.payment.service;

import com.example.payment.config.CashfreeConfig;
import com.example.payment.dto.FeeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashfreeAccountService {

    private final CashfreeConfig config;

    public CashfreeConfig.Credentials getCredentialsForFee(FeeType feeType) {
        return switch (feeType) {
            case SKILL -> config.getAccounts().get("skill-acct");
            case COLLEGE -> config.getAccounts().get("college-acct");
        };
    }

    public String getAccountKeyForFee(FeeType feeType) {
        return switch (feeType) {
            case SKILL -> "skill-acct";
            case COLLEGE -> "college-acct";
        };
    }
}
