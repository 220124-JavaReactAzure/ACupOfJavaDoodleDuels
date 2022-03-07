var blobImage
const reader = new FileReader();

function randomNum() {
    let random = Math.floor(Math.random() * 16) + 3;

    return random;
}

const stats = ["constitution", "wisdom", "strength", "dexterity", "intelligence", "charisma"];

for(let s in stats) {
    document.getElementById(`${stats[s]}Stat`).innerHTML = randomNum();
}

const testSkills = ["skill1", "skill2", "skill3"];

for(let t in testSkills) {
    let s1 = document.getElementById("skillOne");
    let s2 = document.getElementById("skillTwo");
    let s3 = document.getElementById("skillThree");

    let newOption1 = document.createElement("option");
    let newOption2 = document.createElement("option");
    let newOption3 = document.createElement("option");

    newOption1.text = testSkills[t];
    newOption2.text = testSkills[t];
    newOption3.text = testSkills[t];

    s1.add(newOption1);
    s2.add(newOption2);
    s3.add(newOption3);
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
        duelerName: document.getElementById("character-name").value,
        accountNumber: 1,  
	    duelerImage: blobImage,   
    	strength: document.getElementById("strengthStat").innerHTML,
	    dexterity: document.getElementById("dexterityStat").innerHTML,
    	constitution: document.getElementById("constitutionStat").innerHTML,
	    wisdom: document.getElementById("wisdomStat").innerHTML,
    	intelligence: document.getElementById("intelligenceStat").innerHTML,
	    charisma: document.getElementById("charismaStat").innerHTML,
    	maxHealth: 30 + Number(document.getElementById("constitutionStat").innerHTML),
	    maxMana: 30 + Number(document.getElementById("wisdomStat").innerHTML),
    	skillOne: document.getElementById("skillOne").value,
	    skillTwo: document.getElementById("skillTwo").value,
	    skillThree: document.getElementById("skillThree").value, 
	    isDummy: false
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


