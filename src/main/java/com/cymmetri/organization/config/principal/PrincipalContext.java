/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cymmetri.organization.config.principal;

public final class PrincipalContext {

	/**
	 * Instantiates a new principalContext. Private to prevent instantiation.
	 */
	private PrincipalContext() {
		// Throw an exception if this ever *is* called
		throw new AssertionError("Instantiating utility class.");
	}

	private static ThreadLocal<Principal> principalContext = new ThreadLocal<Principal>() {
		@Override
		protected Principal initialValue() {
			return new Principal(null, null, null);
		}
	};

	public static void setPrincipal(Principal principal) {
		principalContext.set(principal);
	}

	public static Principal getPrincipal() {
		return principalContext.get();
	}

	public static void clear() {
		principalContext.remove();
	}

}