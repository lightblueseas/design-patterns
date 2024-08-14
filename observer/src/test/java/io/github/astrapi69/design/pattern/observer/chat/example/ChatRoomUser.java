package io.github.astrapi69.design.pattern.observer.chat.example;

import java.io.Serializable;

import io.github.astrapi69.design.pattern.observer.api.ActionCommand;
import io.github.astrapi69.design.pattern.observer.api.Observer;
import io.github.astrapi69.design.pattern.observer.chat.IUser;
import io.github.astrapi69.design.pattern.observer.chat.Message;

public abstract class ChatRoomUser<M extends Message<?>>
	implements
		Observer<M>,
		ActionCommand,
		Serializable
{

	private static final long serialVersionUID = 1L;
	private final IUser<?> user;
	protected ChatRoom<M> subject;
	private M observable;

	public ChatRoomUser(ChatRoom<M> room, IUser<?> user)
	{
		this.subject = room;
		this.observable = this.subject.getObservable();
		this.user = user;
		this.subject.add(this);
	}

	@Override
	public synchronized void update(M observable)
	{
		this.observable = observable;
		execute();
	}

	public synchronized M getObservable()
	{
		return observable;
	}

	public IUser<?> getUser()
	{
		return user;
	}

	public void send(M message)
	{
		subject.setObservable(message);
	}
}
