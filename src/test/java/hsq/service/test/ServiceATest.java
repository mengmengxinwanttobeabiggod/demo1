package hsq.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hsq.springboot.study.AppConfig;
import com.hsq.springboot.study.domain.City;
import com.hsq.springboot.study.service.ServiceA;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class ServiceATest {
   
	@Resource
	private ServiceA serviceA;
	
	@Test
	public void add()
	{
		City city=new City();
		city.setId(1000l);
		city.setDescription("A");
		city.setProvinceId(1l);
		city.setCityName("xxxxx");
		serviceA.update(city);
	
	}
}
