package edu.vikhani.springcloudwebinardemo.docgen.service;

import edu.vikhani.springcloudwebinardemo.docgen.exception.ClientInfoNotFound;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfoDoc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
@RefreshScope
public class ClientInfoDocService {
    private final ClientInfoService clientInfoService;

    public ClientInfoDoc getClientInfoDoc() {
        log.info("Fetching client info");

        ClientInfo result =
                clientInfoService.getClientInfo();
        if (result == null) {
            log.info("Couldn't receive client info.");
            throw new ClientInfoNotFound("Couldn't receive client info.");
        }

        return new ClientInfoDoc(
                LocalDateTime.now(),
                result.name(),
                result.turnover().divide(BigDecimal.TEN, RoundingMode.DOWN)
        );
    }
}
