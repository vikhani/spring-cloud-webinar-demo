package edu.vikhani.springcloudwebinardemo.docgen.service;

import edu.vikhani.springcloudwebinardemo.docgen.exception.ClientInfoNotFound;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfoDoc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientInfoDocService {
    private final RestTemplate restTemplate;

    @Value("${clientinfo.url}")
    private String clientInfoUrl;

    public ClientInfoDoc getClientInfoDoc() {
        log.info("Fetching client info from {}.", clientInfoUrl);
        ClientInfo result = restTemplate.getForObject(clientInfoUrl, ClientInfo.class);
        if (result == null) {
            log.info("Couldn't receive client info from {}", clientInfoUrl);
            throw new ClientInfoNotFound("Couldn't receive client info.");
        }

        return new ClientInfoDoc(
                LocalDateTime.now(),
                result.name(),
                result.turnover().divide(BigDecimal.TEN, RoundingMode.DOWN)
        );
    }
}
