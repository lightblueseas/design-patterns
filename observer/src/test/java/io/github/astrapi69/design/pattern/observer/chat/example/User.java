package io.github.astrapi69.design.pattern.observer.chat.example;

import io.github.astrapi69.design.pattern.observer.chat.IUser;

public class User implements IUser<User>
{

	private static final long serialVersionUID = 1L;
	private String name;
	private Integer id;

	public User(String name, Integer id)
	{
		this.name = name;
		this.id = id;
	}

	@Override
	public User getApplicationUser()
	{
		return this;
	}

	@Override
	public void setApplicationUser(User user)
	{
	}

	@Override
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
