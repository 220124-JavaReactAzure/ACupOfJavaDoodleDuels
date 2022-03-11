a = JSON.parse(localStorage.getItem("current_user"));
console.log(a.username);
var skills;
var curUser = {
  username: a.username,
};

fetch("https://java-doodle-duels.azurewebsites.net/getSkills", {
  method: "POST",
  credentials: "include",
  origin: true,
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify(curUser),
})
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    console.log(document.cookie);
    skills = data;
    console.log(skills);
  })
  .then(function fillInfo() {
    console.log(skills);
    for (let i = 1; i < 4; i++) {
      let currentSelect = document.getElementById(`skill${i}`);
      for (let j = 0; j < skills.allSkills.length; j++) {
        let newSkillOption = document.createElement("option");
        let optionText = document.createTextNode(skills.allSkills[j].skillName);

        newSkillOption.appendChild(optionText);
        newSkillOption.setAttribute("value", `${optionText}`);
        currentSelect.add(newSkillOption);
      }
    }

    for (let k = 0; k < skills.allSkills.length; k++) {
      let newDiv = document.createElement("div");
      let newH4 = document.createElement("H4");
      let newP = document.createElement("p");
      let skillNameText = document.createTextNode(skills.allSkills[k].skillName);
      let skillDescText = document.createTextNode(skills.allSkills[k].description);

      switch (skills.allSkills[k].damageStatType) {
        case "strength":
          let strengthCategory = document.getElementById("strengthCategory");
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          strengthCategory.add(newDiv);
          break;
        case "dexterity":
          let dexterityCategory = document.getElementById("dexterityCategory");
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          dexterityCategory.add(newDiv);
          break;
        case "constitution":
          let constitutionCategory = document.getElementById(
            "constitutionCategory"
          );
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          constitutionCategory.add(newDiv);
          break;
        case "intelligence":
          let intelligenceCategory = document.getElementById(
            "intelligenceCategory"
          );
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          intelligenceCategory.add(newDiv);
          break;
        case "wisdom":
          let wisdomCategory = document.getElementById("wisdomCategory");
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          wisdomCategory.add(newDiv);
          break;
        case "charisma":
          let charismaCategory = document.getElementById("charismaCategory");
          newH4.appendChild(skillNameText);
          newP.appendChild(skillDescText);

          newDiv.add(newH4);
          newDiv.add(newP);
          charismaCategory.add(newDiv);
          break;
      }
    }
  });

var blobImage;
const reader = new FileReader();

function randomNum() {
  let random = Math.floor(Math.random() * 16) + 3;

  return random;
}

function randomHPMP() {
  let random = Math.floor(Math.random() * 20) + 30;
  return random;
}

const stats = [
  "constitution",
  "wisdom",
  "strength",
  "dexterity",
  "intelligence",
  "charisma",
];

for (let s in stats) {
  document.getElementById(`${stats[s]}Stat`).innerHTML = randomNum();
}

document.getElementById("hp").innerHTML =
  randomHPMP() + Number(document.getElementById("constitutionStat").innerHTML);
document.getElementById("mp").innerHTML =
  randomHPMP() + Number(document.getElementById("wisdomStat").innerHTML);

document.getElementById("character-img").onchange = (evt) => {
  const [file] = document.getElementById("character-img").files;
  if (file) {
    document.getElementById("previewImgHeader").style.display = "block";
    document.getElementById("previewImg").src = URL.createObjectURL(file);
    document.getElementById("previewImg").style.display = "block";
    console.log(file);
    const formdata = new FormData();
    formdata.append("image", file);
    fetch("https://api.imgur.com/3/image/", {
      method: "post",
      headers: {
        Authorization: "Client-ID ac8deb7f4d99ebb",
      },
      body: formdata,
    })
      .then((data) => data.json())
      .then((data) => {
        blobImage = data.data.link;
        console.log(blobImage);
      });
    console.log(blobImage);
  }
};

function postDueler() {
  let errors = false;
  let error_message = "";

  if (document.getElementById("character-name").value.trim() === "") {
    errors = true;
    error_message +=
      "You gave invalid input for your character name. Please provide a name for your character.\n\n";
  }

  if (document.getElementById("character-img").files.length === 0) {
    errors = true;
    error_message +=
      "You did not supply an image for your character. Please give us an image to associate with your character.\n\n";
  }

  if (
    document.getElementById("skill1").value === "Choose a Skill" ||
    document.getElementById("skill2").value === "Choose a Skill" ||
    document.getElementById("skill3").value === "Choose a Skill"
  ) {
    errors = true;
    error_message +=
      "You did not choose one or more skills for your character. Please make sure you choose your skills for your character.\n\n";
  }

  if (errors == true) {
    alert(error_message);
  } else {
    const data = {
      duelerName: document.getElementById("character-name").value,
      accountNumber: skills.userID,
      duelerImage: blobImage,
      strength: document.getElementById("strengthStat").innerHTML,
      dexterity: document.getElementById("dexterityStat").innerHTML,
      constitution: document.getElementById("constitutionStat").innerHTML,
      wisdom: document.getElementById("wisdomStat").innerHTML,
      intelligence: document.getElementById("intelligenceStat").innerHTML,
      charisma: document.getElementById("charismaStat").innerHTML,
      maxHealth: document.getElementById("hp").innerHTML,
      maxMana: document.getElementById("mp").innerHTML,
      skillOne: document.getElementById("skill1").value,
      skillTwo: document.getElementById("skill2").value,
      skillThree: document.getElementById("skill3").value,
      isDummy: false,
    };
    fetch("https://java-doodle-duels.azurewebsites.net/createDueler", {
      method: "POST",
      credentials: "include",
      origin: true,
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((response) => {
        return response.json();
      })
      .then(function (response) {
        if (response.status === 201) {
          window.location.replace(
            "https://javadoodleduels.blob.core.windows.net/$web/homepage.html"
          );
        } else {
          alert("Dueler name is taken!");
        }
      });
  }
}
