function selectDueler(){

    const data = {
        duelerName: document.getElementById("add-dummy").value
    }

    fetch("https://java-doodle-duels.azurewebsites.net/add-dummy",{
        method: 'POST',
        credentials: 'include',
        origin: true,
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then(function(response){
        if(response.status === 201){
            window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/employee-test-home.html');
        }else{
            alert("Dueler name not found!");
        }
    });
}