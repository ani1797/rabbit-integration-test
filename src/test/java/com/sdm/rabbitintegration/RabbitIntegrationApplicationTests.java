package com.sdm.rabbitintegration;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
class RabbitIntegrationApplicationTests {

	@ClassRule
	public static EmbeddedInMemoryQpidBrokerRule brokerRule = new EmbeddedInMemoryQpidBrokerRule();


	@Test
	public void contextLoads() throws Exception {

	}

}
