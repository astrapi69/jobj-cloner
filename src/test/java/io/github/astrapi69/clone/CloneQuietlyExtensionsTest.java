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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.collection.array.ArrayFactory;
import io.github.astrapi69.date.CreateDateExtensions;
import io.github.astrapi69.test.object.A;
import io.github.astrapi69.test.object.Employee;
import io.github.astrapi69.test.object.Member;
import io.github.astrapi69.test.object.NotSerializable;
import io.github.astrapi69.test.object.Person;
import io.github.astrapi69.test.object.enumtype.Gender;

/**
 * The unit test class for the class {@link CloneQuietlyExtensions}
 */
public class CloneQuietlyExtensionsTest
{

	/**
	 * Test method for {@link CloneQuietlyExtensions#clone(Object)}
	 */
	@Test
	public void testClone()
	{
		Object expected;
		Object actual;

		expected = CreateDateExtensions.newDate(2009, 3, 26, 10, 37, 4);
		actual = CloneQuietlyExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = "Hey there...";
		actual = CloneQuietlyExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = A.builder().a("a").build();
		actual = CloneQuietlyExtensions.clone(expected);
		assertEquals(expected, actual);

		expected = null;
		actual = CloneQuietlyExtensions.clone(null);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#clone(Object)} with an array
	 */
	@Test
	@Disabled("upgrade to jdk11")
	public void testCloneArray()
	{
		String[] expected;
		String[] actual;

		expected = ArrayFactory.newArray("foo", "bar");
		actual = CloneQuietlyExtensions.clone(expected);
		for (int i = 0; i < actual.length; i++)
		{
			assertEquals("Cloned object should be equal with the source object.", expected[i],
				actual[i]);
		}
	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#withCloner(Object)}
	 */
	@Test
	@Disabled("upgrade to jdk11")
	public void testCloneBeanWithComposition()
	{
		Employee actual;
		Employee expected;

		actual = Employee.builder().person(Person.builder().name("Nikky").nickname("Six")
			.gender(Gender.MALE).about("").married(false).build()).build();
		expected = CloneQuietlyExtensions.withCloner(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#clone(Object)} with an array with primitive
	 * values
	 */
	@Test
	public void testCloneNotSerializable()
	{
		NotSerializable actual;
		NotSerializable expected;

		expected = NotSerializable.builder().name("foo").build();
		actual = CloneQuietlyExtensions.clone(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#cloneObject(Object)}
	 */
	@Test
	public void testCloneObject()
	{

		Object expected;
		Object actual;

		expected = CreateDateExtensions.newDate(2009, 3, 26, 10, 37, 4);
		actual = CloneQuietlyExtensions.cloneObject(expected);
		assertEquals(expected, actual);


		expected = "Hy there...";
		actual = CloneQuietlyExtensions.cloneObject(expected);
		assertEquals(expected, actual);

		expected = A.builder().a("a").build();
		actual = CloneQuietlyExtensions.cloneObject(expected);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#clone(Object)} with an array with primitive
	 * values.
	 */
	@Test
	public void testClonePrimitiveArray()
	{
		int[] actual;
		int[] expected;

		expected = new int[2];
		expected[0] = 1;
		expected[1] = 2;
		actual = CloneQuietlyExtensions.clone(expected);
		for (int i = 0; i < actual.length; i++)
		{
			assertEquals(expected[i], actual[i]);
		}
	}

	/**
	 * Test method for {@link CloneQuietlyExtensions#withCloner(Object)}
	 */
	@Test
	@Disabled("upgrade to jdk11")
	public void testCloneWithCloner()
	{
		Person actual;
		Person expected;
		actual = Person.builder().name("Nikky").nickname("Six").gender(Gender.MALE).about("")
			.married(false).build();
		expected = CloneQuietlyExtensions.withCloner(actual);
		assertEquals(expected, actual);
		actual = Member.buildMember().name("Nikky").nickname("Six").gender(Gender.MALE).about("")
			.married(false).dateofbirth(new Date()).dateofMarriage(new Date()).build();

		expected = CloneQuietlyExtensions.withCloner(actual);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link CloneQuietlyExtensions} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(CloneQuietlyExtensions.class);
	}

}
