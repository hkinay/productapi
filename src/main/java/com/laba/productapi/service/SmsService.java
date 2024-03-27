package com.laba.productapi.service;

import com.laba.productapi.Entity.Order;
import com.laba.productapi.Entity.Users;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SmsService {

    @Async
    public void sendSms(Order order, Users users) {

        ReplaceFunction replaceFunction = (template,name,orderNumber) -> template.replace("İSİM",name).replace("SiparisNo",orderNumber);

        String orderNumber = order.getOrderNumber();
        String name = users.getName();
        String email = users.getEmail();
        if (StringUtils.hasText(orderNumber)){
            String smsicerik = "Değerli Müşterimiz İSİM siparişiniz alındı.Sipariş Numarası SiparisNo. Yarın teslimat ile aynı gün kargoya verilecektir";
        smsicerik = replaceFunction.replace(smsicerik,name,orderNumber);
        }

        try {
            Thread.sleep(3000);

        }
        catch (InterruptedException e){
            throw new RuntimeException();
        }


    }
}
