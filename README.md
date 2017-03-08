#### travelcorp
### Home test

## Hi, 
 Thanks for giving this opportunity to take the test. I tried my best to follow the **SOLID** and **TDD** Principles while developing this 
coding task. Please look into this repository (**travelcorp**) and branch **SEKHAR_KARRI**.
 The code itself is self explanatory and written the test cases for moft of the scenarios.
# Assumptions & steps to test:
 + **Java 8** as source compiler added this `pom.xml`.
 + Please have **maven** installed in your system before checking the solution by running maven command.
 + Please run the command `mvn clean install` on the project root directory, all tests should pass.

# files description:
 * Test file `ShoppingCartImplTest.java` describes the test for adding items to the cart and calculating the 
   generated bill with discounts.
 * Test file `HappySalesDiscountCalculatorImplTest.java` test the end point or interface for only the Discount
   on items.

# Note
 * followed the constuctor **Dependency injection** to inject the discount calculator in the billing implementation class.
 * **Interface Segragation** principle followed by including only the related method's in the interface `Cart`.
 + Followed **Open closed priniciple** by abstract class Item and abstract method `getItemDiscount` which is free for own implementation
   in the implementation classes.
 - **Liskov substitution** principle by Item and derived class.
 + **Single responsibility** principle between the DiscountCalculator and it's implementation `HappySalesDiscountCalculatorImpl`

# Blogs followed/Referred:
  * http://joelabrahamsson.com/a-simple-example-of-the-openclosed-principle/
  * http://www.oodesign.com/single-responsibility-principle.html


