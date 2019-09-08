package hsq;


import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.hsq.springboot.study.AppConfig;
import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.redis.StringRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class RedisTemplateTest {
	@Autowired
	private StringRepository stringRepository;
	private Logger LOGGER = Logger.getLogger(getClass());
	@Test
	public void test(){
		
		String uuid = UUID.randomUUID().toString();
		City city = new City();
		city.setId(1l);
		city.setDescription("cq");
		this.stringRepository.set(uuid, city, 60);
		
		
		City cityRedis = this.stringRepository.find(uuid);
		
		LOGGER.debug(cityRedis.getId().toString());
		LOGGER.debug(cityRedis.getDescription());
		
		
		boolean exist = this.stringRepository.exist(uuid);
		
		System.out.println(exist);
		this.stringRepository.remove(uuid);
		
	}
}
