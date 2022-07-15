package io.github.astrapi69.design.pattern.strategy;

import java.io.File;

import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.throwable.RuntimeExceptionDecorator;
import io.github.astrapi69.xml.api.ObjectToXmlFile;

public class ObjectToXmlFileConverterStrategy implements Strategy<String, Object>
{
	ObjectToXmlFile objectToXml;
	File file;

	public ObjectToXmlFileConverterStrategy(ObjectToXmlFile objectToXml, File file)
	{
		this.objectToXml = objectToXml;
		this.file = file;
	}

	@Override
	public String execute(Object model)
	{
		objectToXml.toXml(model, this.file);
		return RuntimeExceptionDecorator.decorate(()-> ReadFileExtensions.readFromFile(this.file));
	}
}
