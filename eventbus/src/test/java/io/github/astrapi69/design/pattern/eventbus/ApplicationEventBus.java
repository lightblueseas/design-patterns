package io.github.astrapi69.design.pattern.eventbus;


import com.google.common.eventbus.EventBus;

import io.github.astrapi69.design.pattern.observer.event.EventObject;
import io.github.astrapi69.design.pattern.observer.event.EventSource;
import lombok.Getter;

public class ApplicationEventBus
{

	@Getter
	private final EventBus applicationEventBus = new EventBus();
	/** The instance. */
	private static final ApplicationEventBus instance = new ApplicationEventBus();

	public static EventSource<?> get(final String key)
	{
		return GenericEventBus.get(key);
	}

	public static EventSource<EventObject<NavigationEventState>> getImportNavigationState()
	{
		return GenericEventBus.getEventSource(NavigationEventState.class);
	}

	public static ApplicationEventBus getInstance()
	{
		return instance;
	}

	private ApplicationEventBus()
	{
	}

}
