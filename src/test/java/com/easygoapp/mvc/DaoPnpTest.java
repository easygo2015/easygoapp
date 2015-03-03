package com.easygoapp.mvc;

import com.easygoapp.config.RootConfig;
import com.easygoapp.domain.PassengerNodePoint;
import com.easygoapp.service.PassengerNodePointService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfig.class)
public class DaoPnpTest {

    @Autowired
    private PassengerNodePointService passengerNodePointService;


    @Test
    public void save(){
        PassengerNodePoint point = new PassengerNodePoint();
        point.setDescription("one");
        point.setLatitude(111d);
        point.setLongitude(222d);
        point.setLeft(true);

        PassengerNodePoint saved = passengerNodePointService.save(point);
        System.out.println(saved);
    }
}
