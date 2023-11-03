package edu.vikhani.springcloudwebinardemo.clientinfo.controller;

import edu.vikhani.springcloudwebinardemo.clientinfo.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.clientinfo.service.ClientInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ClientInfoController {

    private final ClientInfoService service;

    @GetMapping("/client")
    public ClientInfo getClientInfo() {
        log.info("Received request for client info.");
        return service.getClientInfo();
    }
}
