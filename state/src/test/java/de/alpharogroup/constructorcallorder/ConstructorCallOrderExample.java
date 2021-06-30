package de.alpharogroup.constructorcallorder;

class Child extends Parent
{
	// Static init block
	static
	{
		System.out.println("static block - child");
	}
	Printer printer = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from child");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - child");
	}

	// Constructor
	public Child()
	{
		System.out.println("constructor - child");
	}
}

/**
 * The Class ConstructorCallOrderExample demonstrates the call hierarchy from classes.
 */
public class ConstructorCallOrderExample
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		System.out.println("START");
		new Child();
		System.out.println("END");
	}
}

class Grandparent
{
	// Static init block
	static
	{
		System.out.println("static block - grandparent");
	}
	Printer substitution = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from grandparent");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - grandparent");
	}

	// Constructor
	public Grandparent()
	{
		System.out.println("constructor - grandparent");
	}
}

class Parent extends Grandparent
{
	// Static init block
	static
	{
		System.out.println("static block - parent");
	}
	Printer substitution = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from parent");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - parent");
	}

	// Constructor
	public Parent()
	{
		System.out.println("constructor - parent");
	}
}

class Printer
{
	Printer()
	{
		print();
	}

	void print()
	{
	}
}
