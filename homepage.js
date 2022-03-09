var fighters
fetch("https://java-doodle-duels.azurewebsites.net/imageCarousel")
    .then(response => {
        return response.json();
    }).then(data => {
        console.log(data);
        fighters = data;
        console.log(fighters);
    }).then(function fillInfo(){
        console.log(fighters);
        document.getElementById("duelerName").innerHTML = fighters.randomDuelers[0].duelerName;
        document.getElementById("duelerImage").src = fighters.randomDuelers[0].duelerImage;
        showSlides();
    });
    
    
    var slideIndex = 0;

    function showSlides() {
        if (slideIndex >= fighters.randomDuelers.length) {slideIndex = 0}
        document.getElementById("duelerName").innerHTML = fighters.randomDuelers[slideIndex].duelerName;
        document.getElementById("duelerImage").src = fighters.randomDuelers[slideIndex].duelerImage;
        slideIndex++;  
        setTimeout(showSlides, 3000); // Change image every 3 seconds
      }

    function logout(){
        fetch("https://java-doodle-duels.azurewebsites.net/logout")
            .then(function loginPage(){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/login.html')
            });
    }

