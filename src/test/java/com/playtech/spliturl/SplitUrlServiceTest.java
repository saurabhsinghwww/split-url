package com.playtech.spliturl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.playtech.spliturl.model.URLModel;
import com.playtech.spliturl.service.SplitUrlService;
import com.playtech.spliturl.service.SplitUrlServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SplitUrlServiceTest {
	
	@Configuration
    static class splitUrlServiceTestContextConfiguration {

        @Bean
        public SplitUrlService accountService() {
            return new SplitUrlServiceImpl();
        }
    }

	@Autowired
	private SplitUrlService splitUrlService;

	@Test()
	public void schemeShouldReturnHttpWithRegex() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByRegex("http://google.com");
		assertEquals("http", urlModel.getScheme());
	}
	
	@Test()
	public void schemeShouldReturnHttpWithState() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByStateMachine("http://google.com");
		assertEquals("http", urlModel.getScheme());
	}
	
	@Test()
	public void hostShouldReturnGoogleWithRegex() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByRegex("http://google.com");
		assertEquals("google.com", urlModel.getHost());
	}
	
	@Test()
	public void hostShouldReturnGoogleWithState() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByStateMachine("http://google.com");
		assertEquals("google.com", urlModel.getHost());
	}
	
	@Test()
	public void portShouldReturnNullWithRegex() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByRegex("http://google.com");
		assertEquals(null, urlModel.getPort());
	}
	
	@Test()
	public void portShouldReturnNullWithState() throws Exception {
		URLModel urlModel = splitUrlService.splitUrlByStateMachine("http://google.com");
		assertEquals(null, urlModel.getPort());
	}

}
