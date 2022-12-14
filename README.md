## What is Samza?  [![Build Status](https://travis-ci.org/apache/samza.svg?branch=master)](https://travis-ci.org/apache/samza)

[Apache Samza](http://samza.apache.org/) is a distributed stream processing framework. It uses [Apache Kafka](http://kafka.apache.org) for messaging, and [Apache Hadoop YARN](http://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/YARN.html) to provide fault tolerance, processor isolation, security, and resource management.

Samza's key features include:

* **Simple API:** Unlike most low-level messaging system APIs, Samza provides a very simple callback-based "process message" API comparable to MapReduce.
* **Managed state:** Samza manages snapshotting and restoration of a stream processor's state. When the processor is restarted, Samza restores its state to a consistent snapshot. Samza is built to handle large amounts of state (many gigabytes per partition).
* **Fault tolerance:** Whenever a machine in the cluster fails, Samza works with YARN to transparently migrate your tasks to another machine.
* **Durability:** Samza uses Kafka to guarantee that messages are processed in the order they were written to a partition, and that no messages are ever lost.
* **Scalability:** Samza is partitioned and distributed at every level. Kafka provides ordered, partitioned, replayable, fault-tolerant streams. YARN provides a distributed environment for Samza containers to run in.
* **Pluggable:** Though Samza works out of the box with Kafka and YARN, Samza provides a pluggable API that lets you run Samza with other messaging systems and execution environments.
* **Processor isolation:** Samza works with Apache YARN, which supports Hadoop's security model, and resource isolation through Linux CGroups.

Check out [Hello Samza](https://samza.apache.org/startup/hello-samza/latest/) to try Samza. Read the [Background](https://samza.apache.org/learn/documentation/latest/introduction/background.html) page to learn more about Samza.

### Building Samza

To build Samza from a git checkout, run:

    ./gradlew clean build

To build Samza from a source release, it is first necessary to download the gradle wrapper script above. This bootstrapping process requires Gradle to be installed on the source machine.  Gradle is available through most package managers or directly from [its website](http://www.gradle.org/).  To bootstrap the wrapper, run:

    gradle -b bootstrap.gradle

After the bootstrap script has completed, the regular gradlew instructions below are available.

### Java Version Support

This project is built with Java 8 and can run in a Java 8 runtime enviornment. Additionally, it also supports running in a Java 11 runtime environment. 
If you intend to use Samza in a Java 11 runtime environment, it means you will also need to use YARN 3.3.4+ and in which case, you should also use 
the `samza-yarn3` module (built with YARN 3.3.4) instead of the `samza-yarn` (built with YARN 2.10.1). There is also a `samza-shell-yarn3` that
depends on the `samza-yarn3` module, so use that shell module if you intend on using Yarn 3.

#### Scala and YARN

Samza builds with [Scala](http://www.scala-lang.org/) 2.11 or 2.12 and [YARN](http://hadoop.apache.org/docs/current/hadoop-yarn/hadoop-yarn-site/YARN.html) 2.10.1, by default. 
Use the -PscalaSuffix switches to change Scala versions. Samza supports building Scala with 2.11 and 2.12 and provides a YARN 2 module (`samze-yarn`) and a YARN 3 module (`samza-yarn3`).

NOTE: Some modules currently do **not** officially support Java 11 Runtime and are still using the YARN 2.10.1 dependency:
* `samza-yarn`
* `samza-shell`
* `samza-test`
* `samza-hdfs`


    ./gradlew -PscalaSuffix=2.12 clean build 

Also, you can make use of `bin/check-all.sh` in order to test multiple variants of Java JDKs, Scala, and Yarn.

### Testing Samza

To run all tests:

    ./gradlew clean test

To run a single test:

    ./gradlew clean :samza-test:test -Dtest.single=TestStatefulTask

To run key-value performance tests:

    ./gradlew samza-shell:kvPerformanceTest -PconfigPath=file://$PWD/samza-test/src/main/config/perf/kv-perf.properties

To run yarn integration tests:

    ./bin/integration-tests.sh <dir> yarn-integration-tests

To run standalone integration tests:

    ./bin/integration-tests.sh <dir> standalone-integration-tests

### Running checkstyle on the java code ###

    ./gradlew checkstyleMain checkstyleTest

### Job Management

To run a job (defined in a properties file):

    ./gradlew samza-shell:runJob -PconfigPath=/path/to/job/config.properties

To inspect a job's latest checkpoint:

    ./gradlew samza-shell:checkpointTool -PconfigPath=/path/to/job/config.properties

To modify a job's checkpoint (assumes that the job is not currently running), give it a file with the new offset for each partition, in the format `systems.<system>.streams.<topic>.partitions.<partition>=<offset>`:

    ./gradlew samza-shell:checkpointTool -PconfigPath=/path/to/job/config.properties \
        -PnewOffsets=file:///path/to/new/offsets.properties

### Developers

To get Eclipse projects, run:

    ./gradlew eclipse

For IntelliJ, run:

    ./gradlew idea

### Contribution

To start contributing on Samza please read [Rules](http://samza.apache.org/contribute/rules.html) and [Contributor Corner](https://cwiki.apache.org/confluence/display/SAMZA/Contributor%27s+Corner). Notice that **Samza git repository does not support git pull request**.

### Apache Software Foundation

Apache Samza is a top level project of the [Apache Software Foundation](http://www.apache.org/).

![Apache Software Foundation Logo](http://www.apache.org/images/feather.gif)
