package life.yuning.community.Provider;

import org.springframework.stereotype.Component;

import life.yuning.community.dto.AccessTokenDTO;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class GithubProvider {
	public String getAccessToken(AccessTokenDTO accessTokenDTO) {
		MediaType JSON= MediaType.get("application/json; charset=utf-8");

		OkHttpClient client = new OkHttpClient();

	  RequestBody body = RequestBody.create(JSON, json);
	  Request request = new Request.Builder()
	      .url("https://github.com/login/oauth/authorize")
	      .post(body)
	      .build();
	  try (Response response = client.newCall(request).execute()) {
	    return response.body().string();
	  }
	}
	}
		
}

 