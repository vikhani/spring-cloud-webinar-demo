package edu.vikhani.springcloudwebinardemo.docgen.service;

import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ClientInfoService {
    private final RestTemplate restTemplate;

    public ClientInfo getClientInfo() {
        return restTemplate.getForObject("/client", ClientInfo.class);
    }
}
