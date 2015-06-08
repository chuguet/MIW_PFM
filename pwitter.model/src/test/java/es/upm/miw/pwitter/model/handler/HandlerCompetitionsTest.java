package es.upm.miw.pwitter.model.handler;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class HandlerCompetitionsTest extends AbstractTest {

	@Inject
	private IHandlerCompetitions handlerCompetitions;

	@Test
	public void testCreateCompetitions() {
		assertEquals(new Integer(3), handlerCompetitions.getNumCompetitions());
	}
}
