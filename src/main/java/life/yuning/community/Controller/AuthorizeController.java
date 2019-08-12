package life.yuning.community.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import life.yuning.community.Provider.GithubProvider;
import life.yuning.community.dto.AccessTokenDTO;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code") String code,
			@RequestParam(name = "state") String state) {
		AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
		accessTokenDTO.setClent_id("723c1ced647d2fc1b3c0");
		accessTokenDTO.setClent_secret("9e1f8323f390e8aec114d36a4c0ce9db6f61cfa1");
		accessTokenDTO.setCode(code);
		accessTokenDTO.setRedirect_uri("http://localhost:8887/callbcack");
		accessTokenDTO.setState(state);
		githubProvider.getAccessToken(accessTokenDTO);
		return "index";
	}
}
