
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
            newName.classList.add("duelerNames");
            const container = document.getElementById("container");
            const fighterSelect = document.getElementById("fighter");
            console.log(newName);
            console.log(fighterSelect);
            container.insertBefore(newName, fighterSelect);
            const newImg = document.createElement("img")
            newImg.src = viewmyduelers[i].duelerImage;
            newName.classList.add("duelerImages");
            container.insertBefore(newImg, fighterSelect);

            let newFighterOption = document.createElement("option");

            newFighterOption.appendChild(new Option(viewmyduelers[i].duelerName, viewmyduelers[i].duelerName))

            // const nameDropdown = document.createTextNode(viewmyduelers[i].duelerName);
            // newFighterOption.appendChild(nameDropdown);
            // newFighterOption.setAttribute('value', nameDropdown.value);
            document.getElementById("fighter").add(newFighterOption);

        }
    });


//     var htmlElements = "";
// for (var i = 0; i < array.length; i++) {
//    htmlElements += '<div class="box"></div>';
// }
// var viewmyduelers = document.getElementById("duelerImage");
// viewmyduelers.yourDuelers = htmlElements;

function selectDueler(){

    const data = {
        username: a.username,
        duelerName: document.getElementById("fighter").value
    }

    fetch("https://java-doodle-duels.azurewebsites.net/selectDueler",{
        method: 'POST',
        credentials: 'include',
        origin: true,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then(function(response){
        if(response.status === 201){
            window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/homepage.html');
        }else{
            alert("Something terrible happened!");
        }
    });
}
