function GetUsername() {

     fetch("https://java-doodle-duels.azurewebsites.net/registration", {
            method: "get",
            headers: {
                'Content-Type': 'application/json'
            }).then(response => {
                return response.json();
            }).then(data => {
                console.log(data);
                username = data;
                console.log(username);
            }).then(function fillInfo(){
                console.log(username);
                document.getElementById("username").innerHTML = username.updateUser.authUser;
                
               
            });

            $.ajax({
                type : "GET",
                url :"https://java-doodle-duels.azurewebsites.net/registration",
                contentType: "application/json",
                dataType: "json",
                success : function (data, status) {
            
                },
                error : function (status) {
                 
                }
            });