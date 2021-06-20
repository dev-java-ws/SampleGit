package io.friendlyfoods.gitspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitSpringBootSample {

	public GitSpringBootSample() {
	}
	
	@RequestMapping("/messages")
	public String getMessageFromClass() {
		return "<html><body><font color=green><b>Hello  from GitSpringBootSample</b></font></body></html>";
	}

}
