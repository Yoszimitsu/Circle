# Concurrency App

The application uses concurrency in Java language. The app simulate circles movement and display it on a window.  

![](resources/images/window.png)


Used:
- JFrame class
- JPanel class

The application is implemented for 3 cases: single-thread, multi-thread and multi-thread using Executor Service.  
Below it's presented comparison for 1000 circles, from JProfiler plugin, for those versions. 

### Overview usage:  
Single mode:  

![](resources/images/single_overview.png)

Multi mode:

![](resources/images/multi_overview.png)

Executor Service mode:

![](resources/images/executor_overview.png)

### Memory usage:  
Single mode:  

![](resources/images/single_memory.png)

Multi mode:

![](resources/images/multi_memory.png)

Executor Service mode:

![](resources/images/executor_memory.png)

### Live memory usage:  
Single mode:  

![](resources/images/single_live_memory.png)

Multi mode:

![](resources/images/multi_live_memory.png)

Executor Service mode:

![](resources/images/executor_live_memory.png)

### Thread history:  
Single mode:  

![](resources/images/single_thread_history.png)

Multi mode:

![](resources/images/multi_thread_history.png)

Executor Service mode:

![](resources/images/executor_thread_history.png)

### Call Tree:  
Single mode:  

![](resources/images/single_call_tree.png)

Multi mode:

![](resources/images/multi_call_tree.png)

Executor Service mode:

![](resources/images/executor_call_tree.png)


