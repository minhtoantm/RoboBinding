/**
 * FunctionImpl.java
 * Oct 26, 2011 Copyright Cheng Wei and Robert Taylor
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
package robobinding.function;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
*
* @since 1.0
* @version $Revision: 1.0 $
* @author Cheng Wei
*/
class FunctionImpl implements Function
{
	private final Object object;
	private final Method method;
	public FunctionImpl(Object object, Method method)
	{
		this.object = object;
		this.method = method;
	}
	@Override
	public void call(Object... args)
	{
		try
		{
			method.invoke(object, args);
		} catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		} catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		} catch (InvocationTargetException e)
		{
			//TODO provide a more helpful error message that exposes the underlying cause
			throw new RuntimeException(e);
		}
	}
}