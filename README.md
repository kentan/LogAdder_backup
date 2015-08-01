#LogAdder
LogAdder is tools for analyzing Java code by adding log at the top of methods. </br>
Large and complex Java codes that uses asynchronous and multithreading technique make programmers to understand the flow.</br>
The LogAdder helps you to understand how the code is run by seeing the outputed log.</br>

#Getting Started

1. Compile and execute the StdOutAdder.java.</br>
   The class adds "I'm at &lt;METHOD_NAME&gt;(&lt;CLASS_NAME&gt;:&lt;LINE&gt;)" at the top of every method of the file under com.github.kentan.logadder.sample.data.

2. Compile and execute the Sample1.java.</br>

You will get the following output.

>I'm at com.github.kentan.logadder.sample.data.Sample1.main(Sample1.java:6)</br>
>I'm at com.github.kentan.logadder.sample.data.Sample1.sample(Sample1.java:14)</br>
>I'm at com.github.kentan.logadder.sample.data.Sample1.sample2(Sample1.java:19)</br>
>I'm at com.github.kentan.logadder.sample.data.Sample2.sample(Sample2.java:6)</br>
>I'm at com.github.kentan.logadder.sample.data.Sample2.sample2(Sample2.java:11)</br>

#License
Offered under the GNU Lesser General Public License: COPYING.LESSER, COPYING.</br>
LogAdder uses JavaParser(https://github.com/javaparser/javaparser). </br>
