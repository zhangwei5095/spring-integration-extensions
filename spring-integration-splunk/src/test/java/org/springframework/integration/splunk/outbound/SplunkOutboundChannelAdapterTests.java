/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.splunk.outbound;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.springframework.integration.Message;
import org.springframework.integration.splunk.support.SplunkExecutor;

/**
 * @author Jarred Li
 * @since 1.0
 *
 */
public class SplunkOutboundChannelAdapterTests {

	private SplunkOutboundChannelAdapter outboundAdapter;

	private SplunkExecutor executor;

	@Before
	public void init() {
		executor = mock(SplunkExecutor.class);
		outboundAdapter = new SplunkOutboundChannelAdapter(executor);
	}

	/**
	 * Test method for {@link org.springframework.integration.splunk.outbound.SplunkOutboundChannelAdapter#handleRequestMessage(org.springframework.integration.Message)}.
	 */
	@Test
	public void testHandleRequestMessage() {
		Message<?> message = null;
		when(executor.executeOutboundOperation(message)).thenReturn(null);

		Object ret = outboundAdapter.handleRequestMessage(message);
		Assert.assertNull(ret);
	}

	/**
	 * Test method for {@link org.springframework.integration.splunk.outbound.SplunkOutboundChannelAdapter#setProducesReply(boolean)}.
	 */
	@Test
	public void testSetProducesReply() {
		outboundAdapter.setProducesReply(false);
	}

}
