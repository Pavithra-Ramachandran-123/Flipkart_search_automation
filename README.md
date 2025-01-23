Demo Recording : 

# Flipkart Automation Project

This project automates the Flipkart website to extract information about various products based on different criteria. We perform searches for specific items, filter them based on ratings or discounts, and then extract details such as product titles, prices, and reviews.

## Tools Used
- **Java** (Programming language)
- **Selenium WebDriver** (For automating web interactions)
- **TestNG** (For running tests and generating reports)
- **Gradle** (For managing dependencies and building the project)

## Setup

1. Clone the repository:
     git clone <repository-url>
2. Navigate to the project directory:
     cd <project-directory>
3. Install dependencies using Gradle:
     gradle build
4. Ensure that the necessary WebDriver version is compatible with your browser. Update WebDriverManager if needed.

##Test Cases

###testCase01: Search "Washing Machine" and count items with a rating of 4 stars or less
Go to www.flipkart.com.
Search for "Washing Machine".
Sort the results by popularity.
Print the count of items with a rating of 4 stars or below.

-----------------------------------------------------------------------------------------------------------------------------------------

###testCase02: Search "iPhone" and print titles and discount percentage
Search for "iPhone".
Print the product titles and discount percentage for items that have a discount greater than 17%.

-----------------------------------------------------------------------------------------------------------------------------------------

###testCase03: Search "Coffee Mug" with 4 stars and above, and print the Title and image URL of the 5 items with the highest number of reviews
Search for "Coffee Mug".
Filter the results to show items with 4 stars and above.
Print the title and image URL of the 5 items with the highest number of reviews.

------------------------------------------------------------------------------------------------------------------------------------------

###Execution
To run the tests, use the following Gradle command: gradle test

------------------------------------------------------------------------------------------------------------------------------------------


