/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.clone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.date.CreateDateExtensions;
import io.github.astrapi69.test.object.A;
import io.github.astrapi69.test.object.NotSerializable;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.factory.TestObjectFactory;

/**
 * The unit test class for the class {@link CloneObjectExtensions}.
 */
public class CloneObjectExtensionsTest
{

	/**
	 * Test method for {@link CloneObjectExtensions#clone(Object)}.
	 *
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
	@Test
	public void testClone() throws NoSuchMethodException, SecurityException, IllegalAccessException,
		InvocationTargetException
	{
		Object expected;
		Object actual;

		expected = CreateDateExtensions.newDate(2009, 3, 26, 10, 37, 4);
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);


		expected = "Hey there...";
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = null;
		actual = CloneObjectExtensions.clone(null);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newA();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newAlgorithmModel();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newApplicationTestModel(actual);
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newClonableObject();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newClub();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = TestObjectFactory.newCompany();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneObjectExtensions#clone(Object)} with an array.
	 */
	@Test
	@Disabled("upgrade to jdk11")
	public void testCloneArray() throws NoSuchMethodException, SecurityException,
		IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String[] expected;
		String[] actual;

		expected = ArrayFactory.newArray("foo", "bar");
		actual = CloneObjectExtensions.clone(expected);
		for (int i = 0; i < actual.length; i++)
		{
			assertEquals("Cloned object should be equal with the source object.", expected[i],
				actual[i]);
		}
	}

	/**
	 * Test method for {@link CloneObjectExtensions#clone(Object)} with an array with primitive
	 * values
	 *
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
	@Test
	public void testCloneNotSerializable()
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		NotSerializable actual;
		NotSerializable expected;

		expected = NotSerializable.builder().name("foo").build();
		actual = CloneObjectExtensions.clone(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneObjectExtensions#cloneObject(Object)}
	 *
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
	@Test
	public void testCloneObject()
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException
	{
		Object expected;
		Object actual;

		expected = CreateDateExtensions.newDate(2009, 3, 26, 10, 37, 4);
		actual = CloneObjectExtensions.cloneObject(expected);
		assertEquals(expected, actual);

		expected = "Hy there...";
		actual = CloneObjectExtensions.cloneObject(expected);
		assertEquals(expected, actual);

		expected = A.builder().a("a").build();
		actual = CloneObjectExtensions.cloneObject(expected);
		assertEquals(expected, actual);

		expected = Person.builder().name("Foo").about("about").build();
		actual = CloneObjectExtensions.cloneObject(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneObjectExtensions#clone(Object)} with an array with primitive
	 * values.
	 */
	@Test
	public void testClonePrimitiveArray() throws NoSuchMethodException, SecurityException,
		IllegalAccessException, InvocationTargetException
	{
		int[] actual;
		int[] expected;

		expected = new int[2];
		expected[0] = 1;
		expected[1] = 2;
		actual = CloneObjectExtensions.clone(expected);
		for (int i = 0; i < actual.length; i++)
		{
			assertEquals(expected[i], actual[i]);
		}
	}

	/**
	 * Test method for {@link CloneObjectExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CloneObjectExtensions.class);
	}

}
