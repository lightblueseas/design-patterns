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
package de.alpharogroup.design.pattern.builder;

/**
 * The class {@link Car}.
 */
public final class Car
{
	
	/**
	 * The class {@link Builder}.
	 */
	public static class Builder
	{

		// optional fields
		/** The construction year. */
		private int constructionYear;
		
		/** The model. */
		private String model;

		// mandatory fields
		/** The type. */
		private final String type;

		/**
		 * Instantiates a new builder.
		 *
		 * @param type the type
		 */
		public Builder(final String type)
		{
			this.type = type;
		}

		/**
		 * Builds the.
		 *
		 * @return the car
		 */
		public Car build()
		{
			return new Car(this);
		}

		/**
		 * Construction year.
		 *
		 * @param constructionYear the construction year
		 * @return the builder
		 */
		public Builder constructionYear(final int constructionYear)
		{
			this.constructionYear = constructionYear;
			return this;
		}

		/**
		 * Model.
		 *
		 * @param model the model
		 * @return the builder
		 */
		public Builder model(final String model)
		{
			this.model = model;
			return this;
		}
	}

	/**
	 * Builder.
	 *
	 * @param type the type
	 * @return the builder
	 */
	public static Builder builder(final String type) {
		return new Builder(type);
	}
	// all fields must be final so they are immutable objects
	/** The construction year. */
	private final int constructionYear;
	
	/** The model. */
	private final String model;

	/** The type. */
	private final String type;

	/**
	 * Instantiates a new car. 
	 * Note: private constructor. Only the Builder can call it.
	 *
	 * @param builder the builder
	 */
	private Car(final Builder builder)
	{
		this.model = builder.model;
		this.type = builder.type;
		this.constructionYear = builder.constructionYear;
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

}