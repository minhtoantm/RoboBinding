/**
 * Copyright 2011 Cheng Wei, Robert Taylor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.robobinding.viewattribute.view;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.robobinding.viewattribute.AbstractAttributeTest;
import org.robobinding.viewattribute.MockPresentationModelForProperty;
import org.robobinding.viewattribute.RandomValues;

import android.view.View;

/**
 *
 * @since 1.0
 * @version $Revision: 1.0 $
 * @author Robert Taylor
 */
public class VisibilityAttributeTest extends AbstractAttributeTest<View, VisibilityAttribute>
{
	@Test
	public void givenValueModelIsIntegerType_WhenUpdatingPresentationModel_ThenViewShouldReflectViewModel()
	{
		int visibility = RandomValues.anyVisibility();
		MockPresentationModelForProperty<Integer> presentationModel = initializeForOneWayBinding(RandomValues.primitiveOrBoxedIntegerClass());
		
		presentationModel.updatePropertyValue(visibility);
		
		assertThat(view.getVisibility(), is(visibility));
	}
	
	@Test
	public void whenBindingWithABooleanProperty_ThenInitializeBooleanVisibilityAttribute()
	{
		boolean visible = RandomValues.trueOrFalse();
		MockPresentationModelForProperty<Boolean> presentationModel = initializeForOneWayBinding(RandomValues.primitiveOrBoxedBooleanClass());
		
		presentationModel.updatePropertyValue(visible);
		
		assertThat(view.getVisibility(), is(visible ? View.VISIBLE : View.GONE));
	}
	
}
