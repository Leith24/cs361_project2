UTEID: gdl386, dao384
FIRSTNAME: Gavin, Daniel
LASTNAME: Leith, Olvera
CSACCOUNT: gavindl, dolvera1
EMAIL: gavinleith@utexas.edu, daolvera1@gmail.com

Description: In this assignment we modified 6 Java files. In Instruction list, we modified the input instructions to allow for create, destroy, and run. In Type.Java, we added the types for instructions of create, run, and destroy. In ReferenceManager, we added an object list so that we can create objects on the fly for the covert channel. Based on the previous two files, we added methods in ObjectManager (which is a sub class of Reference Manager) to handle the implementations of run, create, and destroy. In CovertChannel, we read in the command prompt arguments. From here, we determine which file we are reading from and if there is a verbose command as an input. If there is a verbose command, we create a log file to record the instructions we input via the covert channel. If there is no verbose command, we continue the covert channel without recording the instructions inputted. Either with or without verbose, we output the results from the information captured by the cover channel into a .out file. After we have established the verbose command and output file, we loop through the reading file. Through this loop, we parse the bytes and then bits for each input in the file. We then push these bits through the covert channel using Lyle and Hal subjects. We create objects on the fly based on the security levels of Lyle and Hal. We then read the information pasted through the channel and output these bits as ASCII characters into the output file. This assignment is compiled by using Java *a.Java.

Machine Info: Linux, Intel, 2792.832 MHz

Source Description: We got the text files for testing from the Project GUtenbery website. We received this link for the post on piazza.

Finish: We finished this assignment completely. However, it is late because Gavin was out of town from Wednesday - Saturday. His WiFi connection was not reliable and he was not able to contribute as much as he would of otherwise.

Results: