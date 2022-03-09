login.js

function login(){
    if(document.getElementById("username").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("pass").value.trim() === ""){
        alert("All input fields must be filled!");
    }else{
        const data = {
            username: document.getElementById("username").value,
    	    password: document.getElementById("pass").value
        }
        fetch("https://java-doodle-duels.azurewebsites.net/login", {
            method: "post",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(function(response){
            if(response.status === 202){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/employee-test-home.html');
            }else if(response.status === 200){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/homepage.html')
            }else{
                alert("Username or password is incorrect!");
            }
        });
    }
  
}