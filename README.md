# design-patterns

This project holds view design patterns in java that have the target to be generic and educational.

Here a some design patterns that this library holds:

- builder
- command
- observer
- state
- strategy
- visitor

## License

The source code comes under the liberal MIT License, making design-patterns great for all types of applications.

# Build status and latest maven version
[![Build Status](https://travis-ci.org/lightblueseas/design-patterns.svg?branch=master)](https://travis-ci.org/lightblueseas/design-patterns)

## Maven Central

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/design-patterns/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.alpharogroup/design-patterns)

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~de.alpharogroup~design-patterns~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- DESIGN-PATTERNS version -->
		<design-patterns.version>4.14</design-patterns.version>
		<builder.version>${design-patterns.version}</builder.version>
		<command.version>${design-patterns.version}</command.version>
		<observer.version>${design-patterns.version}</observer.version>
		<state.version>${design-patterns.version}</state.version>
		<strategy.version>${design-patterns.version}</strategy.version>
		<visitor.version>${design-patterns.version}</visitor.version>
			...
	</properties>


Add the following maven dependency to your project `pom.xml` if you want to import the functionality of builder:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>builder</artifactId>
				<version>${builder.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of command:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>command</artifactId>
				<version>${command.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of observer:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>observer</artifactId>
				<version>${observer.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of state:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>state</artifactId>
				<version>${state.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of strategy:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>strategy</artifactId>
				<version>${strategy.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of visitor:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>de.alpharogroup</groupId>
				<artifactId>visitor</artifactId>
				<version>${visitor.version}</version>
			</dependency>
			...
		</dependencies>

## Want to Help and improve it? ###

The source code for design-patterns are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [lightblueseas/design-patterns/fork](https://github.com/lightblueseas/design-patterns/fork)

To share your changes, [submit a pull request](https://github.com/lightblueseas/design-patterns/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developer

Do not hesitate to contact the design-patterns developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/lightblueseas/design-patterns/issues).

## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through paypal: <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=B37J9DZF6G9ZC" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" border="0" />
</a>

or over bitcoin or bitcoin-cash with:

1Jzso5h7U82QCNmgxxSCya1yUK7UVcSXsW

or over ether with:

0xaB6EaE10F352268B0CA672Dd6e999C86344D49D8

or over flattr: <a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fdesign-patterns" target="_blank"><img src="//button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0"></a>

# Similar projects

Here is a list of some other awesome projects for design patterns:


 * [iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns) Design patterns implemented in Java 
 * [OmarElGabry/DesignPatterns](https://github.com/OmarElGabry/DesignPatterns) Examples of Design Patterns in Java 
