# IS2545 - DELIVERABLE 4: Refractor Conway's Game of Life simulation
### Simiao Wang (pittID: siw20)
***
## Summary:
methods that are refactored:
* ConvertToInt() in MainPanel.java
  * From the VM profile, I found this method takes too much CPU to process, and I took a look at this method and found most code is redundant.
* runContinuous() in MainPanel.java
  * After changing the first method, I run the program again. From the VM profile, I found this method takes too much CPU to process, and I took a look at this method and found most code is redundant.
* toString() in Cell.java
  * From the VM profile, I found this method takes too much CPU to process, and I took a look at this method and found most code is redundant.

Unit Testing:
* 3 test cases for ConvertToInt(), cases including parameters as zero, positive number, negative number.
  * To ensure the returned value is 0 when passed 0
  * To ensure the returned value is 20 when passed 20
  * To ensure the returned value is -20 when passed -20
  * To ensure ConvertToInt() refactoring has no effects on getNumNeighbors()
* 3 test cases for toString(), cases including testing on a live and dead cell.
  * Ensure toString returns X when the cell is alive
  * Ensure toString returns . when the cell is dead
  * Ensure toString returns X when cell is alive and . when the cell is dead in multiple cells case
* Manual Testing for runContinuous(), Because there is no returned value for this method to test on. I just manually run the program and click on "Run Continuous" button.

Snapshot before and after refactoring

* Before
<img src = "img/Pic1.png">
* After
<img src = "img/Pic2.png">
