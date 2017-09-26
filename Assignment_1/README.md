# Assignment 1

Counting how many **issues** solved in collection of Java Source Code files.

Date Completed: **24 September 2017**

# Method Uses for Counting Issues 

- Identify if there is any Java Class used to:
  1. **Instantiate Object**
  2. **Inherited Class** (Concrete & Abstract)
  3. **Implemented Class** (Interface)

- Any class that use for the listed usage is considered as a single program.

# System Requirements

- All **Windows** Edition compatible with Java & **Netbeans**.
- **MacOS/UNIX may not work** due to differences in folder directory path handling. 

# How to use?

1. Clone this repository
2. Use **Open Project** feature in **Netbeans**
3. Open the **FindIssues** project folder.
4. Place Java files in directory **FindIssues\KATSINI**
5. **Run** the Project. 

**Sample** Running **Output**:
 
<kbd>![Output Image](https://github.com/wzul/237767/blob/master/Assignment_1/FindIssues/sample-running-output.png "Sample Running Output")</kbd>

# The Techniques

1. Get the **current working directory**.
2. Get **list of file name** in working directory recursively.
3. **Read each of the files** and store it to array.
4. Get all **Class** and **Interface** Name (Includes Abstract Class).
5. Check **each Class Name and Interface name** in **all files** (except the class own file) if they are used in Object Instantiation (**new << Class Name >>)** or Inherited (**extends**) or Implemented (**implements**).
6. Based on detected results, **decrement the number of files** (if any).


# Known Bugs

- The program will wrongly detect if there is a code like the three method in **Comments**.
- The program will wrongly detect if there is an **multiple implementation of interface** class.

# References

1. https://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
2. https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder
3. https://dzone.com/articles/java-example-list-all-files
4. https://alvinalexander.com/blog/post/java/create-files-in-directory
5. https://www.ntu.edu.sg/home/ehchua/programming/java/Java_Regexe.html
