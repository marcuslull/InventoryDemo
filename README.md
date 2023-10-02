# TASK 1: Web Based Spring Inventory Application

---
Marcus Lull  
10/01/2023  
D287 Java Frameworks

## Change Log


### Part C
**Prompt:** Customize the HTML user interface for your customer’s application. The user interface should include the
shop name, the product names, and the names of the parts.  
**File name:** mainscreen.html  
**Lines:** 14, 19, 21, 53  
**Change:** Updating title, shop name, parts title, and products title.

### Part D
**Prompt:** Add an “About” page to the application to describe your chosen customer’s company to web viewers and include
navigation to and from the “About” page and the main screen.  
**File name:** mainscreen.html, AboutController.java, about.html  
**Line:** mainscreen.html - line 20. AboutController.java - new file. about.html - new file  
**Change:** Created a new about html document and about controller with links to and from the mainscreen.html document.
Added about text with formatting elements to about.html

### Part E
**Prompt:** Add a sample inventory appropriate for your chosen store to the application. You should have five parts and
five products in your sample inventory and should not overwrite existing data in the database.  
**File name:** BootStrapData.java  
**Line:** 28, 36, 42-46, 80-212  
**Change:** Adding data loader method to add example data to the DB

### Part F
**Prompt:** Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
*  The “Buy Now” button must be next to the buttons that update and delete products.
*  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the
* associated parts.
*  Display a message that indicates the success or failure of a purchase.  

**File name:** mainscreen.html, AddProductController.java, falurebuyproduct.html, confirmationbuyproduct.html, ProductService.java, and ProductServiceImpl.java  
**Lines:** mainscreen.html - 86-87, AddProductController.java - 125-137, falurebuyproduct.html - new file, confirmationbuyproduct.html - new file, ProductService.java - 20, ProductServiceImpl.java - 51-64  
**Change:** Adding buy now functionality. Implemented a buyById ProductService method and a /buyproduct endpoint in the AddProductController which decrements the product quantity depending on availability and directs the user to a success/failure page.

### Part G
**Prompt:** Modify the parts to track maximum and minimum inventory by doing the following:
*  Add additional fields to the part entity for maximum and minimum inventory.
*  Modify the sample inventory to include the maximum and minimum fields.
*  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set
* the maximum and minimum values.
*  Rename the file the persistent storage is saved to.
*  Modify the code to enforce that the inventory is between or at the minimum and maximum value.  

**File name:** Part.java, BootStrapData.java, InhousePartForm.html, OutsourcedPartForm.html, AddInhousePartController.java, AddOutsourcedPartController.java  
**Lines:** Part.java - 32-50, InhousePartForm.html - 26-29, OutsourcedPartForm.html - 27-30, AddInhousePartController.java - 52-59, AddOutsourcedPartController.java - 53-60  
**Change:** Adding min/max fields for the part entity as well as the 2 part views. Adding if block to respective controllers to log the constraint violation and return the view.  
**Note:** Code for the last bullet of this prompt is no longer functional. I have commented out the code for your inspection, but it is rendered obsolete/ineffective by my implementation of Part H - Add Validation. Please take this into consideration while grading this part. Thank you!

### Part H
**Prompt:** Add validation for between or at the maximum and minimum fields. The validation must include the following:
*  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
*  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
*  Display error messages when adding and updating parts if the inventory is greater than the maximum.  

**File name:** BootStrapData.java, AddInhousePartController.java, AddOutsourcedPartController.java, AddProductController.java, Part.java, MaxConstraint.java, MaxValidator.java, MinConstraint.java, MinValidator.java, inhousePartForm.html, OutsourcedPartForm.html, productForm.html  
**Lines:** BootStrapData.java - 233, AddInhousePartController.java - 53-59, AddOutsourcedPartController.java - 50-56, AddProductController.java - 54-58, 82-100, Part.java - 21-22, 35, 37, 61-76, MaxConstraint.java - new file, MaxValidator.java - new file, MinConstraint.java - new file, MinValidator.java - new file, inhousePartForm.html - 22-23, 29,32, OutsourcedPartForm.html - 23-24, 30, 33, productForm.html 25-35  
**Change:** Implementing new custom constraint validators for the part class to check that inventory levels are between min/max thresholds. Any validation violations are caught and displayed by the appropriate view. 

### Part I
**Prompt:** Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.  
**File name:** PartTest.java  
**Lines:** 159-180  
**Change:** Adding two unit tests to PartTest.java for the min and max fields of the Part class

### Part J
**Prompt:** Remove the class files for any unused validators in order to clean your code.  
**File name:** ValidDeletePart.java, DeletePartValidator.java, Part.java  
**Line:** ValidDeletePart.java - deleted file, DeletePartValidator.java - deleted file, Part.java - 19  
**Change:** Removed custom validator ValidDeletePart.java and DeletePartValidator.java since this requirement is handled by the if/else in the /deletepart endpoint which returns an error view.

<br>  

***Thank your for your time!***

---
<br>
<br>

<strong>** DO NOT DISTRIBUTE OR PUBLICLY POST SOLUTIONS TO THESE LABS. MAKE ALL FORKS OF THIS REPOSITORY WITH SOLUTION CODE PRIVATE. PLEASE REFER TO THE STUDENT CODE OF CONDUCT AND ETHICAL EXPECTATIONS FOR COLLEGE OF INFORMATION TECHNOLOGY STUDENTS FOR SPECIFICS. ** </strong>

# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
FOR SPECIFIC TASK INSTRUCTIONS AND REQUIREMENTS FOR THIS ASSESSMENT, PLEASE REFER TO THE COURSE PAGE.
## BASIC INSTRUCTIONS
For this project, you will use the Integrated Development Environment (IDE) link in the web links section of this assessment to install the IDE, IntelliJ IDEA (Ultimate Edition). All relevant links are on the course page. Please refer to the course of study for specific links. You will sign up for a free student license using your WGU.edu email address. Please see the “IntelliJ Ultimate Edition Instructions” attachment for instructions on how do this. Next you will download the “Inventory Management Application Template Code” provided in the web links section and open it in IntelliJ IDEA (Ultimate Edition). You will upload this project to a private external GitLab repository and backup regularly. As a part of this, you have been provided with a base code (starting point). 

## SUPPLEMENTAL RESOURCES  
1.	How to clone a project to IntelliJ using Git?

> Ensure that you have Git installed on your system and that IntelliJ is installed using [Toolbox](https://www.jetbrains.com/toolbox-app/). Make sure that you are using version 2022.3.2. Once this has been confirmed, click the clone button and use the 'IntelliJ IDEA (HTTPS)' button. This will open IntelliJ with a prompt to clone the proejct. Save it in a safe location for the directory and press clone. IntelliJ will prompt you for your credentials. Enter in your WGU Credentials and the project will be cloned onto your local machine.  

2. How to create a branch and start Development?

- GitLab method
> Press the '+' button located near your branch name. In the dropdown list, press the 'New branch' button. This will allow you to create a name for your branch. Once the branch has been named, you can select 'Create Branch' to push the branch to your repository.

- IntelliJ method
> In IntelliJ, Go to the 'Git' button on the top toolbar. Select the new branch option and create a name for the branch. Make sure checkout branch is selected and press create. You can now add a commit message and push the new branch to the local repo.

## SUPPORT
If you need additional support, please navigate to the course page and reach out to your course instructor.
## FUTURE USE
Take this opportunity to create or add to a simple resume portfolio to highlight and showcase your work for future use in career search, experience, and education!
