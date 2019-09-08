package hsq.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.hsq.springboot.study.AppConfig;
import com.hsq.springboot.study.domain.RQ;
import com.hsq.springboot.study.domain.RQ_City;
import com.hsq.springboot.study.service.CityService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public class CityServiceTest {
	@Autowired
	private CityService cityService;
	
	@Test
	public void test_Cache()
	{ 
		RQ_City rq=new RQ_City();
		rq.setCityId(1l);
		rq.setDescripton("山");
		for (int i=0; i<2 ;i++) 
		{
			cityService.getOne("2");
			cityService.all(rq);
		}
	}
    
	@Test 
	public void clear_Cache()
	{
			cityService.deletebyId(122);
	}

}
