package edu.vikhani.springcloudwebinardemo.docgen.service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import edu.vikhani.springcloudwebinardemo.docgen.exception.ClientInfoNotFound;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfoDoc;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final EurekaClient eurekaClient;

    public ClientInfoDoc getClientInfoDoc() {
        log.info("Fetching client info");

        InstanceInfo service = eurekaClient
                .getApplication("clientinfo")
                .getInstances()
                .get(0);

        String urlFromEureka = "http://" + service.getHostName() + ":" + service.getPort() + "/client";

        ClientInfo result =
                restTemplate.getForObject(urlFromEureka, ClientInfo.class);
        if (result == null) {
            log.info("Couldn't receive client info from {}.", urlFromEureka);
            throw new ClientInfoNotFound("Couldn't receive client info.");
        }

        return new ClientInfoDoc(
                LocalDateTime.now(),
                result.name(),
                result.turnover().divide(BigDecimal.TEN, RoundingMode.DOWN)
        );
    }
}
