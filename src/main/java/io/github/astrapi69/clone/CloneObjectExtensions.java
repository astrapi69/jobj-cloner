/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.clone;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.rits.cloning.Cloner;

/**
 * The class {@link CloneObjectExtensions} provide methods for clone an object
 */
public final class CloneObjectExtensions
{
	private final static Cloner cloner = new Cloner();

	private CloneObjectExtensions()
	{
	}

	/**
	 * Try to clone the given generic object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object to clone
	 * @return The cloned object or null if the clone process failed.
	 * @throws NoSuchMethodException
	 *             Thrown if a matching method is not found or if the name is "&lt;init&gt;"or
	 *             "&lt;clinit&gt;".
	 * @throws SecurityException
	 *             Thrown if the security manager indicates a security violation.
	 * @throws IllegalAccessException
	 *             Thrown if this {@code Method} object is enforcing Java language access control
	 *             and the underlying method is inaccessible.
	 * @throws InvocationTargetException
	 *             Thrown if the property accessor method throws an exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T clone(final T object)
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		return (T)cloneObject(object);
	}

	/**
	 * Try to clone the given object that implements {@link Cloneable}.
	 *
	 * @param object
	 *            The object to clone.
	 * @return The cloned object or null if the clone process failed.
	 * @throws NoSuchMethodException
	 *             Thrown if a matching method is not found or if the name is "&lt;init&gt;"or
	 *             "&lt;clinit&gt;".
	 * @throws IllegalAccessException
	 *             Thrown if this {@code Method} object is enforcing Java language access control
	 *             and the underlying method is inaccessible.
	 * @throws InvocationTargetException
	 *             Thrown if the property accessor method throws an exception
	 */
	public static Object cloneCloneable(final Object object)
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		Object clone;
		if (object.getClass().isArray())
		{
			final Class<?> componentType = object.getClass().getComponentType();
			if (componentType.isPrimitive())
			{
				int length = Array.getLength(object);
				clone = Array.newInstance(componentType, length);
				while (length-- > 0)
				{
					Array.set(clone, length, Array.get(object, length));
				}
			}
			else
			{
				clone = ((Object[])object).clone();
			}
			if (clone != null)
			{
				return clone;
			}
		}

		final Class<?> clazz = object.getClass();
		final Method cloneMethod = clazz.getDeclaredMethod("clone");
		cloneMethod.setAccessible(true);
		return cloneMethod.invoke(object, (Object[])null);
	}

	/**
	 * Try to clone the given object.
	 *
	 * @param object
	 *            The object to clone.
	 * @return The cloned object or null if the clone process failed.
	 * @throws NoSuchMethodException
	 *             Thrown if a matching method is not found or if the name is "&lt;init&gt;"or
	 *             "&lt;clinit&gt;".
	 * @throws SecurityException
	 *             Thrown if the security manager indicates a security violation.
	 * @throws IllegalAccessException
	 *             Thrown if this {@code Method} object is enforcing Java language access control
	 *             and the underlying method is inaccessible.
	 * @throws InvocationTargetException
	 *             Thrown if the property accessor method throws an exception
	 */
	public static Object cloneObject(final Object object)
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		if (object == null)
		{
			return object;
		}
		Object clone = null;

		// Try to clone the object if it is 'Cloneable'
		if (object instanceof Cloneable)
		{
			clone = cloneCloneable(object);
		}

		// Try to clone the object with external cloner
		if (clone == null)
		{
			clone = CloneQuietlyExtensions.withCloner(object);
		}

		return clone;
	}

}
