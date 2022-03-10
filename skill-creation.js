

function createSkill(){
    if(document.getElementById("skill-name").value.trim() === ""){
        console.log(document.getElementById("description").value)
        alert("All input fields must be filled!");
    }else if(document.getElementById("skill-base-damage").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("skill-type").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("skill-scaling-damage").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("skill-scaling-req").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("description").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("healing").value.trim() === ""){
        alert("All input fields must be filled!");
    }else if(document.getElementById("manaCost").value.trim() === ""){
        alert("All input fields must be filled!");
    }else{
        const data = {
            skillName: document.getElementById("skill-name").value,
            damage: document.getElementById("skill-base-damage").value,  
    	    damageStatType: document.getElementById("skill-type").value,   
        	scaledDamage: document.getElementById("skill-scaling-damage").value,
	        scalingRequirement: document.getElementById("skill-scaling-req").value,
        	description:  document.getElementById("description").value,
	        healing: document.getElementById("healing").value,
    	    manaCost: document.getElementById("manaCost").value,
        }  
        fetch("https://java-doodle-duels.azurewebsites.net/createSkill", {
            method: "post",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(function(response){
            if(response.status === 201){
                window.location.replace('https://javadoodleduels.blob.core.windows.net/$web/employee-test-home.html');
            }else{
                alert("Skill name is taken!");
            }
        });
    } 
}


