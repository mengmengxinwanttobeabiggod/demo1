package hsq;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hsq.springboot.study.AppConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfig.class)
public class ActivityService {
   
	@Autowired
	public RuntimeService service;
	
	@Test
	public void  test()
	{
		   String processDefinitionKey = "helloid";
		  Map<String ,Object> variables=new HashMap<>();
		  variables.put("name", "i love you");
		  service.startProcessInstanceByKey(processDefinitionKey, variables);
	}
}
