package io.github.astrapi69.design.pattern.strategy;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import io.github.astrapi69.file.create.FileFactory;
import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import org.testng.annotations.Test;

import io.github.astrapi69.test.objects.Person;
import io.github.astrapi69.test.objects.enums.Gender;
import io.github.astrapi69.xml.api.ObjectToXml;

import java.io.File;

public class XmlConverterStrategyTest
{
	@Test
	public void testStrategy()
	{
		String actual;
		String expected;
		Person person;
		Strategy<String, Object> strategy;
		ObjectToXml objectToXmlConverter;
		File xmlFile;
		// new scenario with xstream ...
		person = Person.builder().gender(Gender.FEMALE).name("Anna").nickname(null).married(null)
			.about(null).build();
		objectToXmlConverter = new io.github.astrapi69.xstream.ObjectToXmlConverter();
		strategy = new ObjectToXmlConverterStrategy(objectToXmlConverter);
		actual = strategy.execute(person);
		expected = "<io.github.astrapi69.test.objects.Person>\n" + "  <gender>FEMALE</gender>\n"
			+ "  <name>Anna</name>\n" + "</io.github.astrapi69.test.objects.Person>";
		assertNotNull(actual);
		assertEquals(actual, expected);
		// new scenario with xml.jackson ...
		objectToXmlConverter = new io.github.astrapi69.xml.jackson.ObjectToXmlConverter();
		strategy = new ObjectToXmlConverterStrategy(objectToXmlConverter);
		actual = strategy.execute(person);
		expected = "<Person>\n" + "  <about/>\n" + "  <gender>FEMALE</gender>\n" + "  <married/>\n"
			+ "  <name>Anna</name>\n" + "  <nickname/>\n" + "</Person>\n";
		assertNotNull(actual);
		assertEquals(actual, expected);

		xmlFile = PathFinder.getRelativePath(PathFinder.getSrcTestResourcesDir(), "newtest.xml");
		RuntimeExceptionDecorator.decorate(()-> FileFactory.newFile(xmlFile));

	}
}
