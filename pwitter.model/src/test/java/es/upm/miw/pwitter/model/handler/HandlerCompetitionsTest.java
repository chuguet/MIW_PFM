package es.upm.miw.pwitter.model.handler;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

public class HandlerCompetitionsTest extends AbstractTest {

	@Inject
	private IHandlerCompetitions handlerCompetitions;

	@Test
	public void testCreateCompetitions() {
		assertEquals(new Integer(3), handlerCompetitions.getNumCompetitions());
	}
}
