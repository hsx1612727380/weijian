     function login(){  
      var userName=document.getElementById("userName").value;  
      var pwd=document.getElementById("pwd").value;  
      var repwd=document.getElementById("repwd").value;  
      var address=document.getElementById("address").value;  
      var matchResult=true;  
      if(userName==""||pwd==""||repwd==""||address==""){  
            alert("请确认是否有空缺项！");  
            matchResult=false;  
      }else if(userName.length<6||userName.length>20){  
            alert("用户名长度应在6到20个字符之间！");  
            matchResult=false;  
      }else if(userName==pwd||userName==repwd){  
            alert("密码或重复密码不能和用户名相同！");  
            matchResult=false;  
      }else if(pwd.length<6||pwd.length>20||repwd.length<6||repwd.length>20){  
            alert("密码或重复密码长度应在6到20个字符之间！");  
            matchResult=false;  
      }else if(pwd!=repwd){  
            alert("密码和重复密码不同，请重新输入！");  
            matchResult=false;  
      }else if(userName.length<6||userName.length>20){  
            alert("用户名长度应在6到20个字符之间！");  
            matchResult=false;  
      }  
  
       if(matchResult==true){  
        var mailreg = /^\w+@\w+(\.\w+)+$/;  
        if(!address.match(mailreg)){  
            alert("邮箱格式不正确");  
            matchResult=false;  
        }  
           }  
  
      
      if(matchResult==true){  
           if(userName.charAt(0)>=0&&userName.charAt(0)<=9){  
                alert("用户名不能以数字字符开始！");  
                matchResult=false;  
            }  
      }  
  
      return matchResult;  
     }  
     function adminLogin()
     {
         var userName=document.getElementById("userName").value;  
         var pwd=document.getElementById("pwd").value; 
         alert()
     }
