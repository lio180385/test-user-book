 
# Steps to Setup
### 1. Clone the application / create Application
 
         https://github.com/lio180385/test-user-book.git   
 
###  2. Create  database
  create database bankdb
    
###  3 .Create Endpoint API CRUD for each table
  ##### Table User
  *GET *  |: ` /users` : |**getAllUser**  <br/>
    
  ![alluser](https://user-images.githubusercontent.com/48851449/155030176-69b21eec-32be-4d6b-a66a-585c5f4cea9d.PNG)<br/>

  *POST*  |: `/users` :  |**CreateUser**  <br/>
  
 ![CreateUser](https://user-images.githubusercontent.com/48851449/155030008-1b65831c-5c1d-45eb-ae17-220d54389be5.PNG)<br/>

 *GET*  |: `/users/{id}` :  |**GetUserById**  <br/>
 ![userbyid](https://user-images.githubusercontent.com/48851449/155029789-a11d99d6-6644-433e-a68e-567f249147f4.PNG)<br/>

   *PUT*  |: `/users/{id}` :  |**UpdateUser**  <br/>
   
   ![Update User](https://user-images.githubusercontent.com/48851449/155029569-859c240b-a426-4c10-8417-59870e6ca2d7.PNG)<br/>

         
   *DELETE*  |: `/users/{id}` :  |**DeleteUser** <br/>
          
  ![deleteuser](https://user-images.githubusercontent.com/48851449/155029331-24ce2777-0b30-4af7-8f39-f74e2bdd8531.PNG) 
  ##### Table Book
  *GET *  |: `/userandbook/all` : |**getAllBook** <br/>
        
   ![allbook](https://user-images.githubusercontent.com/48851449/155030364-508e1518-6c27-4a9c-b211-861ea702e3cb.PNG))<br/>
     
   *POST*  |: `/userandbook` :  |**CreateUser** <br/>
   
   ![createbook](https://user-images.githubusercontent.com/48851449/155030785-ac5307a8-4591-4fdd-b05a-7aaaa1dd093a.PNG))<br/>

   
   *GET*  |: `/books/{id}` :  |**GetBookById** <br/>
   
   ![bookid](https://user-images.githubusercontent.com/48851449/155031113-80b6f1f0-905d-4156-919b-2e667d4ed71d.PNG))<br/>

   
   *PUT*  |: `/books/{id}` :  |**UpdateBook** <br/>
    ![updatebook](https://user-images.githubusercontent.com/48851449/155031408-973cf7c9-7317-4a06-b2cd-387b8ebe8051.PNG)

       
 *DELETE*  |: `/book/{id}` :  |**DeleteBook** <br/>
  ![deletebook](https://user-images.githubusercontent.com/48851449/155031623-86d7aae8-7a0d-4c96-a5fd-f8196fd7b182.PNG)

       
 ### 4. Create End Point API & Generate book content on table into pdf
 
 
 GET  | /books/export/pdf
 
 ![image](https://user-images.githubusercontent.com/48851449/155029067-1b9a867a-0866-4fd1-b570-5b52256b74e9.png)

 
### 5. Unit test (optional, additional poin)
 ![unitTesting](https://user-images.githubusercontent.com/48851449/155028594-4fc646cc-7eac-4d76-8e07-57c66c51f325.PNG)


The app will start running at http://localhost:8089.
