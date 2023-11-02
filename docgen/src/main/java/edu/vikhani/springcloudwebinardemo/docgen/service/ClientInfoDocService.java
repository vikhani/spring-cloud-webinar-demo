package edu.vikhani.springcloudwebinardemo.docgen.service;

import edu.vikhani.springcloudwebinardemo.docgen.exception.ClientInfoNotFound;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfoDoc;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ClientInfoDocService {
    private final RestTemplate restTemplate;

    @Value("${clientinfo.url}")
    private String clientInfoUrl;

    public ClientInfoDoc getClientInfoDoc() {

        ClientInfo result = restTemplate.getForObject(clientInfoUrl, ClientInfo.class);
        if (result == null) {
            throw new ClientInfoNotFound("Couldn't receive client info");
        }

        return new ClientInfoDoc(
                LocalDateTime.now(),
                result.name(),
                result.turnover().divide(BigDecimal.TEN, RoundingMode.DOWN)
        );
    }
}
