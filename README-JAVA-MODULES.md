# Java Platform Module System (JPMS aka modules)

## Module Descriptor

When we create a module, we include a descriptor file that defines several aspects of our new module:

* Name – the name of our module
* Dependencies – a list of other modules that this module depends on
* Public Packages – a list of all packages we want accessible from outside the module
* Services Offered – we can provide service implementations that can be consumed by other modules
* Services Consumed – allows the current module to be a consumer of a service
* Reflection Permissions – explicitly allows other classes to use reflection to access the private members of a package

The module naming rules are similar to how we name packages (dots are allowed, dashes are not). It's very common to do
either project-style (my.module) or Reverse-DNS (com.ashu.mymodule) style names. We'll use project-style in this guide.
We need to list all packages we want to be public because by default all packages are module private. The same is true
for reflection. By default, we cannot use reflection on classes we import from another module. Later in the article,
we'll look at examples of how to use the module descriptor file.

## Module Types

There are four types of modules in the new module system:

* System Modules – These are the modules listed when we run the list-modules command above. They include the Java SE and
  JDK modules.
* Application Modules – These modules are what we usually want to build when we decide to use Modules. They are named
  and defined in the compiled module-info.class file included in the assembled JAR.
* Automatic Modules – We can include unofficial modules by adding existing JAR files to the module path. The name of the
  module will be derived from the name of the JAR. Automatic modules will have full read access to every other module
  loaded by the path.
* Unnamed Module – When a class or JAR is loaded onto the classpath, but not the module path, it's automatically added
  to the unnamed module. It's a catch-all module to maintain backward compatibility with previously-written Java code.

## Module Declarations

* module-info.java: To set up a module, we need to put a special file at the root of our packages named
  module-info.java.This file is known as the module descriptor and contains all the data needed to build and use our new
  module. We construct the module with a declaration whose body is either empty or made up of module directives:

```java
module myModuleName {
    // all directives are optional
}
```

* Requires : my.module has both a runtime and a compile-time dependency on module.name

```java
module my.module {
    requires module.name;
}
```

* Requires Static: optional dependency. By using the requires static directive, we create a compile-time-only
  dependency:

```java
module my.module {
    requires static module.name;
}
```

* Requires Transitive : we need to make sure that any module that brings in our code will also bring in these extra
  ‘transitive' dependencies.When a developer requires my.module, they won't have to say requires module.name for our
  module to work.

```java
module my.module {
    requires transitive module.name;
}
```

* Exports : By default, a module doesn't expose any of its API to other modules. This strong encapsulation was one of
  the key motivators for creating the module system in the first place. Use the exports directive to expose all public
  members of the named package.

```java
module my.module {
    exports com.my.package.name;
}
```

* Exports … To : We can restrict which modules have access to our APIs using the exports…to directive.

```java
module my.module {
    export com.my.package.name to com.specific.package;
}
```

* Uses:  We designate the services our module consumes with the uses directive. Note that the class name we use is
  either the interface or abstract class of the service, not the implementation class.
* We should note here that there's a `difference between a requires directive and the uses directive`. We might require
  a module that provides a service we want to consume, but that service implements an interface from one of its
  transitive dependencies.Instead of forcing our module to require all transitive dependencies just in case, we use the
  uses directive to add the required interface to the module path.

```java
module my.module {
    uses class.name;
}
```

* Provides … With:  A module can also be a service provider that other modules can consume.

```java
module my.module {
    provides MyInterface with MyInterfaceImpl;
}
```

* Open : we now have to explicitly grant permission for other modules to reflect on our classes. If we want to continue
  to allow full reflection as older versions of Java did, we can simply open the entire module up:

```java
open module my.module {
}
```

* Opens: we can use the opens directive to expose specific packages.

```java
module my.module {
    opens com.my.package;
}
```

* Opens … To : We can selectively open our packages to a pre-approved list of modules, in this case, using the opens…to
  directive:

```java
module my.module {
    opens com.my.package to moduleOne,moduleTwo,etc.;
}
```

## Command Line Options:

It's valuable to know how to use the module system from the command line

* module-path – We use the –module-path option to specify the module path. This is a list of one or more directories
  that contain your modules.
* add-reads – Instead of relying on the module declaration file, we can use the command line equivalent of the requires
  directive; –add-reads.
* add-exports – Command line replacement for the exports directive.
* add-opens – Replace the open clause in the module declaration file.
* add-modules – Adds the list of modules into the default set of modules
* list-modules – Prints a list of all modules and their version strings
* patch-module – Add or override classes in a modules
* illegal-access=permit|warn|deny – Either relax strong encapsulation by showing a single global warning, shows every
  warning, or fails with errors. The default is permit.

## Reference

* [Understanding Java 9 Modules](https://www.oracle.com/in/corporate/features/understanding-java-9-modules.html)
* [Java Modules Tutorial](https://howtodoinjava.com/java9/java-9-modules-tutorial/)
* [A Guide to Java 9 Modularity](https://www.baeldung.com/java-9-modularity)
* [Project Jigsaw: Module System Quick-Start Guide](http://openjdk.java.net/projects/jigsaw/quick-start)