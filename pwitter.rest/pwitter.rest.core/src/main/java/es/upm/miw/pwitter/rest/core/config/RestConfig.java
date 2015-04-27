package es.upm.miw.pwitter.rest.core.config;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("es.upm.miw.pwitter.rest")
@PropertySource("classpath:restClientConfig.properties")
public class RestConfig {

	@Value("${max.total.connections.default}")
	private Integer maxTotalConnectionsDefault;

	@Value("${max.connections.per.route.default}")
	private Integer maxConnectionsPerRouteDefault;

	@Value("${max.connections.per.route.twitter}")
	private Integer maxConnectionsPerRouteTwitter;

	@Bean
	public ClientHttpRequestFactory httpRequestFactory() {
		return new HttpComponentsClientHttpRequestFactory(httpClient());
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(httpRequestFactory());
	}

	@Bean
	public HttpClient httpClient() {

		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		CloseableHttpClient httpClient = HttpClients.custom()
				.setConnectionManager(connectionManager).build();

		connectionManager.setMaxTotal(maxTotalConnectionsDefault);
		connectionManager.setDefaultMaxPerRoute(maxConnectionsPerRouteDefault);

		connectionManager.setMaxPerRoute(new HttpRoute(new HttpHost(
				"twitter.com")), maxConnectionsPerRouteTwitter);

		return httpClient;
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
