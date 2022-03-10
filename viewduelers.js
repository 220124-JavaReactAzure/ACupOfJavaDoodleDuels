var viewmyduelers
fetch("https://java-doodle-duels.azurewebsites.net/viewDuelers")
    .then(response => {
        return response.json();
    }).then(data => {
        console.log(data);
        viewmyduelers = data;
        console.log(viewmyduelers);
    }).then(function fillInfo(){
        console.log(viewmyduelers);
        document.getElementById("duelerName").innerHTML = viewmyduelers.yourDuelers[i].duelerName;
        document.getElementById("duelerImage").src = viewmyduelers.yourDuelers[i].duelerImage;
        showhtmlElements();
    });

    var htmlElements = "";
for (var i = 0; i < array.length; i++) {
   htmlElements += '<div class="box"></div>';
}
var viewmyduelers = document.getElementById("duelerImage");
viewmyduelers.yourDuelers = htmlElements;

    function logout(){
        fetch("https://java-doodle-duels.azurewebsites.net/logout")
            .then(function loginPage(){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/login.html')
            });
    }
