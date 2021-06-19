package io.friendlyfoods.ffspringbootconfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author devia
 *
 */
@RestController
public class GreetingController {

	@Value("${my.greeting:defaultVal if cant find from appprops file}")
	private String greetingMessage;
	
	@Value("  some static message")
	private String staticMessage;
	
	@Value("${my.getlistfrompropfile.values : one,two,three}")
	private List<String> listValues;
	
	@Value("#{${dbValues}}")       //"${}" as just an string.. for exp use #{}
	private Map<String, String> dbValues;
	
	@Autowired 
	private DbSettingsFromProps dbSettingsFromProps;
	
	@Autowired
	private Environment env;  //not a good idea to use
	
	public GreetingController() {
	}

	@GetMapping("/greeting")
	public String greeting() {System.out.println("------"+greetingMessage);
		Set<String> keysFromMap = dbValues.keySet();
		for(String key : keysFromMap) System.out.println(key +"   "+dbValues.get(key));
		
		//return greetingMessage;
	    return greetingMessage + staticMessage + listValues + dbValues + dbSettingsFromProps.getDbPort();
	}
	
	@GetMapping("/envdetails")
	public String envDetails() {
		return env.toString() + " " + env.getProperty("profiles");
	}
	
}
