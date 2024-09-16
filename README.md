# Vehicle Registration Application

This program takes a file of unregistered vehicles and creates new registration numbers for those areas where
registration is possible.

The requirements for the app are also in the repo in `Coding Challenge`.

## Installation

To install git clone this repository and run within an IDE - e.g. Eclipse or Intellij. In this initial version running
the program outside an IDE is not supported. The program was built on Java 17 so please use a JDK of this or above.

## Running the Program

As above, the program can only be run using an IDE. The class with the main method is `VehicleManager` - so please run this class.

## User Guide

When the program runs, the user is prompted for to confirm which option of the following options they want to run.

```
Choose an option
1. Generate Vehicle Registration Numbers
2. Total Number of Registration Numbers Generated
3. Total Number of Registration Numbers Generated per Registration Area
4. Could Any Registration Numbers Not Be Generated? How Many?
5. Exit

```

## Limitations Of Version 1.0

This version has the following limitations:

1 - The input file is hard coded and in the repo - a future version could allow the user to specify their own file name 
in a future version.

2 - The registration results are only displayable in the screen - a future version could allow the user to save the
data to an output file. As the data can be large (100,000+ rows) it is obvious that writing the results just to screen
is not viable for the real application.

3 - The user interface is command line only - it is more likely that the real app would have a web-GUI and a server
component which would avoid local installs and allow users to run the app remotely.

