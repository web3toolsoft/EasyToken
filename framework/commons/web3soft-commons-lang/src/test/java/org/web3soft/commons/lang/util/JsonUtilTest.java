package org.web3soft.commons.lang.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3soft.commons.lang.util.model.UserDO;

import java.math.BigDecimal;

/**
 * @author web3soft-team
 * @since 1.0.0
 */
@Slf4j
public class JsonUtilTest {

    @BeforeEach
    void setup() {
    }

    @Test
    public void toJSONStringTest() {
        final UserDO userDO = UserDO.builder()
                .firstName("tom")
                .lastName("crius")
                .age(60)
                .sex("male")
                .weight(75)
                .height(175)
                .assets(new BigDecimal("200000000.2343"))
                .build();
        final String json = JsonUtil.toJSONString(userDO);
        log.info("json:{}", json);
    }

    @Test
    public void parseJsonObjectTest() {
    }
}