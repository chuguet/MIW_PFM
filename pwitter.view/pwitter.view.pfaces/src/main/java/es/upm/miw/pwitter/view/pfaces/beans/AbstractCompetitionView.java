package es.upm.miw.pwitter.view.pfaces.beans;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public abstract class AbstractCompetitionView {

	public transient static final String API_URI = "http://localhost:8080/api";

	protected transient RestTemplate restClient = restTemplate();

	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}

	public RestTemplate restTemplate() {
		return new RestTemplate(httpRequestFactory());
	}

	public HttpClient httpClient() {

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager).build();

		connectionManager.setMaxTotal(100);
		connectionManager.setDefaultMaxPerRoute(100);

		return httpClient;
	}

}
