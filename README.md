# triangle
Implementation of triangle challenge

## The problem
Write a program that will determine the type of a triangle. It should take the lengths of the triangle's three sides as input, and return whether the triangle is equilateral, isosceles or scalene.

## How to run
This is a maven project. Use the following command to run tests:
```bash
mvn test
```
to run the TriangleDemo app use the following command:
```bash
 java -cp target/classes com.vizog.triangle.TriangleDemo
```

## Brief discussion
I have used TDD in design of this application. Detection of triangle type and instantiation is done by a factory class 
called TriangleFactory. 
This class uses various validator types (one for each type of triangle) to check if the given side values match the specific type.
 The matching check is done with order of being more specific (Equilateral > Isosceles > Scalene)
 Sanity checking the inputs and asserting the [Triangle Inequality Theorem](https://www.varsitytutors.com/hotmath/hotmath_help/topics/triangle-inequality-theorem)
  is performed by the base class TriangleValidator.
  This checking cannot be overruled because the only way to instantiate the triangles outside the library package is by
   TriangleFactory static methods which ensure the validation.
  
  
  
 