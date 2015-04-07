# jgo

The JGo Project aims to provide a complete compiler and runtime environment for the Go programming language to/on the Java Virtual Machine. The jgoc compiler is written in Scala and the runtime in Java.

# Status of the Project
JGo is a work in progress. Many features of the Go programming language are not yet fully supported. 

Currently, these include:

- Structs; (nearing completion)
- Methods;
- Packages and multi-file compilation;
- Interfaces;
- Lambda expressions;
- Closures (sub-feature of lambda expressions);
- Concurrency;
- defer, panic, and recover; and
- Switch statements.

I have spent a lot of time laying down foundations, and am confident in my goal for a fully conformant implementation of Go on the JVM.

# Why the JVM?
My selection of the JVM as the target for my compiler does not reflect any thesis about the performance of the platform. Rather, it was motivated by these two reasons:

1.) Compatibility. A lot of excellent libraries are written for the JVM. JGo hopes to make existing Go users more productive by enabling them to use these. Furthermore, many groups have large codebases written in Java, Scala, and other JVM languages. JGo is an attempt to bring these groups into the fold and expose them to Go.

2.) There is no need for yet another Go implementation targeting native code.
