function register(){
    
    if(document.getElementById("form3Example1c").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("form3Example2c").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("form3Example3c").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("form3Example4c").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("form3Example5c").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("form3Example4cd").value.trim() === ""){
        alert("All input fields must be filled!");
    }else{
        if(document.getElementById("form3Example4cd").value.trim() === document.getElementById("form3Example5c").value.trim()){
            const data = {
                firstName: document.getElementById("form3Example1c").value,
                lastName: document.getElementById("form3Example2c").value,
                email: document.getElementById("form3Example3c").value,
                username: document.getElementById("form3Example4c").value,
                password: document.getElementById("form3Example5c").value,
                accountType: "1",
                employeeCode: "",
                currentDuelerName: ""
            }
            fetch("https://java-doodle-duels.azurewebsites.net/registration", {
                method: "post",
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            }).then(function(response){
                if(response.status === 201){
                    alert("Account created!");
                    window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/login.html');
                }else{
                    alert("Username or Email is unavailable!");
                }
            });
        }else{
            alert("Passwords must match!");  
        }
       
    }


    
}