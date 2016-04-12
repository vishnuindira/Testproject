<!DOCTYPE html>
<html>
<head>
<title>Employee Registration</title>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/style1.css" media="all" />
    <link rel="stylesheet" type="text/css" href="css/demo.css" media="all" />
</head>
<body>
<div class="container">
			<!-- freshdesignweb top bar -->
            <div class="freshdesignweb-top">
                <a href="vishnuin*************" target="_blank">Home</a>
                <span class="right">
                    <a href="http://www.freshdesignweb.com/beautiful-registration-form-with-html5-and-css3.html">
                        
                    </a>
                </span>
                <div class="clr"></div>
            </div><!--/ freshdesignweb top bar -->
			<header>
				<h1></span> Lxi Employee Registration</h1>
            </header>   
           <script type="text/javascript">
    function checkPass()
{
    
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    
    var message = document.getElementById('confirmMessage');
    
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    
    if(pass1.value == pass2.value){
       
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
    }
    
    else{
       
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  
    </script>   
                
      <div  class="form">
    		<form id="contactform" action="RegisterServlet" method="POST"> 
    			
    			<input id="name" name="firstName" placeholder="*First and last name" required="" tabindex="1" type="text"> 
    			 
    			
    			<input id="email" name="email" placeholder="*example@domain.com" required="" type="email"> 
                
                
    			<input id="username" name="userId" placeholder="*userId" required="" tabindex="2" type="text"> 
    			 
                
    			<input type="password" id="pass1" name="password" placeholder="*password"required=""> 
                
    			<input type="password" id="pass2" name="repassword" placeholder="*confirm it" required="" onkeyup="checkPass(); return false;"> 
        
      
      <center><input class="buttom" name="submit" id="submit" tabindex="5" value="Sign me up!" type="submit"></center> 	 
   </form> 
</div>      
</div>

</body>
</html>
