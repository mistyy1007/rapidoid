package org.rapidoid.reactive.var;

/*
 * #%L
 * rapidoid-reactive
 * %%
 * Copyright (C) 2014 Nikolche Mihajlovski
 * %%
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
 * #L%
 */

import org.rapidoid.reactive.Var;
import org.rapidoid.util.U;

public class ContainerVar extends AbstractVar<Boolean> {

	private static final long serialVersionUID = 6990464844550633598L;

	private final Var<Object> container;

	private final Object item;

	public ContainerVar(Var<Object> container, Object item) {
		this.container = container;
		this.item = item;
	}

	@Override
	public Boolean get() {
		return U.contains(container.get(), item);
	}

	@Override
	public void set(Boolean value) {
		if (value) {
			container.set(U.include(container.get(), item));
		} else {
			container.set(U.exclude(container.get(), item));
		}
	}

}
