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

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import com.rits.cloning.Cloner;

/**
 * The class {@link CloneQuietlyExtensions} provide methods for clone an object quietly
 */
public final class CloneQuietlyExtensions
{
	private final static Cloner cloner = new Cloner();

	private CloneQuietlyExtensions()
	{
	}

	/**
	 * Try to clone the given generic object.
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object to clone
	 * @return The cloned object or null if the clone process failed
	 */
	@SuppressWarnings("unchecked")
	public static <T> T clone(final T object)
	{
		try
		{
			return CloneObjectExtensions.clone(object);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Try to clone the given object that implements {@link Cloneable}
	 *
	 * @param object
	 *            The object to clone.
	 * @return The cloned object or null if the clone process failed
	 */
	public static Object cloneCloneable(final Object object)
	{
		try
		{
			return CloneObjectExtensions.cloneCloneable(object);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
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
	{
		try
		{
			return CloneObjectExtensions.cloneObject(object);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * Try to clone the given object with the external cloner
	 *
	 * @param <T>
	 *            the generic type
	 * @param object
	 *            the object
	 * @return the t
	 */
	public static <T> T withCloner(final T object)
	{
		Objects.requireNonNull(object);
		return cloner.deepClone(object);
	}

}
