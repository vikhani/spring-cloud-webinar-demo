package edu.vikhani.springcloudwebinardemo.clientinfo.service;

import edu.vikhani.springcloudwebinardemo.clientinfo.model.ClientInfo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ClientInfoService {

    public ClientInfo getClientInfo() {
        return new ClientInfo("Vasilyi", new BigDecimal(111), "B+");
    }

}
