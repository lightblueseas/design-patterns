# design-patterns

This project holds view design patterns in java that have the target to be generic and educational.

Here a some design patterns that this library holds:

- builder
- command
- eventbus (new)
- observer
- state
- strategy
- visitor

## License

The source code comes under the liberal MIT License, making design-patterns great for all types of applications.

# Build status and latest maven version

[![Java CI with Gradle](https://github.com/lightblueseas/design-patterns/actions/workflows/gradle.yml/badge.svg)](https://github.com/lightblueseas/design-patterns/actions/workflows/gradle.yml)

## Maven Central

- builder [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/builder/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/builder)
- command [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/command/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/command)
- decorator [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/decorator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/decorator)
- eventbus [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/eventbus/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/eventbus)
- observer [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/observer/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/observer)
- state [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state)
- strategy [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/strategy/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/strategy)
- visitor [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/visitor/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/visitor)

## gradle dependency

You can first define the version and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of all design-pattern:

```
define version in file gradle.properties

designPatternsVersion=5.2
```

or in build.gradle ext area

```
ext {
			...
    designPatternsVersion = "5.2"
			...
}
```

then add the dependency to the dependencies area

```

dependencies {
			...
    implementation("io.github.astrapi69:builder:$designPatternsVersion")
    implementation("io.github.astrapi69:command:$designPatternsVersion")
    implementation("io.github.astrapi69:decorator:$designPatternsVersion")
    implementation("io.github.astrapi69:eventbus:$designPatternsVersion")
    implementation("io.github.astrapi69:observer:$designPatternsVersion")
    implementation("io.github.astrapi69:state:$designPatternsVersion")
    implementation("io.github.astrapi69:strategy:$designPatternsVersion")
    implementation("io.github.astrapi69:visitor:$designPatternsVersion")
			...
}
```

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~design-patterns~~~) for latest snapshots and releases.

Add the following maven dependencies to your project `pom.xml` if you want to import the core functionality:

You can first define the version properties:

	<properties>
			...
		<!-- DESIGN-PATTERNS version -->
		<design-patterns.version>5.2</design-patterns.version>
		<builder.version>${design-patterns.version}</builder.version>
		<command.version>${design-patterns.version}</command.version>
		<decorator.version>${design-patterns.version}</decorator.version>
		<eventbus.version>${design-patterns.version}</eventbus.version>
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
				<groupId>io.github.astrapi69</groupId>
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
				<groupId>io.github.astrapi69</groupId>
				<artifactId>command</artifactId>
				<version>${command.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of decorator:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>io.github.astrapi69</groupId>
				<artifactId>decorator</artifactId>
				<version>${decorator.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of eventbus:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>io.github.astrapi69</groupId>
				<artifactId>eventbus</artifactId>
				<version>${eventbus.version}</version>
			</dependency>
			...
		</dependencies>

Add the following maven dependency to your project `pom.xml` if you want to import the functionality of observer:

Than you can add the dependency to your dependencies:

		<dependencies>
			...
			<dependency>
				<groupId>io.github.astrapi69</groupId>
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
				<groupId>io.github.astrapi69</groupId>
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
				<groupId>io.github.astrapi69</groupId>
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
				<groupId>io.github.astrapi69</groupId>
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

This project is kept as an open source product and relies on contributions to remain being developed. If you like this
library, please consider a donation

over paypal:
<br>
<br>
<a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386" target="_blank">
    <img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" 
         alt="PayPal this" 
         title="PayPal – The safer, easier way to pay online!" 
         style="border: none" />
</a>
<br>
<br>
or over bitcoin(BTC) with this address:

bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/bc1ql2y99q7e8psndhcc3gferk03esw3qqf677rhjy.png"
alt="Donation Bitcoin Wallet" width="250"/>

or over FIO with this address:

FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/FIO7tFMUVAA9cHiPPqKMfMXiSxHrbpiFyRYqTketNuM67aULuwjop.png"
alt="Donation FIO Wallet" width="250"/>

or over Ethereum(ETH) with:

0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xc057D159D3C8f3311E73568b334FF6fE82EB2b7D.png"
alt="Donation Ethereum Wallet" width="250"/>

or over Ethereum Classic(ETC) with:

0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/0xF708cA86D86C246B69c3F4BAe431eBbe0c2bfddD.png"
alt="Donation Ethereum Classic Wallet" width="250"/>

or over Dogecoin(DOGE) with:

D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/D5yi4Um8cpakd6yPRm2hGWuQ5nrVzhSSW1.png"
alt="Donation Dogecoin Wallet" width="250"/>

or over Monero(XMR) with:

49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw

<img
src="https://github.com/astrapi69/jgeohash/blob/master/src/main/resources/img/49bqeRQ7Bf49oJFVC72pqpe5hFbb62pfXDYPdLsadGGF81KZW2ZfrPZ8PbAVu5X2v1TYAspeczMya3cYQysNS4usRRPQHVw.png"
alt="Donation Monero Wallet" width="250"/>

or over flattr:

<a href="https://flattr.com/submit/auto?fid=r7vp62&url=https%3A%2F%2Fgithub.com%2Flightblueseas%2Fdesign-patterns" target="_blank">
    <img src="//button.flattr.com/flattr-badge-large.png" alt="Flattr this" title="Flattr this" style="border: none">
</a>


# Similar projects

Here is a list of some other awesome projects for design patterns:


 * [iluwatar/java-design-patterns](https://github.com/iluwatar/java-design-patterns) Design patterns implemented in Java 
 * [OmarElGabry/DesignPatterns](https://github.com/OmarElGabry/DesignPatterns) Examples of Design Patterns in Java 
