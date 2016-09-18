# jvm
jvm的内存结构中，关于方法区和永生代的概念很容易混淆。
方法区（method area）只是JVM规范中定义的一个概念，用于存储类信息、常量池、静态变量、JIT编译后的代码等数据，具体放在哪里，不同的实现可以放在不同的地方。而永久代是Hotspot虚拟机特有的概念，是方法区的一种实现，别的JVM都没有这个东西。一般说堆的持久代就是说方法区，因为一旦JVM把方法区（类信息，常量池，静态字段，方法）加载进内存以后，这些内存一般是不会被回收的了。不同的虚拟机实现的方法不同，所网上的答案有可能有所不同，我只知道在Hotspot中，方法区只是在逻辑上独立，物理上还是包含在堆区中。但是其它的虚拟机可能就不是这种情况。

在Java 6中，方法区中包含的数据，除了JIT编译生成的代码存放在native memory的CodeCache区域，其他都存放在永久代；
在Java 7中，Symbol的存储从PermGen移动到了native memory，并且把静态变量从instanceKlass末尾（位于PermGen内）移动到了java.lang.Class对象的末尾（位于普通Java heap内）；
在Java 8中，永久代被彻底移除，取而代之的是另一块与堆不相连的本地内存——元空间（Metaspace）,‑XX:MaxPermSize 参数失去了意义，取而代之的是-XX:MaxMetaspaceSize。

一：JVM中内存

JVM中内存通常划分为两个部分，分别为堆内存与栈内存，栈内存主要用执行线程方法存放本地临时变量与线程中方法执行时候需要的引用对象地址。JVM所有的对象信息都存放在堆内存中，相比栈内存，堆内存可以所大的多，所以JVM一直通过对堆内存划分不同的功能区块实现对堆内存中对象管理。

堆内存不够最常见的错误就是OOM(OutOfMemoryError)
栈内存溢出最常见的错误就是StackOverflowError，程序有递归调用时候最容易发生

二：堆内存划分

在JDK7以及其前期的JDK版本中，堆内存通常被分为三块区域Nursery内存(young generation)、长时内存(old generation)、永久内存(Permanent Generation for VM Matedata) 其中最上一层是Nursery内存，一个对象被创建以后首先被放到Nursery中的Eden内存中，如果存活期超两个Survivor之后就会被转移到长时内存中(Old Generation)中永久内存中存放着对象的方法、变量等元数据信息。通过如果永久内存不够，我们就会得到如下错误：

Java.lang.OutOfMemoryError: PermGen

而在JDK8中情况发生了明显的变化，就是一般情况下你都不会得到这个错误，原因在于JDK8中把存放元数据中的永久内存从堆内存中移到了本地内存(native memory) 中，JDK8的JVM堆内存结构中，永久内存就不再占用堆内存，它可以通过自动增长来避免JDK7以及前期版本中常见的永久内存错误(java.lang.OutOfMemoryError: PermGen)， 也许这个就是你的JDK升级到JDK8的理由之一吧。当然JDK8也提供了一个新的设置Matespace内存大小的参数，通过这个参数可以设置Matespace内存大小，这样我们可以根据自己项目的实际情况，避免过度浪费本地内存，达到有效利用。
-XX:MaxMetaspaceSize=128m 设置最大的元内存空间128兆
注意：如果不设置JVM将会根据一定的策略自动增加本地元内存空间。
如果你设置的元内存空间过小，你的应用程序可能得到以下错误：
java.lang.OutOfMemoryError: Metadata space
