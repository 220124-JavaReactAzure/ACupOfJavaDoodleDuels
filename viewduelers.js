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
        showSlides();
    });

    var slideIndex = 0;

    function showSlides() {
        if (slideIndex >= viewmyduelers.yourDuelers[i].length) {slideIndex = 0}
        document.getElementById("duelerName").innerHTML = viewmyduelers.yourDuelers[slideIndex].duelerName;
        document.getElementById("duelerImage").src = viewmyduelers.yourDuelers[slideIndex].duelerImage;
        slideIndex++;  
        setTimeout(showSlides, 10000); // Change image every 10 seconds
      }

    function logout(){
        fetch("https://java-doodle-duels.azurewebsites.net/logout")
            .then(function loginPage(){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/login.html')
            });
    }
