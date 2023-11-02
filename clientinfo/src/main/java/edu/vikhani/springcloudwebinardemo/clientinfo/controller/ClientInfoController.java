package edu.vikhani.springcloudwebinardemo.clientinfo.controller;

import edu.vikhani.springcloudwebinardemo.clientinfo.model.ClientInfo;
import edu.vikhani.springcloudwebinardemo.clientinfo.service.ClientInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientInfoController {

    private final ClientInfoService service;

    @GetMapping("/client")
    public ClientInfo getClientInfo() {
        return service.getClientInfo();
    }
}
