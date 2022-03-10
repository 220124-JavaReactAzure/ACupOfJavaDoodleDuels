
a = JSON.parse((localStorage.getItem("current_user")));
console.log(a.username);
var viewmyduelers
var curUser = {
    username: a.username
}
fetch("https://java-doodle-duels.azurewebsites.net/viewDuelers",{
        method: 'POST',
        credentials: 'include',
        origin: true,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(curUser)
    })
    .then(response => {
        return response.json();
    }).then(data => {
        viewmyduelers = data;
        console.log(viewmyduelers);
    }).then(function fillInfo(){
        console.log(viewmyduelers);
        for(let i = 0; i< viewmyduelers.yourDuelers.length; i++){
            const newName = document.createElement("div")
            const name = document.createTextNode(viewmyduelers.yourDuelers[i].duelerName);
            newName.appendChild(name);
            document.getElementById('container').innerHTML += newName;
        }
    });


    var htmlElements = "";
for (var i = 0; i < array.length; i++) {
   htmlElements += '<div class="box"></div>';
}
var viewmyduelers = document.getElementById("duelerImage");
viewmyduelers.yourDuelers = htmlElements;
