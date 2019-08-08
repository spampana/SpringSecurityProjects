In some scenarios we might want to redirect different users to different pages depending on the roles assigned to the users.
<br/>
For example 
we might want users with role USER to be redirected to the welcome page, 
while users with role ADMIN to be redirected to the add employee page.
<br/>
We will be making use of the AuthenticationSuccessHandler.
<br/>

Go to localhost:8080/welcome, we will be redirected to the custom login page. 
br/>
<img src="https://www.javainuse.com/boot-36_1.jpg"/>
<br/>

Enter the user admin and password admin, user is redirected to the add employee page. 
br/>
<img src="https://www.javainuse.com/boot-35_9.jpg"/>
<br/>

Enter the user employee and password employee, user is redirected to the welcome page. 
<br/>
<img src="https://www.javainuse.com/boot-35_3.jpg"/>
<br/>
