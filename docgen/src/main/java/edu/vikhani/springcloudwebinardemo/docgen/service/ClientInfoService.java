package edu.vikhani.springcloudwebinardemo.docgen.service;

import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "clientinfo")
public interface ClientInfoService {
    @GetMapping(value = "/client")
    ClientInfo getClient();
}
