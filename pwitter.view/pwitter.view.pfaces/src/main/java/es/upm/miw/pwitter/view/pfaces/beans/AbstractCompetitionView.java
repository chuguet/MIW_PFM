package es.upm.miw.pwitter.view.pfaces.beans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public abstract class AbstractCompetitionView {

	private transient static final String PATTERN_DATE = "dd/MM/yyyy HH:mm";

	protected transient static final String API_URI = "http://localhost:8080/api";

	protected transient RestTemplate restClient;

	public AbstractCompetitionView() {
		initialiceRestTemplate();
	}

	public void initialiceRestTemplate() {
		RestTemplate restTemplate = new RestTemplate(httpRequestFactory());
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		messageConverters.add(jsonConverter());
		restTemplate.setMessageConverters(messageConverters);
		restClient = restTemplate;
	}

	public MappingJackson2HttpMessageConverter jsonConverter() {
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setDateFormat(new SimpleDateFormat(PATTERN_DATE));
		objectMapper.enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
		objectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
		converter.setObjectMapper(objectMapper);
		return converter;
	}

	public HttpClient httpClient() {

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager).build();

		connectionManager.setMaxTotal(100);
		connectionManager.setDefaultMaxPerRoute(100);

		return httpClient;
	}

	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}

}
