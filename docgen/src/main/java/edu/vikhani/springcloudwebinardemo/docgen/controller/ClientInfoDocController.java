package edu.vikhani.springcloudwebinardemo.docgen.controller;

import edu.vikhani.springcloudwebinardemo.docgen.model.ClientInfoDoc;
import edu.vikhani.springcloudwebinardemo.docgen.service.ClientInfoDocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClientInfoDocController {

    private final ClientInfoDocService service;

    @GetMapping("/doc/client")
    public ClientInfoDoc getDoc() {
        return service.getClientInfoDoc();
    }
}
