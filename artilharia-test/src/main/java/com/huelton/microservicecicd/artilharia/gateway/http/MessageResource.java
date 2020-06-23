package com.huelton.microservicecicd.artilharia.gateway.http;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.huelton.microservicecicd.artilharia.service.message.AttackService;

@Log4j2
@RestController
public class MessageResource {

    @Autowired
    private AttackService resendMessageService;

    @GetMapping(value = "/attack/{qtd}")
    public void attack(@PathVariable("qtd") String qtd) {
        log.info("Recebendo request de attack.");

        resendMessageService.execute(Integer.parseInt(qtd));
    }

}
