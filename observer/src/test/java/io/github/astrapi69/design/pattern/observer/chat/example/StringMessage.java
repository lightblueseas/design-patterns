package io.github.astrapi69.design.pattern.observer.chat.example;

import io.github.astrapi69.design.pattern.observer.chat.Message;

public class StringMessage implements Message<String>
{

	private static final long serialVersionUID = 1L;
	private String value;

	public StringMessage()
	{
	}

	public StringMessage(String value)
	{
		this.value = value;
	}

	@Override
	public String getValue()
	{
		return value;
	}

	@Override
	public StringMessage setValue(String value)
	{
		this.value = value;
		return this;
	}

	@Override
	public String toString()
	{
		return "StringMessage [value=" + value + "]";
	}
}
