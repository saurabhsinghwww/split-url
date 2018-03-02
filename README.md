# URL Splitting Algorithms

- The program use to split a URL to parts: scheme, host, port, path and parameters.
- The program read the URL from command line.
- The program implemented 2 splitting algorithms and compare their performance.
- The first algorithm use regular expressions.
- The second algorithm based on a state machine.
- The program run 10000 iterations of each algorithm.
- The program output URL parts and runtimes of both algorithms.

## To run the program
- mvn clean install
- java -jar target/split.url-0.0.1-SNAPSHOT-jar-with-dependencies.jar "http://host:8090/path?params"
