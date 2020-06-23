package com.huelton.microservicecicd.sendemail.gateway.http;

import com.huelton.microservicecicd.sendemail.gateway.json.Message;
import com.huelton.microservicecicd.sendemail.service.message.SendEmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class MessageResource {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping(value = "/receive")
    public void receive(@RequestBody @Valid @NotNull Message message) throws InterruptedException {
        sendEmailService.execute(message);
    }

}
