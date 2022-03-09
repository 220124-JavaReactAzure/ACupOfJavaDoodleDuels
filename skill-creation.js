var blobImage
const reader = new FileReader();

function randomNum() {
    let random = Math.floor(Math.random() * 16) + 3;

    return random;
}

const stats = ["skill", "requirement", "baseDamage", "scalingDamage", "intescalingRequirement"];

for(let s in stats) {
    document.getElementById(`${stats[s]}Stat`).innerHTML = randomNum();
}


document.getElementById("character-img").onchange = evt => {
    const [file] = document.getElementById("character-img").files;
    if (file) {
        document.getElementById("previewImgHeader").style.display = "block";
        document.getElementById("previewImg").src = URL.createObjectURL(file);
        document.getElementById("previewImg").style.display = "block";
        console.log(file);
        const formdata = new FormData()
        formdata.append("image", file)
        fetch("https://api.imgur.com/3/image/", {
                method: "post",
                headers: {
                    Authorization: "Client-ID ac8deb7f4d99ebb"
                },
                body: formdata
            }).then(data => data.json()).then(data => {
                blobImage = data.data.link
                console.log(blobImage);
            })
        console.log(blobImage);
    }
  }

function postDueler(){
    const data = {
        duelerName: document.getElementById("skill-name").value,
        accountNumber: 1,  
	    duelerImage: blobImage,   
    	skill: document.getElementById("skill-type").innerHTML,
	    requirement: document.getElementById("skill-stat-req").innerHTML,
    	baseDamage:  document.getElementById("skill-base-damage").innerHTML,
	    scalingDamage: document.getElementById("skill-scaling-damage").innerHTML,
    	scalingRequirement: document.getElementById("skill-scaling-req").innerHTML,
    }  
    console.log(data);
    const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json',
                   'Access-Control-Allow-Origin': 'http://localhost:6060',
                   'Access-Control-Allow-Methods':'GET, OPTIONS, POST, PUT'},
        body: JSON.stringify(data)
    };
    fetch('http://localhost:6060/createDueler', requestOptions);
    
}


