package org.team7.house.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.team7.config.RootConfig;
import org.team7.house.dto.HouseDTO;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class} )
@Log4j2
class HouseServiceImplTest {

    @Autowired
    private HouseService houseService;

    @Test
    void getAllHome() {
        for(HouseDTO houseDTO : houseService.getAllHome()) {
            log.info(houseDTO);
        }
    }

    @Test
    void getHome() {

    }
}