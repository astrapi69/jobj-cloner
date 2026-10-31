# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/jobj-cloner/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/jobj-cloner/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/jobj-cloner/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/jobj-cloner)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/jobj-cloner.svg?style=flat)](https://github.com/astrapi69/jobj-cloner/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jobj-cloner/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jobj-cloner)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/jobj-cloner.svg)](http://www.javadoc.io/doc/io.github.astrapi69/jobj-cloner)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/jobj-cloner?branch=develop)](https://hitsofcode.com/github/astrapi69/jobj-cloner/view?branch=develop)
[![Lines Of Code](https://tokei.rs/b1/github/astrapi69/jobj-cloner)](https://github.com/astrapi69/jobj-cloner)

</div>

Utility library for simply clone java objects.

> Please support this project by simply putting a
> Github <a class="github-button" href="https://github.com/astrapi69/jobj-cloner" data-icon="octicon-star" aria-label="Star astrapi69/jobj-cloner on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making jobj-cloner great for all types of applications.

## gradle dependency

Replace the variable ${latestVersion} with the current latest
version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jobj-cloner/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/jobj-cloner)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of jobj-cloner:

define version in file gradle.properties

```
jobjClonerVersion=${latestVersion}
```

or in build.gradle ext area

```
    jobjClonerVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:jobj-cloner:$jobjClonerVersion")
```

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~jobj-cloner~~~)
for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of jobj-cloner:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- jobj-cloner version -->
        <jobj-cloner.version>${latestVersion}</jobj-cloner.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- jobj-cloner DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>jobj-cloner</artifactId>
                <version>${jobj-cloner.version}</version>
            </dependency>
            ...
        </dependencies>

## Support this project

If jobj-cloner is useful to you, a star on [GitHub](https://github.com/astrapi69/jobj-cloner) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of jobj-cloner are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for jobj-cloner are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/jobj-cloner/fork](https://github.com/astrapi69/jobj-cloner/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/jobj-cloner/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the jobj-cloner developers with your questions, concerns, comments, bug reports, or feature
requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/jobj-cloner/issues).

## Similar projects

## Credits
