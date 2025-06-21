package com.example.payment;

import com.example.payment.service.CashfreeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentStatusScheduler {

    private final CashfreeService cashfreeService;

    @Scheduled(fixedRate =60* 60 * 1000)
    public void checkPendingPayments() {
        log.info("Checking pending payments...");

        cashfreeService.updatePendingPayments();

        log.info("Finished checking pending payments.");
    }
}
