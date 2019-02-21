package com.bage.study.micro.services.zuul.dynamix.routes.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class RefreshRouteService {


    @Autowired
    ApplicationEventPublisher publisher;

}
