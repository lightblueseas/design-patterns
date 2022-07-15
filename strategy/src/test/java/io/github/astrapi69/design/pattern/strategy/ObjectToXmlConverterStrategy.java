package io.github.astrapi69.design.pattern.strategy;

import io.github.astrapi69.xml.api.ObjectToXml;

public class ObjectToXmlConverterStrategy implements Strategy<String, Object>
{
	ObjectToXml objectToXml;

	public ObjectToXmlConverterStrategy(ObjectToXml objectToXml)
	{
		this.objectToXml = objectToXml;
	}

	@Override
	public String execute(Object model)
	{
		return objectToXml.toXml(model);
	}
}
