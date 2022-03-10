
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
        for(let i = 0; i< viewmyduelers.length; i++){
            const newName = document.createElement("p")
            const name = document.createTextNode(viewmyduelers[i].duelerName);
            newName.appendChild(name);
            const currentDiv = document.getElementById("container");
            console.log(newName);
            console.log(currentDiv);
            document.main.insertBefore(newName, currentDiv);
            const newImg = document.createElement("img")
            const img = document.createTextNode(viewmyduelers[i].duelerImage);
            newName.appendChild(img);
            document.main.insertBefore(img, currentDiv);
        }
    });


//     var htmlElements = "";
// for (var i = 0; i < array.length; i++) {
//    htmlElements += '<div class="box"></div>';
// }
// var viewmyduelers = document.getElementById("duelerImage");
// viewmyduelers.yourDuelers = htmlElements;
