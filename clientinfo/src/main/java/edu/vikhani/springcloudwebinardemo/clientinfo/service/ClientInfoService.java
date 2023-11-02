package edu.vikhani.springcloudwebinardemo.clientinfo.service;

import edu.vikhani.springcloudwebinardemo.clientinfo.model.ClientInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class ClientInfoService {

    public ClientInfo getClientInfo() {
        log.info("Returning client info.");
        return new ClientInfo("Vasilyi", new BigDecimal(111), "B+");
    }

}
