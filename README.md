# About

This is the code repository for the final project from my CSCI-209 Software Development class, named "Picasso". The application works by taking a user input in the form of a mathematical expression. The program will then draw a picture based on the mathematical expression provided and display the result on the canvas. An example input would be "sin(x)". The program will evaluate the sin() at every x coordinate on the canvas, giving each pixel a color based on the result. There are a wide range of functions available.

My team and I were first tasked with expanding the Picasso language. At first, there were only 2 available functions in the original codebase. We added several new functions that can now be utilized by the user, now totaling over 20. My team and I also implemented assignments, which allows the user to assign variable names to functions. The final task was to add 3 different "extensions", which are documented below. Throughout, we also wrote extensive unit test functions using JUnit to ensure the code was running correctly.

This project helped me become a more confident programmer, and it also introduced me to the software development process. I gained a lot of experience regarding the development workflow, as well as how to effectively communicate ideas and design decisions with teammates. Overall, I had a great time working on this project with my teammates.

# Picasso

An application that allows the user to create expressions that
evaluate to colors and then eventually to images.


## Project Organization

`src` - the source code for the project

`conf` - the configuration files for the project

`doc` - the Javadocs for the project

The `images` directory contains some sample images generated from Picasso.  Some of the expressions for these images can be found in the `expressions` directory.

## Team Member Names

Jackson Jacobs <br />
Patrick Stoffel <br />
Dan Nguyen <br />
Dario Fumarola

## Extensions

1) Generate Expressions Randomly: There is a "Random!" button on the top part of the Frame which, when clicked, will create a random function in the text box also in the top part of the frame. From there, all the user needs to do is hit evaluate and the evaluated random function will appear in the frame. <br />

2) Display Current Defined Variable Names and Their Values: First the user will type a variable and assign it a function in the text box and click evaluate. Then click refresh variables and a side window with both the variable and the assigned function will appear. <br />

3) Allow User to View Multiple Images at Once: There is a button on the bottom part of the Frame which, when clicked, will create another window that will have its own functionality to display a different image than the original window.
