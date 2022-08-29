/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
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
package io.github.astrapi69.design.pattern.builder.example.extendable;

/**
 * The class {@link Car}.
 */
public final class Car
{

	/** The construction year. */
	private final int constructionYear;
	/** The model. */
	private final String model;

	// all fields must be final so they are immutable objects
	/** The type. */
	private final String type;

	/**
	 * Instantiates a new car. Note: private constructor. Only the Builder can call it.
	 *
	 * @param builder
	 *            the builder
	 */
	private Car(final AbstractCarBuilder<?, ?> builder)
	{
		this.model = builder.model;
		this.type = builder.type;
		this.constructionYear = builder.constructionYear;
	}

	/**
	 * Builder.
	 *
	 * @return the builder
	 */
	public static CarBuilder builder()
	{
		return new CarBuilder();
	}

	/**
	 * Gets the construction year.
	 *
	 * @return the construction year
	 */
	public int getConstructionYear()
	{
		return constructionYear;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel()
	{
		return model;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString()
	{
		return "Car{" + "type='" + type + '\'' + ", model='" + model + '\'' + ", constructionYear="
			+ constructionYear + '}';
	}

	/**
	 * The class {@link AbstractCarBuilder}.
	 */
	public static abstract class AbstractCarBuilder<C extends Car, B extends AbstractCarBuilder<C, B>>
	{

		// optional fields
		/** The type. */
		private String type;
		/** The construction year. */
		private int constructionYear;

		// mandatory fields
		/** The model. */
		private String model;

		/**
		 * Construction year.
		 *
		 * @param constructionYear
		 *            the construction year
		 * @return the builder
		 */
		public B constructionYear(final int constructionYear)
		{
			this.constructionYear = constructionYear;
			return self();
		}

		/**
		 * Model.
		 *
		 * @param model
		 *            the model
		 * @return the builder
		 */
		public B model(final String model)
		{
			this.model = model;
			return self();
		}

		/**
		 * type.
		 *
		 * @param type
		 *            the type
		 * @return the builder
		 */
		public B type(final String type)
		{
			this.type = type;
			return self();
		}

		/**
		 * Builds the.
		 *
		 * @return the car
		 */
		protected abstract B self();

		public abstract C build();


		public String toString()
		{
			return "Car.AbstractCarBuilder(constructionYear=" + this.constructionYear + ", model="
				+ this.model + ")";
		}
	}

	private static final class CarBuilder extends AbstractCarBuilder<Car, CarBuilder>
	{
		private CarBuilder()
		{
		}

		@Override
		protected CarBuilder self()
		{
			return this;
		}

		@Override
		public Car build()
		{
			return new Car(this);
		}
	}

}
